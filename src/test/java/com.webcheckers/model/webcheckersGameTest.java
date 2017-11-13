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

         player = new Player("OMAR", color2);
         player1= new Player("ELIAS", color);
         board= new Board();
         game = new webcheckersGame(player, player1, board);
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void checkForOpponentForward() throws Exception {

        board.rows.get(2).spaces.get(5).setPiece( new Piece(Piece.Type.SINGLE,Color.RED));
        board.rows.get(4).spaces.get(3).setPiece( new Piece(Piece.Type.SINGLE,Color.WHITE));
        //webcheckersGame.currentPlayer = player;

        assertTrue(game.checkForOpponentBackWard(new Move (new Position(5,1),new Position(3,3))));

    }




    @Test
    public void checkForOpponentBackWard() throws Exception {
        board.rows.get(5).spaces.get(1).setPiece( new Piece(Piece.Type.SINGLE,Color.RED));
        board.rows.get(4).spaces.get(2).setPiece( new Piece(Piece.Type.SINGLE,Color.WHITE));
        //webcheckersGame.currentPlayer = player1;

        assertTrue(game.checkForOpponentBackWard(new Move (new Position(2,5),new Position(4,3))));
    }


    @Test
    public void removePiece() throws Exception {


        Move move = new Move(new Position(4, 3), new Position(2, 5));
        game.jumpForwardMove(move);
        game.jumpBackwardMove(move);

        assertNull(board.rows.get(4).spaces.get(2).getPiece());

    }

    @Test
    public void singleForwardMove() throws Exception {


        Move move = new Move(new Position(3,4), new Position(4,5));

        assertTrue(game.singleForwardMove(move));


    }

    @Test
    public void singleBackwardMove() throws Exception {

        Move move = new Move(new Position(2,3), new Position(1,2));

        assertTrue(game.singleBackwardMove(move));
    }

    @Test
    public void singleForwardMoveAndLegal() throws Exception {


        Move move = new Move(new Position(5,4), new Position(5,5));

        assertFalse(game.singleForwardMove(move));


    }

    @Test
    public void singleBackwardMoveAndLegal() throws Exception {

        Move move = new Move(new Position(3,1), new Position(1,2));

        assertFalse(game.singleBackwardMove(move));
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

      //  game.switchTurn();
        Position position0 = new Position(0, 7);
        Move move = new Move(position0, position0);
        game.makeTheMove(move);
        assertNotNull(position0);
    }





}