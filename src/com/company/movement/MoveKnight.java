package com.company.movement;

import com.company.game.Cell;
import com.company.game.Game;
import com.company.game.Piece;
import com.company.helper.Utilities;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class MoveKnight extends Move implements MoveStrategy {

    public MoveKnight(@NotNull Piece piece){
        super(piece.getPos(), piece.getColor());
    }

    @SuppressWarnings("DuplicatedCode")
    public void knight() {
        int tempX, tempY;
        int boardSize = Utilities.boardSize;
        tempX = x - 1;
        tempY = y - 2;
        if(tempX >= 0 && tempY >= 0){
            sendToTest(tempX, tempY);
        }
        tempX = x - 1;
        tempY = y + 2;
        if(tempX >= 0 && tempY < boardSize){
            sendToTest(tempX, tempY);
        }
        tempX = x + 1;
        tempY = y - 2;
        if(tempX < boardSize && tempY >= 0){
            sendToTest(tempX, tempY);
        }
        tempX = x + 1;
        tempY = y + 2;
        if(tempX < boardSize && tempY < boardSize){
            sendToTest(tempX, tempY);
        }
        tempX = x - 2;
        tempY = y - 1;
        if (tempX >= 0 && tempY >= 0){
            sendToTest(tempX, tempY);
        }
        tempX = x - 2;
        tempY = y + 1;
        if (tempX >= 0 && tempY < boardSize){
            sendToTest(tempX, tempY);
        }
        tempX = x + 2;
        tempY = y - 1;
        if(tempX < boardSize && tempY >= 0){
            sendToTest(tempX, tempY);
        }
        tempX = x + 2;
        tempY = y + 1;
        if(tempX < boardSize && tempY < boardSize){
            sendToTest(tempX, tempY);
        }
    }

    private void sendToTest(int tempX, int tempY){
        int[] currentPos;
        Cell currentCell;
        currentPos = new int[]{tempX, tempY};
        currentCell = Game.getInstance().getBoard()[tempX][tempY];
        test(currentPos, currentCell);
    }
    private void test(int[] currentPos, @NotNull Cell currentCell){
        if(currentCell.isEmpty()){
            getPossibleMoves().put(Utilities.generateHash(currentPos),true);
        }
        else if(currentCell.getCurrentPiece().getColor() != getColor()){
            getPossibleMoves().put(Utilities.generateHash(currentPos),true);
        }
    }

    @Override
    public HashMap<Integer,Boolean> findPossibleMoves() { clearPossibleMoves(); knight();  return getPossibleMoves(); }
}
