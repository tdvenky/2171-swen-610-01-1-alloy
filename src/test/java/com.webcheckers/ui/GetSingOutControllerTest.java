package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.Session;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetSingOutControllerTest {
    private GameCenter gamecenter = new GameCenter();
    private GetSingOutController cut = new GetSingOutController(gamecenter);

    private Request request;
    private Session session;
    private Response response;


    @Before
    public void setUp() throws Exception {
        request = mock(Request.class);
        session = mock(Session.class);
        when(request.session()).thenReturn(session);
        when(session.attribute("playerName")).thenReturn("khalid");
        response = mock(Response.class);
    }
    @Test
    public void logout(){
        cut.handle(request,response);
    }
}