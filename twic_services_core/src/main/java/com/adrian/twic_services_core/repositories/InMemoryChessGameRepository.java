package com.adrian.twic_services_core.repositories;

import com.adrian.twic_services_commons.transferobjects.ChessGameTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryChessGameRepository implements ChessGamesRepository {

    private List<ChessGameTO> games = new ArrayList<>();

    @Override
    public List<ChessGameTO> getGamesInRange(int startIndex, int endIndex) {
        return games.subList(startIndex, endIndex);
    }

    @Override
    public List<ChessGameTO> getAllGames() {
        return games;
    }

    @Override
    public void saveGames(List<ChessGameTO> games) {
        this.games = games;
    }

}
