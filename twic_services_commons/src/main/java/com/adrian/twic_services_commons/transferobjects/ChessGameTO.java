package com.adrian.twic_services_commons.transferobjects;

import java.util.List;

public class ChessGameTO {

    private final ChessMetadataTO metadata;
    private final List<ChessMoveTO> moves;

    public ChessGameTO(ChessMetadataTO metadata, List<ChessMoveTO> moves) {
        this.metadata = metadata;
        this.moves = moves;
    }

    public ChessMetadataTO getMetadata() {
        return metadata;
    }

    public List<ChessMoveTO> getMoves() {
        return moves;
    }

    public void addMove(ChessMoveTO move) {
        moves.add(move);
    }
}
