package com.adrian.twic_services_commons.transferobjects;

public class ChessMoveTO {

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
        return "ChessMoveTO{" + "whiteMove=" + whiteMove + ", blackMove=" + blackMove + ", moveNumber=" + moveNumber + '}';
    }
}
