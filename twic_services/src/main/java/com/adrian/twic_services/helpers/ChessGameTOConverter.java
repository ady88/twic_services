package com.adrian.twic_services.helpers;

import com.adrian.twic_services.enums.ChessMetadataFieldNames;
import com.adrian.twic_services_commons.enums.ChessGameResult;
import com.adrian.twic_services_commons.enums.ChessPlayerTitle;
import com.adrian.twic_services_commons.transferobjects.ChessGameTO;
import com.adrian.twic_services_commons.transferobjects.ChessMetadataTO;
import com.adrian.twic_services_commons.transferobjects.ChessMoveTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public class ChessGameTOConverter {

    private static final Logger LOG = Logger.getLogger(ChessGameTOConverter.class.getName());

    private static final String EMPTY_INTERMEDIATE_GAME_MESSAGE = "Intermediate format chess game should not be empty at this point.";
    private static final String NO_SUCH_METADATA_MESSAGE = "The metadata field %s does not exist.";

    public static List<ChessGameTO> convertIntermediatChessGamesToChessGamesTO(final List<ChessGameIntermediateFormat> intermediateFormatChessGames) {

        if (CollectionUtils.isEmpty(intermediateFormatChessGames)) {
            return null;
        }

        List<ChessGameTO> chessGames = new ArrayList<>();

        for (ChessGameIntermediateFormat intermediateFormatGame : intermediateFormatChessGames) {
            final ChessGameTO chessGame = convertIntermediatChessGameToChessGameTO(intermediateFormatGame);
            chessGames.add(chessGame);
        }

        return chessGames;
    }

    public static ChessGameTO convertIntermediatChessGameToChessGameTO(final ChessGameIntermediateFormat intermediateFormatChessGame) {

        ChessMetadataTO metadata = new ChessMetadataTO();
        List<ChessMoveTO> moves = new ArrayList<>();

        if (intermediateFormatChessGame == null || CollectionUtils.isEmpty(intermediateFormatChessGame.getMetadataLines()) || StringUtils.isEmpty(intermediateFormatChessGame.getMoves())) {
            LOG.severe(EMPTY_INTERMEDIATE_GAME_MESSAGE);
            return null;
        }

        List<String> intermediateMetadata = intermediateFormatChessGame.getMetadataLines();
        String intermediateMoves = intermediateFormatChessGame.getMoves();

        intermediateMetadata.forEach((item) -> {
            updateMetadata(metadata, item);
        });

        updateMoves(moves, intermediateMoves);

        ChessGameTO result = new ChessGameTO(metadata, moves);

        return result;
    }

    private static void updateMoves(final List<ChessMoveTO> moves, String info) {
        info = info.replaceAll("\\r?\\n", " ");
        String[] moveItems = info.split(" ");
        ChessMoveTO move = null;
        boolean wasEmptyItem = false;
        int moveIndex = 0;
        for (int index = 0; index < moveItems.length - 1; index++) {
            final String moveItem = moveItems[index];

            if (wasEmptyItem) {
                moveIndex--;
                wasEmptyItem = false;
            }

            if (StringUtils.isEmpty(moveItem)) {
                wasEmptyItem = true;
                moveIndex++;
                continue;
            }

            switch (moveIndex % 3) {
                case 0:
                    if (move != null) {
                        moves.add(move);
                    }

                    move = new ChessMoveTO();

                    Integer moveNumber = Integer.parseInt(moveItem.substring(0, moveItem.length() - 1));
                    move.setMoveNumber(moveNumber);
                    break;
                case 1:
                    move.setWhiteMove(moveItem);
                    break;
                default:
                    move.setBlackMove(moveItem);
                    break;
            }

            moveIndex++;
        }

        moves.add(move);
    }

    private static void updateMetadata(final ChessMetadataTO metadataToUpdate, final String info) {
        final int firstSpace = info.indexOf(" ");
        final String metadataFieldName = info.substring(1, firstSpace);
        final String metadataValue = info.substring(firstSpace + 2, info.length() - 2);

        final ChessMetadataFieldNames fieldName = ChessMetadataFieldNames.fromString(metadataFieldName);

        if (fieldName != null) {
            switch (fieldName) {
                case EVENT:
                    metadataToUpdate.setEventName(metadataValue);
                    break;
                case SITE:
                    metadataToUpdate.setSite(metadataValue);
                    break;
                case DATE:
                    metadataToUpdate.setDate(metadataValue);
                    break;
                case ROUND:
                    metadataToUpdate.setRound(metadataValue);
                    break;
                case WHITE:
                    metadataToUpdate.setWhiteName(metadataValue);
                    break;
                case BLACK:
                    metadataToUpdate.setBlackName(metadataValue);
                    break;
                case RESULT:
                    metadataToUpdate.setResult(ChessGameResult.fromString(metadataValue));
                    break;
                case WHITE_TITLE:
                    metadataToUpdate.setWhiteTitle(ChessPlayerTitle.fromString(metadataValue));
                    break;
                case BLACK_TITLE:
                    metadataToUpdate.setBlackTitle(ChessPlayerTitle.fromString(metadataValue));
                    break;
                case WHITE_ELO:
                    metadataToUpdate.setWhiteElo(metadataValue);
                    break;
                case BLACK_ELO:
                    metadataToUpdate.setBlackElo(metadataValue);
                    break;
                case ECO:
                    metadataToUpdate.setEco(metadataValue);
                    break;
                case OPENING:
                    metadataToUpdate.setOpeningName(metadataValue);
                    break;
                case VARIATION:
                    metadataToUpdate.setVariation(metadataValue);
                    break;
                case WHITE_TEAM:
                    metadataToUpdate.setWhiteTeam(metadataValue);
                    break;
                case BLACK_TEAM:
                    metadataToUpdate.setBlackTeam(metadataValue);
                    break;
                case WHITE_FIDE_ID:
                    metadataToUpdate.setWhiteFideId(metadataValue);
                    break;
                case BLACK_FIDE_ID:
                    metadataToUpdate.setBlackFideId(metadataValue);
                    break;
                case EVENT_DATE:
                    metadataToUpdate.setEventDate(metadataValue);
                    break;
                default:
                    LOG.info(String.format(NO_SUCH_METADATA_MESSAGE, fieldName));
            }
        }
    }
}
