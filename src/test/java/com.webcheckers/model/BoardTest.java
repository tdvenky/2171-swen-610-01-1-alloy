package com.webcheckers.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {


    Board board = new Board();
    @Test
    public void iterator() throws Exception {
        assertNotNull(board.rows);
        assertNotNull(board.iterator());



    }

    @Test
    public void equals() throws Exception {
        assertEquals(board,board);

        assertEquals(board.rows,board.rows);

        assertTrue(board.equals(board));


        Board board2 = new Board();
        board2.rows.get(0).spaces.get(1).getPiece().setType(Piece.Type.KING);

        assertNotEquals(board,board2);

        assertNotEquals(board.rows,board2.rows);

        assertNotEquals(board,new Player("khakid",Color.RED));
    }

    @Test
    public void getRemovedRedPiece() throws Exception {

        assertEquals(0,board.getRemovedRedPiece());

        assertNotEquals(2,board.getRemovedRedPiece());


    }

    @Test
    public void getRemovedWhitePiece() throws Exception {

        assertEquals(0,board.getRemovedWhitePiece());

        assertNotEquals(2,board.getRemovedWhitePiece());

    }

}