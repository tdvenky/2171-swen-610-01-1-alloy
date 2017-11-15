package com.webcheckers.model;

import com.webcheckers.appl.GameCenter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class webcheckersGameTest {



    Color white;
    Color red;
    Player playerRed;
    Player playerWhite;
    Board board;
    webcheckersGame game;
    GameCenter gameCenter;

    @Before
    public void setUp() throws Exception {

         white = Color.WHITE;
         red = Color.RED;

         playerRed = new Player("OMAR", red);
         playerWhite = new Player("ELIAS", white);

         board= new Board();
         game = new webcheckersGame(playerRed, playerWhite, board);
         gameCenter = new GameCenter();
         gameCenter.makeMatchAndSetUpGame(playerRed,playerWhite);
        game = gameCenter.getGameBy(playerRed.getPlayerName(),playerWhite.getPlayerName());
    }

    @After
    public void tearDown() throws Exception {

        game.setBoard(new Board());
    }


    @Test
    public void checkForOpponentForward() throws Exception {
      //  board.rows.get(5).spaces.get(0).setPiece(null);

        board.rows.get(3).spaces.get(2).setPiece( new Piece(Piece.Type.SINGLE,Color.RED));
        board.rows.get(4).spaces.get(3).setPiece( new Piece(Piece.Type.SINGLE,Color.WHITE));

        game.currentPlayer = playerRed;

       assertFalse(game.checkForOpponentForward(new Move (new Position(3,2),new Position(4,3))));

        game.setPlayerTurn(false);
        game.resignStatus("sdsd");

    }




    @Test
    public void checkForOpponentBackWard() throws Exception {
        board.rows.get(5).spaces.get(1).setPiece( new Piece(Piece.Type.SINGLE,Color.RED));
        board.rows.get(4).spaces.get(2).setPiece( new Piece(Piece.Type.SINGLE,Color.WHITE));
        game.currentPlayer = playerWhite;

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


    @Test
    public void getPlayerWhoHasResigned() throws Exception {



        game.playerWhoHasResigned = playerRed.getPlayerName();
        assertEquals(playerRed.getPlayerName(),game.getPlayerWhoHasResigned());
    }

    @Test
    public void getPlayerOne() throws Exception {

        assertEquals(playerRed.getPlayerName(),"OMAR");
    }

    @Test
    public void getOpponetPlayer() throws Exception {

        assertEquals(playerWhite.getPlayerName(),"ELIAS");

    }

    @Test
    public void isPlayerTurn() throws Exception {
        game.currentPlayer = playerRed;
        assertEquals(game.currentPlayer, playerRed);
        assertTrue( game.isPlayerTurn());

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
    public void makeTheMove() throws Exception {
    }

    @Test
    public void isValidMove() throws Exception {

        game.currentPlayer = playerWhite;

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


        for (int i =0; i<8; i ++)
        {
            for (int j =0; j<8; j ++)
            {
                game.getBoard().rows.get(i).spaces.get(j).setPiece(null);


            }

        }

        game.getBoard().rows.get(1).spaces.get(4).setPiece(new Piece(Piece.Type.SINGLE,Color.WHITE));

        Move beKing = new Move(new Position(1,4), new Position(0,3));
        game.isMoved = false;

        assertTrue(game.makeTheMove(beKing));

        assertEquals(Piece.Type.KING,game.getBoard().rows.get(0).spaces.get(3).getPiece().getType());

        game.isMoved = false;

        assertTrue(game.isValidMove(new Move(new Position(0,3), new Position(1,4))));

        assertFalse(game.isValidMove(new Move(new Position(0,3), new Position(1,3))));

        game.getBoard().rows.get(0).spaces.get(3).setPiece(new Piece(Piece.Type.SINGLE,Color.RED));

        assertFalse(game.isValidMove(new Move(new Position(0,3), new Position(1,3))));


        assertTrue(game.makeTheMove(new Move(new Position(0,3), new Position(1,4))  ));

        game.getBoard().rows.get(0).spaces.get(3).setPiece(new Piece(Piece.Type.KING,Color.RED));

        game.getBoard().rows.get(1).spaces.get(4).setPiece(new Piece(Piece.Type.SINGLE,Color.WHITE));

        assertFalse(game.isValidMove(new Move(new Position(0,3), new Position(2,5))));


        // red become king

        for (int i =0; i<8; i ++)
        {
            for (int j =0; j<8; j ++)
            {
                game.getBoard().rows.get(i).spaces.get(j).setPiece(null);


            }

        }
        game.getBoard().rows.get(6).spaces.get(4).setPiece(new Piece(Piece.Type.SINGLE,Color.RED));

        Move beKingRed = new Move(new Position(6,4), new Position(7,5));
        game.isMoved = false;

        assertTrue(game.makeTheMove(beKingRed));
        game.getBoard().rows.get(7).spaces.get(5).getPiece().setType(Piece.Type.KING);
       assertEquals(Piece.Type.KING,game.getBoard().rows.get(7).spaces.get(5).getPiece().getType());


    }




    @Test
    public void isWon() throws Exception {
        GameCenter center = new GameCenter();
        center.makeMatchAndSetUpGame(playerRed, playerWhite);

        game.getBoard().removedWhitePiece = 10;
        assertEquals(playerRed.getPlayerName(),game.isWon().getPlayerName());

        center.makeMatchAndSetUpGame(playerRed, playerWhite);
        game.getBoard().removedRedPiece = 10;
        assertNotEquals(playerWhite.getPlayerName(),game.isWon().getPlayerName());
    }

    @Test
    public void removePiece1() throws Exception {
        GameCenter center = new GameCenter();

        center.makeMatchAndSetUpGame(playerRed, playerWhite);

        game.removedSpace = board.rows.get(2).spaces.get(1);
        game.removePiece();
        assertNull(board.rows.get(2).spaces.get(1).getPiece());
    }

    @Test
    public void jumpBackwardMove() throws Exception {

    }

    @Test
    public void jumpCheck() throws Exception {

        Position startPosition = new Position(4, 3);
        Position endPosition3 = new Position(6, 1);

        Move move = new Move(startPosition, endPosition3);

        assertTrue(game.jumpCheck(move,Color.RED));

        assertFalse(game.jumpCheck(new Move(new Position(5, 0),new Position(3, 2)),Color.WHITE));


        Position start= new Position(3, 3);
        Position end = new Position(3, 3);

        Move badMove = new Move(start, end);

        assertFalse(game.jumpCheck(badMove,Color.RED));
        assertFalse(game.jumpCheck(badMove,Color.WHITE));


    }

    @Test
    public void equals() throws Exception {

        assertEquals(game,game);


        assertTrue(game.equals(game));
        webcheckersGame game1 = new webcheckersGame(playerRed,playerWhite,board);
        webcheckersGame game2 = new webcheckersGame(playerRed,playerWhite,board);

        assertTrue(game1.equals(game2));


        Board board2 = new Board();

        assertNotEquals(game,board2);


    }



}