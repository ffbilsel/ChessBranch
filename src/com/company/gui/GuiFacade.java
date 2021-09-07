package com.company.gui;

import com.company.game.Game;
import com.company.helper.Utilities;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GuiFacade {

    private static final Color highlightColor = new Color(0x2D94A7);
    private static ChessBoard chessBoard;
    private GuiFacade(){}

    public static void initGui(){
        chessBoard = new ChessBoard();
        JFrame f = new JFrame("ChessChamp");
        addPieceIcons();
        linkGuiWithBoard(chessBoard);
        f.add(chessBoard.getGui());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationByPlatform(true);
        f.pack();
        f.setMinimumSize(f.getSize());
        Utilities.autoKeyListener(f);
        f.setVisible(true);
    }
    private static void linkGuiWithBoard(ChessBoard chessBoard){
        for(int i = 0;i < Utilities.boardSize; i++){
            for(int j = 0;j < Utilities.boardSize; j++){
                final int final_i = i;
                final int final_j = j;
                chessBoard.getChessBoardSquares()[i][j].addActionListener(e -> Game.getInstance().clicked(new int[]{final_i,final_j}));
                if(!Game.getInstance().getBoard()[i][j].isEmpty()){
                    chessBoard.getChessBoardSquares()[i][j].setText(Utilities.pieceToString(Game.getInstance().getBoard()[i][j].getCurrentPiece()));
                }
            }
        }
    }

    public static void firstClick(int @NotNull [] pos){ highlightFirstCell(pos); }

    public static void secondClick(int @NotNull [] firstCellPos, int @NotNull [] secondCellPos){
        setCellText(secondCellPos, Utilities.getChessBoardCellFromPos(chessBoard, firstCellPos).getText());
        setCellText(firstCellPos,"");
        resetCellColor(firstCellPos);
        //setCellImage();
    }
    private static void highlightFirstCell(int @NotNull [] pos){
        chessBoard.getChessBoardSquares()[pos[0]][pos[1]].setBackground(highlightColor);
    }

    public static void resetCellColor(int @NotNull [] pos){
        if (pos[0] % 2 == 0 && pos[1] % 2 == 0 || pos[0] % 2 == 1 && pos[1] % 2 == 1 ){
            chessBoard.getChessBoardSquares()[pos[0]][pos[1]].setBackground(Color.WHITE);
        }
        else {
            chessBoard.getChessBoardSquares()[pos[0]][pos[1]].setBackground(Color.BLACK);
        }
    }
    private static void setCellText(int[] pos, String text){
        Utilities.getChessBoardCellFromPos(chessBoard, pos).setText(text);
    }

    @SuppressWarnings("SpellCheckingInspection")
    private static void addPieceIcons() {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            InputStream myStream = new BufferedInputStream(new FileInputStream("src\\com\\company\\gui\\resources\\CASEFONT.TTF"));
            Font chessFont = Font.createFont(Font.TRUETYPE_FONT, myStream).deriveFont(64f);
            ge.registerFont(chessFont);
            for (JButton[] buttons: chessBoard.getChessBoardSquares()){
                for (JButton button: buttons){
                    button.setFont(chessFont);
                    button.setForeground(Color.BLUE);
                }
            }
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

    }
}
