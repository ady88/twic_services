package com.adrian.twic_services.repositories;

import com.adrian.twic_services_commons.transferobjects.ChessGameTO;
import java.util.List;

public interface ChessGamesRepository {

    List<ChessGameTO> getGamesInRange(int startIndex, int endIndex);

    List<ChessGameTO> getAllGames();

    void saveGames(List<ChessGameTO> games);

}
