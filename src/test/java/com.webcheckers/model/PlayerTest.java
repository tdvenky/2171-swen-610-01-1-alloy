package com.webcheckers.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {



    Player playerUnderTest ;

    @Before
    public void setUp() throws Exception {

         playerUnderTest = new Player("testNmae", Color.RED);

    }
    @Test
    public void equals() throws Exception {

        Player playerUnderTest1 = new Player("testNmae", Color.RED);
        assertTrue(playerUnderTest1.equals(playerUnderTest1));

        assertEquals(playerUnderTest1,playerUnderTest1);


        Player p2 = new Player("d", Color.WHITE);

        assertFalse(playerUnderTest.equals(p2));
        assertFalse(playerUnderTest.equals(new Space(0,false,new Piece(Piece.Type.KING,Color.RED))));


    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setPlayerNameAndColor() throws Exception {


        assertEquals("","testNmae",playerUnderTest.getPlayerName());
        assertEquals("", Color.RED,playerUnderTest.getPlayerColor());


    }



    @Test
    public void getPlayerName() throws Exception {

        assertEquals("testNmae",playerUnderTest.getPlayerName());
    }

    @Test
    public void getPlayerColor() throws Exception {
        assertEquals( Color.RED,playerUnderTest.getPlayerColor());

    }

}