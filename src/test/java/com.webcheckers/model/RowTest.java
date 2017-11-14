package com.webcheckers.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RowTest {

    Board board = new Board();
    Row row = board.rows.get(0);

    @Before
    public void setUp() throws Exception {
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
    public void getIndex() throws Exception {
        assertEquals(0,row.getIndex());
    }

    @Test
    public void iterator() throws Exception {

        assertNotNull(board.rows);
        assertNotNull(board.rows.iterator());
        assertNotNull(row.iterator());

    }

    @Test
    public void equals() throws Exception {

        assertEquals(row,row);

        assertTrue(row.equals(row));

        Row row1 = board.rows.get(1);

        assertFalse(row.equals(row1));

        assertFalse(row.equals(board));

    }

}