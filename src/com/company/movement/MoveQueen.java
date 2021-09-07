package com.company.movement;

import com.company.game.Piece;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class MoveQueen extends Move implements MoveStrategy {

    private final MoveRook moveRook;
    private final MoveBishop moveBishop;
    public MoveQueen(@NotNull Piece piece){
        super(piece.getPos(), piece.getColor());
        moveRook = new MoveRook(piece);
        moveBishop = new MoveBishop(piece);
    }

    @Override
    public HashMap<Integer,Boolean> findPossibleMoves() { clearPossibleMoves(); moveRook.setPos(getPos()); moveBishop.setPos(getPos()); return mergeHashes(moveRook.findPossibleMoves(), moveBishop.findPossibleMoves()); }

    private HashMap<Integer,Boolean> mergeHashes(HashMap<Integer, Boolean> first, @NotNull HashMap<Integer,Boolean> second){
        for (Integer key: second.keySet()){
            if (second.get(key)){
                first.put(key, true);
            }
        }
        return first;
    }

}
