package com.company.movement;

import com.company.game.Cell;
import com.company.game.Piece;
import com.company.helper.Utilities;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.function.Function;

public class MoveRook extends Move implements MoveStrategy {

    public MoveRook(@NotNull Piece piece){
        super(piece.getPos(), piece.getColor());
    }


    private void rook(int x,int y) {
        char[] chars = new char[] {'x', 'y'};
        char[] operators = new char[] {'-', '+'};
        for(int i = 0;i < 2;i++){
            for(int j = 0;j < 2;j++){
                moveRookHelper(x, y, chars[i], operators[j]);
            }
        }
    }

    private void moveRookHelper(int x, int y, char varC, char operationC){

        Function<Integer,Boolean> cond = operationC == '-' ? i -> i >= 0 : i -> i < Utilities.boardSize;
        int var = varC == 'x' ? operationC == '-' ? x-1 : x + 1 : operationC == '-' ? y-1 : y + 1;
        Function<Integer,Integer> operation = operationC == '-' ? i -> i - 1 :i -> i + 1;
        while(cond.apply(var)){

            int[] currentPos = varC == 'x' ? new int[]{var,y} : new int[]{x,var};
            Cell currentCell = Utilities.getCellFromPos(currentPos);
            if(currentCell.isEmpty()){
                getPossibleMoves().put(Utilities.generateHash(currentPos),true);
                var = operation.apply(var);
            }

            else if(currentCell.getCurrentPiece().getColor() != getColor()){
                getPossibleMoves().put(Utilities.generateHash(currentPos),true);
                return;
            }
            else{
                return;
            }

        }

    }

    @Override
    public HashMap<Integer,Boolean> findPossibleMoves() { clearPossibleMoves(); rook(x,y); return getPossibleMoves(); }

}
