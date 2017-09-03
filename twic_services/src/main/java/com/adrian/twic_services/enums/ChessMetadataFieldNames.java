package com.adrian.twic_services.enums;

public enum ChessMetadataFieldNames {
    EVENT("Event"),
    SITE("Site"),
    DATE("Date"),
    ROUND("Round"),
    WHITE("White"),
    BLACK("Black"),
    RESULT("Result"),
    WHITE_TITLE("WhiteTitle"),
    BLACK_TITLE("BlackTitle"),
    WHITE_ELO("WhiteElo"),
    BLACK_ELO("BlackElo"),
    ECO("ECO"),
    OPENING("Opening"),
    VARIATION("Variation"),
    WHITE_TEAM("WhiteTeam"),
    BLACK_TEAM("BlackTeam"),
    WHITE_FIDE_ID("WhiteFideId"),
    BLACK_FIDE_ID("BlackFideId"),
    EVENT_DATE("EventDate");

    private final String name;

    private ChessMetadataFieldNames(String name) {
        this.name = name;
    }

    public static ChessMetadataFieldNames fromString(String text) {
        for (ChessMetadataFieldNames field : ChessMetadataFieldNames.values()) {
            if (field.name.equalsIgnoreCase(text)) {
                return field;
            }
        }

        return null;
    }
}
