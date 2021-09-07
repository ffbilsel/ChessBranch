package com.company.game;

import com.company.helper.PieceType;
import com.company.movement.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class PieceFactory {
    //TODO ask how to pass piece automatically to constructors
    @Contract(value = "_ -> new", pure = true)
    public static @NotNull MoveStrategy addMoveType(@NotNull Piece piece){
        PieceType pieceType = piece.getPieceType();
        return switch (pieceType) {
            case PAWN -> new MovePawn(piece);
            case KNIGHT -> new MoveKnight(piece);
            case BISHOP -> new MoveBishop(piece);
            case ROOK -> new MoveRook(piece);
            case QUEEN -> new MoveQueen(piece);
            case KING -> new MoveKing(piece);
        };
    }
}
