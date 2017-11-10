package com.webcheckers.appl;

import com.webcheckers.model.gameStatus;
import com.webcheckers.model.webcheckersGame;

 class PairGameWithPlayers{



    private String id;
    private String playerName;
    private String opponetPlayer;
    private webcheckersGame game;
    public gameStatus gameStat;



    PairGameWithPlayers(String playerName,String opponetPlayer,webcheckersGame game){

        this.playerName = playerName;
        this.opponetPlayer = opponetPlayer;
        this.game = game;
        this.id =  playerName+opponetPlayer;



    }

    public String getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getOpponetPlayer() {
        return opponetPlayer;
    }

    public webcheckersGame getGame() {
        return game;
    }


}