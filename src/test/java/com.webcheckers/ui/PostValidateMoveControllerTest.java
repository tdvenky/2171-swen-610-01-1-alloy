package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Color;
import com.webcheckers.model.Player;
import com.webcheckers.model.message;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.Session;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostValidateMoveControllerTest {
    static final String PLAYER_NAME = "playerName";
    private static final String p1 = "a";
    private static final String p2 = "b";
    private static final Player player = new Player("a", Color.RED);
    private static final Player player2 = new Player("b", Color.RED);

    private Session session1 = mock(Session.class);
    private Session session2 = mock(Session.class);

    private Request request1;
    private Request request2;
    private Response response;
    private GameCenter gamecenter = new GameCenter();
    private PostValidateMoveController cut;


    @Before
    public void setup()
    {
        request1 = mock(Request.class);
        request2 = mock(Request.class);
        when(request1.body())

                .thenReturn("{\"move\":{\"start\":{\"row\":\"2\",\"cell\":\"5\"},\"end\":{\"row\":\"3\",\"cell\":\"6\"}},\"OpponetPlayer\":\"a\"}\"OpponetPlayer\":\"b}");
        when(request2.body())
                .thenReturn("{\"move\":{\"start\":{\"row\":\"5\",\"cell\":\"4\"},\"end\":{\"row\":\"4\",\"cell\":\"3\"}},\"OpponetPlayer\":\"a\"}");
        when(request1.session()).thenReturn(session1);
        when(request2.session()).thenReturn(session2);
        when(session1.attribute("a")).thenReturn(player);
        when(session2.attribute("b")).thenReturn(player2);


        when(session1.attribute(PLAYER_NAME)).thenReturn(p1);
        when(session2.attribute(PLAYER_NAME)).thenReturn(p2);
        response = mock(Response.class);
        gamecenter.makeMatchAndSetUpGame(player, player2);
        cut = new PostValidateMoveController(gamecenter);
    }

    @Test
    public void handle() throws JSONException {
        assertEquals(message.class, cut.handle(request1, response).getClass());
        assertEquals(message.class, cut.handle(request2, response).getClass());
        when(request2.body())
                .thenReturn("{\"move\":{\"start\":{\"row\":\"7\",\"cell\":\"4\"},\"end\":{\"row\":\"4\",\"cell\":\"3\"}},\"OpponetPlayer\":\"a\"}");
        assertEquals(message.class, cut.handle(request2, response).getClass());

    }


}