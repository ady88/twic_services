package com.adrian.twic_services_commons.enums;

public enum ChessPlayerTitle {

    GM("Grand Master"),
    IM("International Master"),
    NM("National Master"),
    NO_TITLE("No Title");

    private final String name;

    private ChessPlayerTitle(String name) {
        this.name = name;
    }

    public static ChessPlayerTitle fromString(String text) {
        for (ChessPlayerTitle field : ChessPlayerTitle.values()) {
            if (field.name.equalsIgnoreCase(text)) {
                return field;
            }
        }

        return null;
    }
}
