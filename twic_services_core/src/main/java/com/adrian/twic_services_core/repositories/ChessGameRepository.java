package com.adrian.twic_services_core.repositories;

import com.adrian.twic_services_core.domain.ChessGame;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ChessGameRepository extends CrudRepository<ChessGame, Long>{
    
    List<ChessGame> findTop10ByGameDate(String gameDate);
    List<ChessGame> findTop10ByGameResult(String gameResult);
    List<ChessGame> findTop10ByOpeningName(String openingName);
    List<ChessGame> findTop10ByWhiteName(String whiteName);
    List<ChessGame> findTop10ByBlackName(String blackName);
}
