package com.adrian.twic_services_ui.controllers;

import com.adrian.twic_services_commons.transferobjects.ChessGameTO;
import com.adrian.twic_services_commons.transferobjects.ChessMoveTO;
import com.adrian.twic_services_commons.transferobjects.ResponseTO;
import com.adrian.twic_services_core.services.ChessGamesSearchService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private final ChessGamesSearchService chessGamesSearchService;

    public HomeController(ChessGamesSearchService chessGamesSearchService) {
        this.chessGamesSearchService = chessGamesSearchService;
    }

    @RequestMapping({"/home"})
    public String getIndex(Model model) {

        ResponseTO response = chessGamesSearchService.getTop10GamesByOpeningName("test");

        ChessGameTO game = response.getChessGames().get(0);

        List<ChessMoveTO> moves = game.getMoves();

        model.addAttribute("games", response.getChessGames());
        model.addAttribute("firstMove", moves.get(0));

        return "index";
    }
}
