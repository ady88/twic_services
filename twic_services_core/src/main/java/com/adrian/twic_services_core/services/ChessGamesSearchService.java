package com.adrian.twic_services_core.services;

import com.adrian.twic_services_commons.constants.Codes;
import com.adrian.twic_services_commons.constants.Messages;
import com.adrian.twic_services_commons.transferobjects.ChessGameTO;
import com.adrian.twic_services_commons.transferobjects.ResponseTO;
import com.adrian.twic_services_commons.transferobjects.StatusTO;
import com.adrian.twic_services_core.domain.ChessGame;
import com.adrian.twic_services_core.helpers.ChessGameConverter;
import java.util.List;
import org.springframework.stereotype.Service;
import com.adrian.twic_services_core.repositories.ChessGameRepository;

@Service
public class ChessGamesSearchService {

    private final ChessGameRepository repository;

    public ChessGamesSearchService(ChessGameRepository repository) {
        this.repository = repository;
    }

    public ResponseTO getTop10GamesByOpeningName(String openingName) {
        ResponseTO response = new ResponseTO();
        response.setStatus(new StatusTO(Codes.OK, Messages.OK));

        List<ChessGame> games = repository.findTop10ByOpeningName(openingName);
        List<ChessGameTO> gameTOs = ChessGameConverter.convertChessGames(games);

        response.setChessGames(gameTOs);

        return response;
    }
}
