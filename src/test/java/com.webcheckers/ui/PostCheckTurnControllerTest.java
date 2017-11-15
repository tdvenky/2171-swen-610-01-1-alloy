package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Color;
import com.webcheckers.model.Player;
import com.webcheckers.model.webcheckersGame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.Session;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostCheckTurnControllerTest {

    private GameCenter gamecenter = new GameCenter();

    private static final Player PLAYER1 = new Player("test1", Color.RED);
    private static final Player PLAYER2 = new Player("test2", Color.WHITE);
    private Session session = mock(Session.class);

    private Request request = mock(Request.class);
    private Response response = mock(Response.class);
    PostCheckTurnController cut;
    @Before
    public void setUp() throws Exception {
        gamecenter.makeMatchAndSetUpGame(PLAYER1,PLAYER2);
        when(request.session()).thenReturn(session);

        when(session.attribute("playerName")).thenReturn("test1");
        when(request.attribute("OpponetPlayer")).thenReturn("test2");
        cut = new PostCheckTurnController(gamecenter);
    }

    @Test
    public void checkTurnNullGAme(){

        assertNull(cut.handle(request,response));
    }
    @Test
    public void checkTurn()
    {
        when(session.attribute("test1")).thenReturn("test2");

        assertTrue((Boolean) cut.handle(request,response));
    }



}