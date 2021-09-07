package com.company.helper;

import com.company.game.Cell;
import com.company.game.Piece;
import org.jetbrains.annotations.NotNull;

public class BoardMakerFacade {

    //TODO add controller
    public static void initBoard(@NotNull String gameType){
        if (gameType.equals("Standard")){
            initStandardBoard();
        }
    }

    private static void initStandardBoard(){
        addPiece(new Piece(PieceType.ROOK, PieceColor.BLACK, new int[]{0,0}));
        addPiece(new Piece(PieceType.KNIGHT, PieceColor.BLACK, new int[]{1,0}));
        addPiece(new Piece(PieceType.BISHOP, PieceColor.BLACK, new int[]{2,0}));
        addPiece(new Piece(PieceType.QUEEN, PieceColor.BLACK, new int[]{3,0}));
        addPiece(new Piece(PieceType.KING, PieceColor.BLACK, new int[]{4,0}));
        addPiece(new Piece(PieceType.BISHOP, PieceColor.BLACK, new int[]{5,0}));
        addPiece(new Piece(PieceType.KNIGHT, PieceColor.BLACK, new int[]{6,0}));
        addPiece(new Piece(PieceType.ROOK, PieceColor.BLACK, new int[]{7,0}));
        addPiece(new Piece(PieceType.ROOK, PieceColor.WHITE, new int[]{0,7}));
        addPiece(new Piece(PieceType.KNIGHT, PieceColor.WHITE, new int[]{1,7}));
        addPiece(new Piece(PieceType.BISHOP, PieceColor.WHITE, new int[]{2,7}));
        addPiece(new Piece(PieceType.QUEEN, PieceColor.WHITE, new int[]{3,7}));
        addPiece(new Piece(PieceType.KING, PieceColor.WHITE, new int[]{4,7}));
        addPiece(new Piece(PieceType.BISHOP, PieceColor.WHITE, new int[]{5,7}));
        addPiece(new Piece(PieceType.KNIGHT, PieceColor.WHITE, new int[]{6,7}));
        addPiece(new Piece(PieceType.ROOK, PieceColor.WHITE, new int[]{7,7}));
        for(int i = 0; i < 8; i++){
            addPiece(new Piece(PieceType.PAWN, PieceColor.BLACK, new int[]{i,1}));
            addPiece(new Piece(PieceType.PAWN, PieceColor.WHITE, new int[]{i,6}));
        }
    }

    private static void addPiece(@NotNull Piece piece){
        Cell cell = Utilities.getCellFromPos(piece.getPos());
        cell.setCurrentPiece(piece);
    }
}
