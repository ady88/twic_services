package com.adrian.twic_services.services;

import com.adrian.twic_services.repositories.ChessGamesRepository;
import com.adrian.twic_services_commons.constants.Codes;
import com.adrian.twic_services_commons.constants.Messages;
import com.adrian.twic_services_commons.transferobjects.ChessGameTO;
import com.adrian.twic_services_commons.transferobjects.ResponseTO;
import com.adrian.twic_services_commons.transferobjects.StatusTO;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ChessGamesSearchService {

    private final ChessGamesRepository repository;

    public ChessGamesSearchService(ChessGamesRepository repository) {
        this.repository = repository;
    }

    public ResponseTO getGames() {
        ResponseTO response = new ResponseTO();
        response.setStatus(new StatusTO(Codes.OK, Messages.OK));
        List<ChessGameTO> games = repository.getGamesInRange(0, 10);
        response.setChessGames(games);

        return response;
    }
}
