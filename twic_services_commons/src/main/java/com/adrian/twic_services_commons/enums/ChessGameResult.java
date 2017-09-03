package com.adrian.twic_services_commons.enums;

public enum ChessGameResult {

    WHITE_WIN("1-0"),
    BLACK_WIN("0-1"),
    DRAW("1/2-1/2"),
    CANCELED("-");

    private final String result;

    private ChessGameResult(String result) {
        this.result = result;
    }

    public static ChessGameResult fromString(String text) {
        for (ChessGameResult field : ChessGameResult.values()) {
            if (field.result.equalsIgnoreCase(text)) {
                return field;
            }
        }

        return null;
    }
}
