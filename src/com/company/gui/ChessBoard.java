package com.company.gui;

import com.company.helper.Utilities;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;

public class ChessBoard {

    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private final JButton[][] chessBoardSquares = new JButton[Utilities.boardSize][Utilities.boardSize];
    private final JLabel message = new JLabel(
            "Chess Champ is ready to play!");
    @SuppressWarnings("SpellCheckingInspection")
    private static final String COLS = "ABCDEFGH";

    public ChessBoard() {
        initGui();
    }

    public final void initGui() {
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("New")); // TODO - add functionality!
        tools.add(new JButton("Save")); // TODO - add functionality!
        tools.add(new JButton("Restore")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(new JButton("Resign")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(message);

        gui.add(new JLabel("?"), BorderLayout.LINE_START);

        JPanel chessBoard = new JPanel(new GridLayout(0, 9));
        Utilities.autoKeyListener(chessBoard);
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        gui.add(chessBoard);

        // create the chess board squares
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                Utilities.autoKeyListener(b);
                b.setMargin(buttonMargin);
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((jj % 2 == 1 && ii % 2 == 1)
                        //) {
                        || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                chessBoardSquares[jj][ii] = b;
            }
        }

        //fill the chess board
        chessBoard.add(new JLabel(""));
        // fill the top row
        for (int ii = 0; ii < 8; ii++) {
            chessBoard.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                            SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                if (jj == 0) {
                    chessBoard.add(new JLabel("" + (ii + 1),
                            SwingConstants.CENTER));
                }
                chessBoard.add(chessBoardSquares[jj][ii]);
            }
        }
    }

    public final JComponent getGui() {
        return gui;
    }

    public JButton[][] getChessBoardSquares(){ return chessBoardSquares; }

}
