package com.company.game;

public class Cell {

    private boolean isEmpty = true;
    private Piece currentPiece;

    public Piece getCurrentPiece() { return currentPiece; }

    public void setCurrentPiece(Piece currentPiece) { this.currentPiece = currentPiece; isEmpty = false; }

    public boolean isEmpty(){ return isEmpty; }

    public void setEmpty(){ isEmpty = true; }

}