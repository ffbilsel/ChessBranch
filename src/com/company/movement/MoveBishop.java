package com.company.movement;

import com.company.game.Cell;
import com.company.game.Piece;
import com.company.helper.Utilities;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.function.Function;

public class MoveBishop extends Move implements MoveStrategy {

    public MoveBishop(@NotNull Piece piece){
        super(piece.getPos(), piece.getColor());
    }

    private void bishop(int x, int y){
        int[] numbers = new int[] {x,y};
        char[] chars =  new char[] {'+', '-'};
        for(int i = 0;i < 2;i++){
            for(int j = 0;j < 2;j++){
                moveBishopHelper(numbers, new char[]{chars[i], chars[j]} );
            }
        }
    }

    private void moveBishopHelper(int @NotNull [] varsInit, char @NotNull [] operations){
        int[] vars = new int[] { retVar(varsInit[0], operations[0]), retVar(varsInit[1], operations[1])};
        Function<Integer,Boolean> cond1 = operations[0] == '-' ? i -> i >= 0 : i -> i < Utilities.boardSize;
        Function<Integer,Boolean> cond2 = operations[1] == '-' ? i -> i >= 0 :i -> i < Utilities.boardSize;
        Function<Integer,Integer> operation1 = operations[0] == '-' ? i -> i - 1 :i -> i + 1;
        Function<Integer,Integer> operation2 = operations[1] == '-' ? i -> i - 1 :i -> i + 1;
        while(cond1.apply(vars[0]) && cond2.apply(vars[1])){
            int[] currentPos = new int[]{vars[0],vars[1]};
            Cell currentCell = Utilities.getCellFromPos(currentPos);
            if(currentCell.isEmpty()){
                getPossibleMoves().put(Utilities.generateHash(currentPos),true);
                vars[0] = operation1.apply(vars[0]);
                vars[1] = operation2.apply(vars[1]);
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
    private int retVar(int var, int operator){ return operator == '-' ? var - 1 : var + 1; }

    @Override
    public HashMap<Integer,Boolean> findPossibleMoves() { clearPossibleMoves(); bishop(x,y); return getPossibleMoves();}

}
