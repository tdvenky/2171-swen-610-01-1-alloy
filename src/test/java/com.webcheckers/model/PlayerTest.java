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