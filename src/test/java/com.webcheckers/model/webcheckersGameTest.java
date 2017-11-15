package com.webcheckers.model;

import com.webcheckers.appl.GameCenter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

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

//        assertTrue(game.checkForOpponentBackWard(new Move (new Position(5,1),new Position(3,3))));

    }




    @Test
    public void checkForOpponentBackWard() throws Exception {
        board.rows.get(5).spaces.get(1).setPiece( new Piece(Piece.Type.SINGLE,Color.RED));
        board.rows.get(4).spaces.get(2).setPiece( new Piece(Piece.Type.SINGLE,Color.WHITE));
        //webcheckersGame.currentPlayer = player1;

//        assertTrue(game.checkForOpponentBackWard(new Move (new Position(2,5),new Position(4,3))));
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
//        game.makeTheMove(move);
      //  assertNotNull(position0);
    }

    @Test
    public void getPlayerWhoHasResigned() throws Exception {



        game.playerWhoHasResigned = player.getPlayerName();
        assertEquals(player.getPlayerName(),game.getPlayerWhoHasResigned());
    }

    @Test
    public void getPlayerOne() throws Exception {

        assertEquals(player.getPlayerName(),"OMAR");
    }

    @Test
    public void getOpponetPlayer() throws Exception {

        assertEquals(player1.getPlayerName(),"ELIAS");

    }

    @Test
    public void isPlayerTurn() throws Exception {
        game.currentPlayer = player;
        assertEquals(game.currentPlayer,player);
    }



    @Test
    public void getBoard() throws Exception {
        assertNotNull(game.getBoard());
    }

    @Test
    public void setBoard() throws Exception {

        game.setBoard(board);
        assertNotNull(game.getBoard());

    }

    @Test
    public void getMessage() throws Exception {

        message m = new message("sjhd", message.Type.info);
        game.setMessage(m);
        assertNotNull(game.getMessage());
    }

    @Test
    public void setMessage() throws Exception {
        message m = new message("sjhd", message.Type.info);
        game.setMessage(m);
        assertEquals(game.getMessage(),m);
    }



    @Test
    public void setMoves() throws Exception {
    }

    @Test
    public void getNumberCurrentPlayers() throws Exception {
    }

    @Test
    public void setNumberCurrentPlayers() throws Exception {
    }

    @Test
    public void getGameID() throws Exception {
    }

    @Test
    public void setGameID() throws Exception {
    }

    @Test
    public void resignStatus() throws Exception {
    }

    @Test
    public void switchTurn() throws Exception {
    }

    @Test
    public void makeTheMove() throws Exception {
    }

    @Test
    public void isValidMove() throws Exception {

        game.currentPlayer = player1;

        Position startPosition = new Position(2, 1);
        Position endPosition2 = new Position(3, 2);

        Move move = new Move(startPosition, endPosition2);
        // can move

         game.isMoved = false;
         assertTrue(game.makeTheMove(move));

         game.isMoved = true;
         assertFalse(game.makeTheMove(move));
        // can not move
        game.getBoard().rows.get(3).spaces.get(2).getPiece().setType(Piece.Type.KING);
        game.isMoved = false;
        Move move1 = new Move(endPosition2, new Position(4,3));

        assertTrue(game.makeTheMove(move1));
        //king identification






        // jump
        // cannot jump

        // move

        // cannot move

      //

        //
    }

    @Test
    public void singleForwardMove1() throws Exception {
    }

    @Test
    public void singleBackwardMove1() throws Exception {
    }

    @Test
    public void singleMoveCheck() throws Exception {
    }

    @Test
    public void isTurn() throws Exception {
    }

    @Test
    public void jumpForwardMove() throws Exception {
    }

    @Test
    public void checkForOpponentForward1() throws Exception {
    }

    @Test
    public void checkForOpponentBackWard1() throws Exception {
    }

    @Test
    public void isWon() throws Exception {
        GameCenter center = new GameCenter();
        center.makeMatchAndSetUpGame(player,player1);

        game.getBoard().removedWhitePiece = 10;
        assertEquals(player.getPlayerName(),game.isWon().getPlayerName());

        center.makeMatchAndSetUpGame(player,player1);
        game.getBoard().removedRedPiece = 10;
        assertNotEquals(player1.getPlayerName(),game.isWon().getPlayerName());
    }

    @Test
    public void removePiece1() throws Exception {
        GameCenter center = new GameCenter();

        center.makeMatchAndSetUpGame(player,player1);

        game.removedSpace = board.rows.get(2).spaces.get(1);
        game.removePiece();
        assertNull(board.rows.get(2).spaces.get(1).getPiece());
    }

    @Test
    public void jumpBackwardMove() throws Exception {
    }

    @Test
    public void jumpCheck() throws Exception {
    }

    @Test
    public void equals() throws Exception {
    }



}