package com.webcheckers.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Player playerUnderTest ;

    @Before
    public void setUp() throws Exception {

         playerUnderTest = new Player("testNmae", Player.color.RED);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setPlayerNameAndColor() throws Exception {


        assertEquals("","testNmae",playerUnderTest.getPlayerName());
        assertEquals("", Player.color.RED,playerUnderTest.getPlayerColor());


    }

    @Test
    public void setPlayerStatus() throws Exception {
        playerUnderTest.setPlayerStatus(Player.status.WatingForMatch);
        assertEquals(Player.status.WatingForMatch,playerUnderTest.getPlayerStatus());
    }

    @Test
    public void getPlayerName() throws Exception {

        assertEquals("testNmae",playerUnderTest.getPlayerName());
    }

    @Test
    public void getPlayerColor() throws Exception {
        assertEquals( Player.color.RED,playerUnderTest.getPlayerColor());

    }

}