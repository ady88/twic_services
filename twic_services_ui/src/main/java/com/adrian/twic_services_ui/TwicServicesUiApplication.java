package com.adrian.twic_services_ui;

import com.adrian.twic_services.repositories.ChessGamesRepository;
import com.adrian.twic_services.services.ChessGamesSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.adrian.twic_services")
public class TwicServicesUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwicServicesUiApplication.class, args);
    }

    @Bean
    public ChessGamesSearchService chessGamesSearchService( @Autowired ChessGamesRepository repository) {
        return new ChessGamesSearchService(repository);
    }
}
