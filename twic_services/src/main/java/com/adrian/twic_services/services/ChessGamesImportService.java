package com.adrian.twic_services.services;

import com.adrian.twic_services.helpers.ChessGameIntermediateFormat;
import com.adrian.twic_services.helpers.ChessGameTOConverter;
import com.adrian.twic_services.repositories.ChessGamesRepository;
import com.adrian.twic_services_commons.constants.Codes;
import com.adrian.twic_services_commons.constants.Messages;
import com.adrian.twic_services_commons.transferobjects.ChessGameTO;
import com.adrian.twic_services_commons.transferobjects.ResponseTO;
import com.adrian.twic_services_commons.transferobjects.StatusTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ChessGamesImportService {

    private static final Logger LOG = Logger.getLogger(ChessGamesImportService.class.getName());

    private static final String TWIC_URL = "http://theweekinchess.com/zips/twic";
    private static final String TWIC_PGN_SUFFIX = "g";
    private static final String TWIC_ZIP_EXTENSION = ".zip";

    private final ChessGamesRepository repository;

    public ChessGamesImportService(ChessGamesRepository repository) {
        this.repository = repository;
    }

    public ResponseTO importGamesFromPackage(String packageNumber) {
        final String zipFileLocation = String.format("%s%s%s%s", TWIC_URL, packageNumber, TWIC_PGN_SUFFIX, TWIC_ZIP_EXTENSION);
        ResponseTO response = new ResponseTO();

        ZipInputStream zipInputStream = null;

        try {
            URL url = new URL(zipFileLocation);
            zipInputStream = new ZipInputStream(url.openStream());
        } catch (IOException ex) {
            LOG.severe(Messages.OPEN_ZIP_FILE_ERROR);
            response.setStatus(new StatusTO(Codes.OPEN_ZIP_FILE_ERROR, Messages.OPEN_ZIP_FILE_ERROR));
        }

        if (zipInputStream == null) {
            return response;
        }

        List<ChessGameIntermediateFormat> intermediateChessGamesFormat = null;

        try {
            intermediateChessGamesFormat = getIntermediateFormatChessGames(zipInputStream);
        } catch (IOException ex) {
            LOG.severe(Messages.OPEN_ZIP_FILE_ERROR);
            response.setStatus(new StatusTO(Codes.READ_ZIP_FILE_ERROR, Messages.READ_ZIP_FILE_ERROR));
        }

        if (intermediateChessGamesFormat == null) {
            return response;
        }

        LOG.info(zipFileLocation);
        LOG.info(intermediateChessGamesFormat.toString());

        List<ChessGameTO> chessGamesTO = ChessGameTOConverter.convertIntermediatChessGamesToChessGamesTO(intermediateChessGamesFormat);
        response.setChessGames(chessGamesTO);

        repository.saveGames(chessGamesTO);

        response.setStatus(new StatusTO(Codes.OK, Messages.OK));

        return response;
    }

    private List<ChessGameIntermediateFormat> getIntermediateFormatChessGames(ZipInputStream zipInputStream) throws IOException {
        final List<ChessGameIntermediateFormat> lines = new ArrayList<>();
        ZipEntry entry = zipInputStream.getNextEntry();

        if (entry.isDirectory()) {
            return lines;
        }

        if (FilenameUtils.getExtension(entry.getName()).equals("pgn")) {

            StringBuilder out = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(zipInputStream));
            String line;
            int index = 0;
            boolean isAtIterationStart = true;
            List<String> metadataLines = new ArrayList<>();
            StringBuilder movesBuiler = new StringBuilder("");

            while ((line = reader.readLine()) != null) {

                if (StringUtils.isEmpty(line)) {
                    if (index % 2 == 1) {
                        ChessGameIntermediateFormat intermediateFormat = new ChessGameIntermediateFormat(metadataLines, movesBuiler.toString());
                        lines.add(intermediateFormat);
                        metadataLines = new ArrayList<>();
                        movesBuiler = new StringBuilder("");
                    }

                    index++;
                } else {
                    if (index % 2 == 0) {
                        metadataLines.add(line);
                    } else if (index % 2 == 1) {
                        movesBuiler.append(String.format(" %s", line));
                    }
                }
            }
        }

        zipInputStream.closeEntry();
        zipInputStream.close();

        return lines;
    }
}
