package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.Session;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetResignControllerTest {
    private GameCenter gamecenter = new GameCenter();
    private GetResignController cut = new GetResignController(gamecenter);

    private Request request;
    private Session session;
    private Response response;
    private Player player;


    static final String PLAYER_ATTR = "PlayerName";



    @Before
    public void setUp() throws Exception {
        request = mock(Request.class);
        session = mock(Session.class);

        response = mock(Response.class);
    }
    @Test(expected = spark.HaltException.class)
    public void handle() throws Exception {
        when(request.session()).thenReturn(session);
        when(session.attribute(PLAYER_ATTR)).thenReturn("khalid");
        cut.handle(request,response);
    }
    @Test(expected = spark.HaltException.class)
    public void handle1() throws Exception {
        when(request.session()).thenReturn(session);
        when(session.attribute("playerName")).thenReturn("test1");
        when(request.attribute("OpponetPlayer")).thenReturn("test2");
        assertNull(cut.handle(request,response));


    }

}