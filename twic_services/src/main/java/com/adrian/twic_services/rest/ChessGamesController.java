package com.adrian.twic_services.rest;

import com.adrian.twic_services_core.ChessGamesImportService;
import com.adrian.twic_services_core.ChessGamesSearchService;
import com.adrian.twic_services_commons.transferobjects.ResponseTO;
import javax.ws.rs.GET;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChessGamesController {

    private static final String HELLO = "Hello, world.";

    private final ChessGamesImportService importService;
    private final ChessGamesSearchService searchService;

    public ChessGamesController(ChessGamesImportService importService, ChessGamesSearchService searchService) {
        this.importService = importService;
        this.searchService = searchService;
    }

    @GET
    @RequestMapping("/greeting")
    public ResponseEntity greeting() {
        ResponseEntity response = ResponseEntity.ok().body(HELLO);
        return response;
    }

    @RequestMapping(value = "/import/{packageNumber}", method = RequestMethod.GET)
    public ResponseEntity importGames(@PathVariable String packageNumber) {
        ResponseTO responseTO = importService.importGamesFromPackage(packageNumber);
        ResponseEntity response = ResponseEntity.ok().body(responseTO);
        return response;
    }

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public ResponseEntity getGames() {
        ResponseTO responseTO = searchService.getGames();
        ResponseEntity response = ResponseEntity.ok().body(responseTO);
        return response;
    }
}
