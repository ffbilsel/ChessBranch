package com.company.helper;

import com.company.game.Cell;
import com.company.game.Game;
import com.company.game.Piece;
import com.company.gui.ChessBoard;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Utilities {

    public static final int boardSize = 8;

    private Utilities(){}

    public static Integer @NotNull [] convertToIntegerArray(int [] arr){ return Arrays.stream(arr).boxed().toArray(Integer[]::new);}

    public static void autoKeyListener(@NotNull Component component){
        component.setFocusable(true);
        component.addKeyListener((new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)) {
                    MoveFacade.redo();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        }));
    }

    //Temporary
    public static @NotNull String pieceToString(@NotNull Piece piece){
        PieceType type = piece.getPieceType();
        if(piece.getColor() == PieceColor.BLACK){
            return switch (type) {
                case KING -> "l";
                case QUEEN -> "Q";
                case ROOK -> "t";
                case KNIGHT -> "m";
                case BISHOP -> "v";
                case PAWN -> "o";
            };
        }
        else{

            return switch (type) {
                case KING -> "k";
                case QUEEN -> "£";
                case ROOK -> "r";
                case KNIGHT -> "n";
                case BISHOP -> "¥";
                case PAWN -> "p";
            };
        }
    }

    @Contract(pure = true)
    public static @NotNull Integer generateHash(int @NotNull [] pos){ return pos[0] + pos[1]*10; }

    public static Cell getCellFromPos(int @NotNull [] pos){
        return Game.getInstance().getBoard()[pos[0]][pos[1]];
    }
    public static JButton getChessBoardCellFromPos(@NotNull ChessBoard chessBoard, int @NotNull [] pos){ return chessBoard.getChessBoardSquares()[pos[0]][pos[1]]; }
}
