package com.company.movement;

import com.company.game.Piece;
import com.company.helper.PieceColor;
import com.company.helper.Utilities;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class MovePawn extends Move implements MoveStrategy {

    private final Piece piece;
    public MovePawn(@NotNull Piece piece){ super(piece.getPos(), piece.getColor()); this.piece = piece; }

    private void pawn(int x, int y){
        int[] currentPos;
        boolean isFirstMove = piece.getLastPos().size() == 1;
        int i = getColor() == PieceColor.BLACK ? 1 : -1;
        currentPos = new int[]{x, y + i};
        checkAndInsertCell(currentPos);
        currentPos = new int[]{x, y + i * 2};
        if (isFirstMove){
            checkAndInsertCell(currentPos);
        }
        if(x - 1 >= 0){
            currentPos = new int[]{x-1, y + i};
            if (!Utilities.getCellFromPos(currentPos).isEmpty() && Utilities.getCellFromPos(currentPos).getCurrentPiece().getColor() != getColor()){
                getPossibleMoves().put(Utilities.generateHash(currentPos), true);
            }
        }
        if(x + 1 < Utilities.boardSize){
            currentPos = new int[]{x + 1, y + i};
            if (!Utilities.getCellFromPos(currentPos).isEmpty() && Utilities.getCellFromPos(currentPos).getCurrentPiece().getColor() != getColor()){
                getPossibleMoves().put(Utilities.generateHash(currentPos), true);
            }
        }
    }

    private void checkAndInsertCell(int[] currentPos){
        if (Utilities.getCellFromPos(currentPos).isEmpty()){
            getPossibleMoves().put(Utilities.generateHash(currentPos), true);
        }
    }
    @Override
    public HashMap<Integer,Boolean> findPossibleMoves() { clearPossibleMoves(); pawn(x,y); return getPossibleMoves(); }
}
