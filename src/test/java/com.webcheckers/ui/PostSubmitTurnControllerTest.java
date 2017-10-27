package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.Session;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostSubmitTurnControllerTest {
    private GameCenter gamecenter = new GameCenter();

    private static final Player PLAYER1 = new Player("test1", Player.color.RED);
    private static final Player PLAYER2 = new Player("test2", Player.color.WHITE);
    private Session session1 = mock(Session.class);

    private Request request = mock(Request.class);
    private Response response = mock(Response.class);
    PostSubmitTurnController cut;
    @Before
    public void setUp() throws Exception {
        gamecenter.registerPlayer( "test1");
        gamecenter.registerPlayer( "test2");

        gamecenter.makeMatchAndSetUpGame(PLAYER1,PLAYER2);


    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test(expected=NullPointerException.class)
//    public void SubmitTurn(){
//        cut = new PostSubmitTurnController(gamecenter);
//        cut.handle(request,response);
//    }

}