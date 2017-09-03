package com.adrian.twic_services_ui.controllers;

import com.adrian.twic_services.services.ChessGamesSearchService;
import com.adrian.twic_services_commons.transferobjects.ChessGameTO;
import com.adrian.twic_services_commons.transferobjects.ChessMoveTO;
import com.adrian.twic_services_commons.transferobjects.ResponseTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private final ChessGamesSearchService chessGamesSearchService;

    public HomeController(ChessGamesSearchService chessGamesSearchService) {
        this.chessGamesSearchService = chessGamesSearchService;
    }

    @RequestMapping({"/home"})
    public String getIndex(Model model) {

        ResponseTO response = chessGamesSearchService.getGames();

        ChessGameTO game = response.getChessGames().get(0);

        List<ChessMoveTO> moves = game.getMoves();

        model.addAttribute("games", response.getChessGames());
        model.addAttribute("firstMove", moves.get(0));

        return "index";
    }
}
