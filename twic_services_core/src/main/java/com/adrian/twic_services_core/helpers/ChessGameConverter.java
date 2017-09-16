package com.adrian.twic_services_core.helpers;

import com.adrian.twic_services_commons.transferobjects.ChessGameTO;
import com.adrian.twic_services_commons.transferobjects.ChessMetadataTO;
import com.adrian.twic_services_commons.transferobjects.ChessMoveTO;
import com.adrian.twic_services_core.domain.ChessGame;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.util.CollectionUtils;
import org.springframework.util.SerializationUtils;

public class ChessGameConverter {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Logger LOG = Logger.getLogger(ChessGameConverter.class.getName());
    
    private static final String JSON_SERIALIZATION_UNSUCCESSFUL = "The JSON serialization of chess moves was not successful.";
    private static final String JSON_DESERIALIZATION_UNSUCCESSFUL = "The JSON deserialization of chess moves was not successful.";
    
    public static final List<ChessGame> convertChessGameTOs(final List<ChessGameTO> chessGameTOs) {
        
        if (CollectionUtils.isEmpty(chessGameTOs)) {
            return null;
        }

        List<ChessGame> games = new ArrayList<>();

        for (ChessGameTO gameTO : chessGameTOs) {
            ChessGame game = convertChessGameTO(gameTO);
            games.add(game);
        }

        return games;
    }

    public static final ChessGame convertChessGameTO(final ChessGameTO chessGameTO) {
        if (chessGameTO == null) {
            return null;
        }

        final ChessGame chessGame = new ChessGame();
        final ChessMetadataTO metadata = chessGameTO.getMetadata();

        chessGame.setEventName(metadata.getEventName());
        chessGame.setOpeningName(metadata.getOpeningName());
        chessGame.setEco(metadata.getEco());
        chessGame.setWhiteTitle(metadata.getWhiteTitle());
        chessGame.setBlackTitle(metadata.getBlackTitle());
        chessGame.setEventDate(metadata.getEventDate());
        chessGame.setWhiteName(metadata.getWhiteName());
        chessGame.setBlackName(metadata.getBlackName());
        chessGame.setWhiteElo(metadata.getWhiteElo());
        chessGame.setBlackElo(metadata.getBlackElo());
        chessGame.setGameDate(metadata.getDate());
        chessGame.setGameResult(metadata.getResult());
        chessGame.setRound(metadata.getRound());
        chessGame.setSite(metadata.getSite());
        chessGame.setWhiteFideId(metadata.getWhiteFideId());
        chessGame.setBlackFideId(metadata.getBlackFideId());
        chessGame.setWhiteTeam(metadata.getWhiteTeam());
        chessGame.setBlackTeam(metadata.getBlackTeam());

        String moves = null;
        try {
            moves = MAPPER.writeValueAsString(chessGameTO.getMoves());
        } catch (JsonProcessingException ex) {
            LOG.severe(JSON_SERIALIZATION_UNSUCCESSFUL);
        }
        
        chessGame.setMoves(moves);
        

        return chessGame;
    }

    public static final List<ChessGameTO> convertChessGames(final List<ChessGame> chessGames) {
        if (CollectionUtils.isEmpty(chessGames)) {
            return null;
        }

        List<ChessGameTO> gameTOs = new ArrayList<>();

        for (ChessGame game : chessGames) {
            ChessGameTO gameTO = convertChessGame(game);
            gameTOs.add(gameTO);
        }

        return gameTOs;
    }

    public static final ChessGameTO convertChessGame(final ChessGame chessGame) {
        if (chessGame == null) {
            return null;
        }

        final ChessMetadataTO metadata = new ChessMetadataTO();
        final List<ChessMoveTO> moves = new ArrayList<>();
        final ChessGameTO chessGameTO = new ChessGameTO(metadata, moves);

        metadata.setEventName(chessGame.getEventName());
        metadata.setOpeningName(chessGame.getOpeningName());
        metadata.setEco(chessGame.getEco());
        metadata.setWhiteTitle(chessGame.getWhiteTitle());
        metadata.setBlackTitle(chessGame.getBlackTitle());
        metadata.setEventDate(chessGame.getEventDate());
        metadata.setWhiteName(chessGame.getWhiteName());
        metadata.setBlackName(chessGame.getBlackName());
        metadata.setWhiteElo(chessGame.getWhiteElo());
        metadata.setBlackElo(chessGame.getBlackElo());
        metadata.setDate(chessGame.getGameDate());
        metadata.setResult(chessGame.getGameResult());
        metadata.setRound(chessGame.getRound());
        metadata.setSite(chessGame.getSite());
        metadata.setWhiteFideId(chessGame.getWhiteFideId());
        metadata.setBlackFideId(chessGame.getBlackFideId());
        metadata.setWhiteTeam(chessGame.getWhiteTeam());
        metadata.setBlackTeam(chessGame.getBlackTeam());

        TypeReference<List<ChessMoveTO>> mapType = new TypeReference<List<ChessMoveTO>>() {};
        try {
            List<ChessMoveTO> jsonToPersonList = MAPPER.readValue(chessGame.getMoves(), mapType);
        } catch (IOException ex) {
            LOG.severe(JSON_DESERIALIZATION_UNSUCCESSFUL);
        }
        final List<ChessMoveTO> deserializedMoves = (List<ChessMoveTO>) SerializationUtils.deserialize(chessGame.getMoves().getBytes());
        moves.addAll(deserializedMoves);

        return chessGameTO;
    }
}
