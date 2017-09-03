package com.adrian.twic_services.helpers;

import java.util.List;

public class ChessGameIntermediateFormat {

    private final List<String> metadataLines;
    private final String moves;

    public ChessGameIntermediateFormat(List<String> metadataLines, String moves) {
        this.metadataLines = metadataLines;
        this.moves = moves;
    }

    public List<String> getMetadataLines() {
        return metadataLines;
    }

    public String getMoves() {
        return moves;
    }

    public void addMetadata(String info) {
        this.metadataLines.add(info);
    }

    @Override
    public String toString() {
        return "ChessGameIntermediateFormat{" + "metadataLines=" + metadataLines + ", moves=" + moves + '}';
    }
}
