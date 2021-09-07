package com.company.game;


import com.company.helper.PieceColor;
import com.company.helper.PieceType;
import com.company.helper.Utilities;
import com.company.movement.MoveStrategy;

import java.util.Stack;

public class Piece {

    private final PieceColor color;
    private final MoveStrategy moveStrategy;
    private final PieceType pieceType;
    private int[] pos;
    private final Stack<Integer[]> lastPos = new Stack<>();

    public Piece(PieceType pieceType, PieceColor color, int[] pos){
        this.color = color;
        this.lastPos.push(Utilities.convertToIntegerArray(pos));
        this.pos = pos;
        this.pieceType = pieceType;
        this.moveStrategy = PieceFactory.addMoveType(this);
    }

    public PieceColor getColor() {
        return color;
    }

    public PieceType getPieceType(){ return pieceType; }

    public MoveStrategy getMoveStrategy() { return moveStrategy; }

    public void setPos(int[] pos) { this.pos = pos; }

    public Stack<Integer[]> getLastPos() { return lastPos; }

    public int[] getPos(){ return pos; }

    public void addLastPos(Integer[] arr){ lastPos.push(arr); }

    public void popLastPos(){ lastPos.pop(); }

}
