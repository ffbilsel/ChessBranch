package com.company.helper;

import com.company.game.Cell;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class MoveFacade {

    public static boolean move(int @NotNull [] firstCellPos, int @NotNull [] secondCellPos, @NotNull HashMap<Integer,Boolean> possibleMoves){
        Cell firstCell = Utilities.getCellFromPos(firstCellPos);
        Cell secondCell = Utilities.getCellFromPos(secondCellPos);
        if (possibleMoves.get(Utilities.generateHash(secondCellPos))){
            firstCell.getCurrentPiece().addLastPos(Utilities.convertToIntegerArray(secondCellPos));
            secondCell.setCurrentPiece(firstCell.getCurrentPiece());
            firstCell.setEmpty();
            return true;
        }
        return false;
    }

    public void controlCheck(){

    }

    //static?
    public static void redo(){

    }
}
