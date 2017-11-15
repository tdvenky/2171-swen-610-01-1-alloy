package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.Session;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HomeControllerTest {
    private GameCenter gamecenter = new GameCenter();

    private HomeController cut = new HomeController(gamecenter);

    private Request request;
    private Session session;
    private Response response;


    @Before
    public void setUp() throws Exception {
        request = mock(Request.class);
        session = mock(Session.class);
        when(request.session()).thenReturn(session);
        when(session.attribute("playerName")).thenReturn("khallid");
        response = mock(Response.class);
    }
    @Test
    public void homePage(){
        cut.handle(request,response);
    }

}