package com.webcheckers.appl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameCenterTest {
    GameCenter test1;
    @Before
    public void setUp() throws Exception {
        test1= new GameCenter();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void registerPlayer() throws Exception {
        assertTrue("the player is registered",test1.registerPlayer("k1"));
    }

    @Test
    public void registerPlayerNot() throws Exception {
        test1.registerPlayer("k1");
        assertFalse("the player is not registered",test1.registerPlayer("k1"));
    }

}