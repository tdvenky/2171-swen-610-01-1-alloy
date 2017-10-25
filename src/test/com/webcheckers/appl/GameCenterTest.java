package com.webcheckers.appl;

import com.webcheckers.model.Board;
import com.webcheckers.model.Player;
import com.webcheckers.model.webcheckersGame;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameCenterTest {

    @Test
    public void makeMatchAndSetUpGame() throws Exception {
        GameCenter gameCenterTest= new GameCenter();
        Player player1Test= new Player("james", Player.color.RED);
        Player player2Test= new Player("xander", Player.color.WHITE);

      assertTrue(gameCenterTest.makeMatchAndSetUpGame(player1Test,player2Test)); //testing for player


    }


    @Test
    public void makeMatchAndSetUpGameFailed() throws Exception {
        GameCenter gameCenterTest= new GameCenter();
        Player player1Test= new Player("james", Player.color.RED);
        Player player2Test= new Player("xander", Player.color.WHITE);

        gameCenterTest.makeMatchAndSetUpGame(player1Test,player2Test);

        assertFalse(gameCenterTest.makeMatchAndSetUpGame(player1Test,player2Test)); //already in the array who are playing the game.


    }



}