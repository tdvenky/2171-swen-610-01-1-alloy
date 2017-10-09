package com.webcheckers.model;
import com.webcheckers.model.Board;

public class Player {


    private String playerName;
    private color playerColor;
    public enum color {
        RED, White
    }
    public Player(String playerName,color color){
        this.playerName = playerName;
        this.playerColor = color;
    }
    public String getPlayerName() {
        return playerName;
    }

    public color getPlayerColor() {
        return playerColor;
    }
}
