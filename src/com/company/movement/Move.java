package com.company.movement;

import com.company.helper.PieceColor;
import com.company.helper.Utilities;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Move {
    private final PieceColor color;
    private final HashMap<Integer, Boolean> possibleMoves = new HashMap<>(64);
    public int x;
    public int y;
    private int[] pos;

    public Move(int @NotNull [] pos, PieceColor color) {
        this.pos = pos;
        x = pos[0];
        y = pos[1];
        this.color = color;
    }

    public PieceColor getColor() {
        return color;
    }

    public HashMap<Integer, Boolean> getPossibleMoves() {
        return possibleMoves;
    }

    public void setPos(int @NotNull [] pos) { x = pos[0]; y = pos[1]; this.pos = pos; }

    public int[] getPos() { return pos; }

    public void clearPossibleMoves(){ possibleMoves.clear();
        for (int i = 0; i < Utilities.boardSize; i++) {
            for (int j = 0; j < Utilities.boardSize; j++) {
                possibleMoves.put(Utilities.generateHash(new int[]{i, j}), false);
            }
        }
    }

}
