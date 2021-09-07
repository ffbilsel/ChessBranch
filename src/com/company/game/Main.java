package com.company.game;

import com.company.gui.GuiFacade;
import com.company.helper.BoardMakerFacade;

public class Main {

    //TODO add turn
    //TODO redo
    //TODO en passant, pawn promotion
    //TODO castle
    //TODO add check
    //TODO add draw
    //TODO add game over

    //TODO add move history and continue from xth move
    //TODO add timer
    //TODO choose color
    //TODO add sandbox
    //TODO add AI (homemade and stock fish)
    //TODO add sound
    //TODO add game modes (blitz etc.)
    //TODO multiplayer
    //TODO play with friend
    //TODO store games for inspection
    //TODO add games from history
    //TODO add accounts and oAuth

    //TODO add tutorial
    //TODO add puzzles
    //TODO add elo and leaderboard
    //TODO add tournaments
    //TODO add a forum and blog
    //TODO add navigation to streams
    //TODO add advertisements
    //TODO add chess coins and store
    //TODO add online shop and online purchase
    //TODO chess clubs
    //TODO add friends
    //TODO add profile, achievements, messages, board theme

    //TODO mobile, web and computer applications

    public static void main(String[] args) {
        //TODO add controller
        BoardMakerFacade.initBoard("Standard");
        GuiFacade.initGui();
    }
}
