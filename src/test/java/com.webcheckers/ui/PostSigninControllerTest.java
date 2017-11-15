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

public class PostSigninControllerTest {
    private GameCenter gamecenter = new GameCenter();
    private PostSigninController cut = new PostSigninController(gamecenter);

    private Request request;
    private Session session;
    private Response response;


    @Before
    public void setUp() throws Exception {
        request = mock(Request.class);
        session = mock(Session.class);
        when(request.queryParams("PlayerName")).thenReturn("venky1");
        response = mock(Response.class);
    }
    @Test
    public void login(){
        assertNotNull(cut.handle(request,response));
    }
}