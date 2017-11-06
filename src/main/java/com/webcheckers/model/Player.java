package com.webcheckers.model;

public class Player {


    private String playerName;
    private Color playerColor;

    public status getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(status playerStatus) {
        this.playerStatus = playerStatus;
    }

    private status playerStatus;


    public enum status {
        Playing, WatingForMatch
    }
    public Player(String playerName,Color color){
        this.playerName = playerName;
        this.playerColor = color;
        this.playerStatus = status.WatingForMatch;
    }
    public String getPlayerName() {
        return playerName;
    }

    public Color getPlayerColor() {
        return playerColor;
    }
}
