package com.adrian.twic_services_commons.transferobjects;

import com.adrian.twic_services_commons.enums.ChessGameResult;
import com.adrian.twic_services_commons.enums.ChessPlayerTitle;

public class ChessMetadataTO {

    private String eventName;
    private String site;
    private String date;
    private String round;
    private String whiteName;
    private String blackName;
    private ChessGameResult result;
    private ChessPlayerTitle whiteTitle;
    private ChessPlayerTitle blackTitle;
    private String whiteElo;
    private String blackElo;
    private String eco;
    private String openingName;
    private String variation;
    private String whiteTeam;
    private String blackTeam;
    private String whiteFideId;
    private String blackFideId;
    private String eventDate;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getWhiteName() {
        return whiteName;
    }

    public void setWhiteName(String whiteName) {
        this.whiteName = whiteName;
    }

    public String getBlackName() {
        return blackName;
    }

    public void setBlackName(String blackName) {
        this.blackName = blackName;
    }

    public ChessGameResult getResult() {
        return result;
    }

    public void setResult(ChessGameResult result) {
        this.result = result;
    }

    public ChessPlayerTitle getWhiteTitle() {
        return whiteTitle;
    }

    public void setWhiteTitle(ChessPlayerTitle whiteTitle) {
        this.whiteTitle = whiteTitle;
    }

    public ChessPlayerTitle getBlackTitle() {
        return blackTitle;
    }

    public void setBlackTitle(ChessPlayerTitle blackTitle) {
        this.blackTitle = blackTitle;
    }

    public String getWhiteElo() {
        return whiteElo;
    }

    public void setWhiteElo(String whiteElo) {
        this.whiteElo = whiteElo;
    }

    public String getBlackElo() {
        return blackElo;
    }

    public void setBlackElo(String blackElo) {
        this.blackElo = blackElo;
    }

    public String getEco() {
        return eco;
    }

    public void setEco(String eco) {
        this.eco = eco;
    }

    public String getOpeningName() {
        return openingName;
    }

    public void setOpeningName(String openingName) {
        this.openingName = openingName;
    }

    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public String getWhiteFideId() {
        return whiteFideId;
    }

    public void setWhiteFideId(String whiteFideId) {
        this.whiteFideId = whiteFideId;
    }

    public String getBlackFideId() {
        return blackFideId;
    }

    public void setBlackFideId(String blackFideId) {
        this.blackFideId = blackFideId;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getWhiteTeam() {
        return whiteTeam;
    }

    public void setWhiteTeam(String whiteTeam) {
        this.whiteTeam = whiteTeam;
    }

    public String getBlackTeam() {
        return blackTeam;
    }

    public void setBlackTeam(String blackTeam) {
        this.blackTeam = blackTeam;
    }

}
