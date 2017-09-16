package com.adrian.twic_services_commons.transferobjects;

import java.io.Serializable;

public class ChessMoveTO implements Serializable {

    private String whiteMove;
    private String blackMove;
    private int moveNumber;

    public ChessMoveTO() {
    }

    public ChessMoveTO(String whiteMove, String blackMove, int moveNumber) {
        this.whiteMove = whiteMove;
        this.blackMove = blackMove;
        this.moveNumber = moveNumber;
    }

    public String getWhiteMove() {
        return whiteMove;
    }

    public String getBlackMove() {
        return blackMove;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public void setWhiteMove(String whiteMove) {
        this.whiteMove = whiteMove;
    }

    public void setBlackMove(String blackMove) {
        this.blackMove = blackMove;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    @Override
    public String toString() {
        return String.format("{%s : { white : %s, black: %s}}", Integer.toString(moveNumber), whiteMove, blackMove);
    }
}
