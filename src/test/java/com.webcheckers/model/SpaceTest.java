package com.webcheckers.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceTest {

    Space Cut;
    Piece piece = new Piece(Piece.Type.SINGLE,Color.RED);
    @Before
    public void setUp() throws Exception {

        Cut = new Space(0,true,piece);

    }
    @Test
    public void getCellIdx() throws Exception {

        assertEquals(0,Cut.getCellIdx());
        assertNotEquals(1,Cut.getCellIdx());

    }

    @Test
    public void isValid() throws Exception {
        assertTrue(Cut.isValid());
        Cut = new Space(0,false,piece);

        assertFalse(Cut.isValid());

    }

    @Test
    public void getPiece() throws Exception {

        assertEquals(piece,Cut.getPiece());
        piece.setType(Piece.Type.KING);
        assertNotEquals(piece,Cut.getPiece().getType());
    }

    @Test
    public void setPiece() throws Exception {
        piece.setType(Piece.Type.KING);

        assertEquals(piece,Cut.getPiece());
    }

    @Test
    public void equals() throws Exception {


        assertEquals(Cut,Cut);

        assertTrue(Cut.equals(Cut));

        Space Cut1 = new Space(1,true,piece);

        assertFalse(Cut.equals(Cut1));

        assertFalse(Cut.equals(piece));




    }

}