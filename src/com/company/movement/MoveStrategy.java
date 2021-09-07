package com.company.movement;

import java.util.HashMap;

public interface MoveStrategy {
    HashMap<Integer,Boolean> findPossibleMoves();
    void setPos(int[] pos);
}