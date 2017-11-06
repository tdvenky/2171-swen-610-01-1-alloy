package com.webcheckers.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class webcheckersGameTest {


    @Test()
    public void testFailure()  throws Throwable  {
        Color color = Color.WHITE;
        Color color2 = Color.RED;

        Player player = new Player("OMAR", color);
        Player player1= new Player("ELIAS", color2);

        Board board= new Board();
        webcheckersGame game = new webcheckersGame(player, player1, board);
        game.switchTurn();
        Position position0 = new Position(0, 7);
        Move move = new Move(position0, position0);
        game.makeTheMove(move);
        assertNotEquals(position0,position0);
    }

    @Test()
    public void testSuccess()  throws Throwable  {
        Color color = Color.RED;
        Player player = new Player("Yousef", color);
        webcheckersGame webcheckersGame0 = new webcheckersGame(player, player);
        Position position = new Position(2, 7);
        webcheckersGame.currentPlayer = player;
        Board board = new Board();
        Move move = new Move(position, position);
        webcheckersGame.makeTheMove(move);
        assertTrue(webcheckersGame0.isPlayerTurn());
        assertEquals(2, webcheckersGame0.getNumberCurrentPlayers());
    }





}