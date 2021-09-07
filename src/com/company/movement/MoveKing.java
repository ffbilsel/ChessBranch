package com.company.movement;

import com.company.game.Cell;
import com.company.game.Piece;
import com.company.helper.Utilities;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class MoveKing extends Move implements MoveStrategy {

    public MoveKing(@NotNull Piece piece){
        super(piece.getPos(), piece.getColor());
    }

    private void king(){
        int[] currentPos;
        Cell currentCell;
        for(int i = x - 1; i <= x + 1; i++){
            for(int j = y - 1; j <= y + 1; j++){
                if(i < 0 || i >= Utilities.boardSize || j < 0 || j >= Utilities.boardSize || i == x && j == y){
                    continue;
                }
                currentPos = new int[]{i,j};
                currentCell = Utilities.getCellFromPos(currentPos);
                if(currentCell.isEmpty() || currentCell.getCurrentPiece().getColor() != getColor()){
                    getPossibleMoves().put(Utilities.generateHash(currentPos),true);
                }
            }
        }
    }

    @Override
    public HashMap<Integer,Boolean> findPossibleMoves() { clearPossibleMoves(); king();  return getPossibleMoves(); }
}
