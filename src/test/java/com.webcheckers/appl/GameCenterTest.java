package com.webcheckers.appl;

import com.webcheckers.model.Color;
import com.webcheckers.model.Player;
import com.webcheckers.model.webcheckersGame;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.junit.Assert.*;

public class GameCenterTest {
    GameCenter gameCenterTest;
    Player p1;
    Player p2;
    @Before
    public void setUp() throws Exception {
         gameCenterTest= new GameCenter();
         p1= new Player("khalid", Color.RED);
         p2= new Player("venky", Color.WHITE);
        gameCenterTest.makeMatchAndSetUpGame(p1,p2);

    }

    @Test
    public void getGames() throws Exception {
        assertNotNull( gameCenterTest.getGames());
    }

    @Test
    public void playerAlreadyPaired() throws Exception {

        gameCenterTest.makeMatchAndSetUpGame(p1,p2);

        assertTrue(gameCenterTest.playerAlreadyPaired(p1.getPlayerName()));

    }

    @Test
    public void getPlayerObjectBy() throws Exception {

       assertNotNull(gameCenterTest.getGameBy(p1.getPlayerName(),p2.getPlayerName()));
        assertNotNull( gameCenterTest.getPlayerObjectBy(p1.getPlayerName(),gameCenterTest.getGameBy(p1.getPlayerName(),p2.getPlayerName())));
        assertNotNull( gameCenterTest.getPlayerObjectBy(p2.getPlayerName(),gameCenterTest.getGameBy(p1.getPlayerName(),p2.getPlayerName())));


    }

    @Test
    public void getOpponetplayerFromPairedList() throws Exception {

       String Opponetplayer = gameCenterTest.getOpponetplayerFromPairedList(p1.getPlayerName());
       assertEquals(Opponetplayer,p2.getPlayerName());
    }



    @Test
    public void arePlayersInSameGame() throws Exception {
       assertTrue(gameCenterTest.ArePlayersInSameGame(p1.getPlayerName(),p2.getPlayerName()));
        assertFalse(gameCenterTest.ArePlayersInSameGame(p1.getPlayerName(),"DDD"));

        assertTrue(gameCenterTest.ArePlayersInSameGame(p2.getPlayerName(),p1.getPlayerName()));


    }



    @Test
    public void getPlayerWinGames() throws Exception {
         webcheckersGame game = gameCenterTest.getGameBy(p1.getPlayerName(),p2.getPlayerName());
         game.getBoard().removedRedPiece = 10;
         gameCenterTest.resignGame(game);

        assertNotNull(gameCenterTest.getPlayerWinGames(p2.getPlayerName()));

        webcheckersGame game2 = gameCenterTest.getGameBy(p1.getPlayerName(),p2.getPlayerName());


        gameCenterTest.addPairedGame(new PairGameWithPlayers(p1.getPlayerName(),p2.getPlayerName(),game));
        assertNotNull(game);
        assertEquals(1,gameCenterTest.gamesPaired.size());

    }
    @Test(expected = ConcurrentModificationException.class)
    public void getPlayerWinGames1() throws Exception {

        webcheckersGame game = gameCenterTest.getGameBy(p2.getPlayerName(),p1.getPlayerName());

        assertNotNull(game);
        // test when there is no game
        webcheckersGame gamenull = gameCenterTest.getGameBy(p2.getPlayerName(),"ds");
        assertNull(gamenull);
        gameCenterTest.resignGameby(p2.getPlayerName());

        assertNotNull(gameCenterTest.getPlayerWinGames(p1.getPlayerName()));
    }

    @Test
    public void getPairObjectBy() throws Exception {
        assertNotNull(gameCenterTest.getPairObjectBy(gameCenterTest.getGameBy(p1.getPlayerName(),p2.getPlayerName())));


    }

    @Test(expected = ConcurrentModificationException.class)
    public void resignGameby() throws Exception {
        gameCenterTest.resignGameby(p1.getPlayerName());
        gameCenterTest.resignGameby(p2.getPlayerName());


    }

    @Test
    public void resignGame() throws Exception {

        gameCenterTest.resignGame(gameCenterTest.getGameBy(p1.getPlayerName(),p2.getPlayerName()));
        assertNull(gameCenterTest.getPairObjectBy(gameCenterTest.getGameBy(p1.getPlayerName(),p2.getPlayerName())));

    }

    @Test
    public void registerPlayer() throws Exception {
        assertTrue(gameCenterTest.registerPlayer("x"));

        assertFalse(gameCenterTest.registerPlayer("x"));

    }

    @Test
    public void removePlayer() throws Exception {
        assertFalse(gameCenterTest.removePlayer("x"));
    }

    @Test
    public void isUserTaken() throws Exception {
    }

    @Test
    public void makeMatchAndSetUpGame() throws Exception {
        GameCenter gameCenterTest= new GameCenter();
        Player player1Test= new Player("james", Color.RED);
        Player player2Test= new Player("xander", Color.WHITE);

        assertTrue(gameCenterTest.makeMatchAndSetUpGame(player1Test,player2Test)); //testing for player

        assertFalse(gameCenterTest.makeMatchAndSetUpGame(p1,player1Test)); //testing for player

        assertFalse(gameCenterTest.makeMatchAndSetUpGame(p1,p1)); //testing for player


    }


    @Test
    public void makeMatchAndSetUpGameFailed() throws Exception {
        GameCenter gameCenterTest= new GameCenter();
        Player player1Test= new Player("james", Color.RED);
        Player player2Test= new Player("xander", Color.WHITE);

        gameCenterTest.makeMatchAndSetUpGame(player1Test,player2Test);
        assertTrue(gameCenterTest.makeMatchAndSetUpGame(player1Test,player2Test)); //already in the array who are playing the game.

    }
    @Test
    public void removePlayerGames() throws Exception {
        GameCenter cut=new GameCenter();
        String playerName="james bond";
        //cut.registerPlayer(playerName);
        assertTrue("playerName added",cut.registerPlayer(playerName) );
        //cut.removePlayer(playerName);
        assertTrue("playerName removed",cut.removePlayer(playerName) );
    }

}