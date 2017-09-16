package com.adrian.twic_services_core.domain;

import com.adrian.twic_services_commons.enums.ChessGameResult;
import com.adrian.twic_services_commons.enums.ChessPlayerTitle;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "chess_game")
@SuppressWarnings("PersistenceUnitPresent")
public class ChessGame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private static final long serialVersionUID = 1L;

    @Column(name = "black")
    private String blackName;

    @Column(name = "black_title")
    @Enumerated(EnumType.STRING)
    private ChessPlayerTitle blackTitle;

    @Column(name = "event")
    private String eventName;

    @Column(name = "game_result")
    @Enumerated(EnumType.STRING)
    private ChessGameResult gameResult;

    @Column(name = "white")
    private String whiteName;

    @Column(name = "event_date")
    private String eventDate;

    private String site;

    @Column(name = "game_date")
    private String gameDate;

    @Column(name = "white_title")
    @Enumerated(EnumType.STRING)
    private ChessPlayerTitle whiteTitle;

    @Column(name = "white_elo")
    private String whiteElo;

    @Column(name = "black_elo")
    private String blackElo;
    private String eco;

    @Column(name = "opening")
    private String openingName;

    private String variation;

    @Column(name = "white_team")
    private String whiteTeam;

    @Column(name = "black_team")
    private String blackTeam;

    private String round;

    @Column(name = "white_fide_id")
    private String whiteFideId;

    @Column(name = "black_fide_id")
    private String blackFideId;

    @Lob
    @Column(length = 100000)
    private String moves;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public ChessGameResult getGameResult() {
        return gameResult;
    }

    public void setGameResult(ChessGameResult gameResult) {
        this.gameResult = gameResult;
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

    public String getMoves() {
        return moves;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ChessGame{" + "id=" + id + ", eventName=" + eventName + ", whiteName=" + whiteName + ", blackName=" + blackName + ", round=" + round + ", eventDate=" + eventDate + ", site=" + site + ", gameDate=" + gameDate + ", gameResult=" + gameResult + ", whiteTitle=" + whiteTitle + ", blackTitle=" + blackTitle + ", whiteElo=" + whiteElo + ", blackElo=" + blackElo + ", eco=" + eco + ", openingName=" + openingName + ", variation=" + variation + ", whiteTeam=" + whiteTeam + ", blackTeam=" + blackTeam + ", whiteFideId=" + whiteFideId + ", blackFideId=" + blackFideId + ", moves=" + moves + '}';
    }

}
