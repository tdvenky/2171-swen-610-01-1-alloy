package com.webcheckers.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PieceTest {
    Piece piece;
    Piece piece1;

    @Before
    public void setUp() throws Exception {
        piece = new Piece(Piece.Type.KING,Color.RED);
        piece1 = new Piece(Piece.Type.KING,Color.WHITE);
    }

    @Test
    public void getType() throws Exception {

        assertEquals(piece.getType(), Piece.Type.KING);
    }

    @Test
    public void getColor() throws Exception {
        assertEquals(piece.getColor(),Color.RED);

    }

    @Test
    public void setType() throws Exception {

        piece.setType(Piece.Type.SINGLE);
        assertEquals(piece.getType(),Piece.Type.SINGLE);

    }

    @Test
    public void equals() throws Exception {
        assertEquals(piece,piece);

        assertNotEquals(piece,piece1);

        assertNotEquals(piece,new Space(0,true,piece));



    }

}