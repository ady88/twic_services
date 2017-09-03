package com.adrian.twic_services_commons.transferobjects;

import java.util.List;

public class ResponseTO {

    private List<ChessGameTO> chessGames;
    private StatusTO status;

    public List<ChessGameTO> getChessGames() {
        return chessGames;
    }

    public void setChessGames(List<ChessGameTO> chessGames) {
        this.chessGames = chessGames;
    }

    public StatusTO getStatus() {
        return status;
    }

    public void setStatus(StatusTO status) {
        this.status = status;
    }

}
