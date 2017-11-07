package com.webcheckers.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class webcheckersGameTest {
    Color color;
    Color color2;
    Player player ;
    Player player1;
    Board board;
    webcheckersGame game;

    @Before
    public void setUp() throws Exception {

         color = Color.WHITE;
         color2 = Color.RED;

         player = new Player("OMAR", color);
         player1= new Player("ELIAS", color2);
         board= new Board();
         game = new webcheckersGame(player, player1, board);
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void jumpBackwardMove1() throws Exception {

        Position startPosition = new Position(4, 3);
        Position endPosition1 = new Position(2, 5);

        Move move = new Move(startPosition, endPosition1);
        game.jumpForwardMove(move);
        assertTrue(game.jumpBackwardMove(move));


    }
    @Test
    public void jumpBackwardMove2() throws Exception {

        Position startPosition = new Position(4, 3);
        Position endPosition2 = new Position(2, 1);

        Move move = new Move(startPosition, endPosition2);
        assertTrue(game.jumpBackwardMove(move));


    }
    @Test
    public void jumpForwardMove1() throws Exception {

        Position startPosition = new Position(4, 3);
        Position endPosition3 = new Position(6, 1);
        //Position endPosition2 = new Position(2, 1);

        Move move = new Move(startPosition, endPosition3);
        game.jumpForwardMove(move);

        assertTrue(game.jumpForwardMove(move));


    }
    @Test
    public void jumpForwardMove2() throws Exception {

        Position startPosition = new Position(4, 3);
        Position endPosition2 = new Position(6, 5);

        Move move = new Move(startPosition, endPosition2);
        game.jumpForwardMove(move);

        assertTrue(game.jumpForwardMove(move));

    }

    @Test()
    public void testFailure()  throws Throwable  {

        game.switchTurn();
        Position position0 = new Position(0, 7);
        Move move = new Move(position0, position0);
        game.makeTheMove(move);
        assertNotNull(position0);
    }

//    @Test()
//    public void testSuccess()  throws Throwable  {
//        Color color = Color.RED;
//        Player player = new Player("Yousef", color);
//        webcheckersGame webcheckersGame0 = new webcheckersGame(player, player);
//        Position position = new Position(2, 7);
//        webcheckersGame.currentPlayer = player;
//        Board board = new Board();
//        Move move = new Move(position, position);
//        webcheckersGame0.makeTheMove(move);
//        assertTrue(webcheckersGame0.isPlayerTurn());
//        assertEquals(2, webcheckersGame0.getNumberCurrentPlayers());
//    }





}