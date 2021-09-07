package com.company.game;

import com.company.gui.GuiFacade;
import com.company.helper.MoveFacade;
import com.company.helper.Utilities;
import com.company.movement.MoveStrategy;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class Game {
    private final Cell[][] board = new Cell[8][8];
    private final Stack<PathMemento> log= new Stack<>();
    private static final Game game = new Game();
    private static int[] firstPos;
    private HashMap<Integer, Boolean> possibleMoves;
    private boolean isSecondClick = false;
    private Game(){
        initBoard();
    }

    private void initBoard(){
        for(int i = 0; i < Utilities.boardSize; i++){
            for(int j = 0; j< Utilities.boardSize; j++){
                board[i][j] = new Cell();
            }
        }
    }

    public static Game getInstance(){
        return game;
    }

    public static class PathMemento{
        private final Piece capturedPiece;
        private final int[] pos;

        @Contract(pure = true)
        public PathMemento(int @NotNull [] pos){
            capturedPiece = Utilities.getCellFromPos(pos).getCurrentPiece();
            this.pos = pos;
        }

        public Piece getCapturedPiece() {
            return capturedPiece;
        }

        public int[] getPos() {
            return pos;
        }
    }

    private void appendMementoToLog(int[] pos){
        log.push(new PathMemento(pos));
    }


    public void clicked(int[] pos) {

        Cell currentCell = Utilities.getCellFromPos(pos);

        if (!Objects.isNull(firstPos) && currentCell.isEmpty() && !isSecondClick || isSecondClick && Utilities.generateHash(pos).equals(Utilities.generateHash(firstPos))) {
            GuiFacade.resetCellColor(firstPos);
            isSecondClick = false;
            return;
        }

        if (isSecondClick) {
            Cell firstCell = Utilities.getCellFromPos(firstPos);
            MoveStrategy moveStrategy = firstCell.getCurrentPiece().getMoveStrategy();
            moveStrategy.setPos(firstPos);
            if (MoveFacade.move(firstPos, pos, moveStrategy.findPossibleMoves())){
                appendMementoToLog(pos);
                GuiFacade.secondClick(firstPos, pos);
            }
            else{
                GuiFacade.resetCellColor(firstPos);
            }
            isSecondClick = false;
        }

        else if(!currentCell.isEmpty()){
            GuiFacade.firstClick(pos);
            updateFirstPos(pos);
            isSecondClick = true;
        }
    }

    private void updateFirstPos(int[] position){
        firstPos = position;
    }

    public Cell[][] getBoard() { return board; }

    public Stack<PathMemento> getLog() { return log; }

}
