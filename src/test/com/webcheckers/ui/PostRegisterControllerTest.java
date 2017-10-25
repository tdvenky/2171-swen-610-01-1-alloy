package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Player;
import com.webcheckers.ui.Registration.PostRegisterController;
import org.junit.Before;
import org.junit.Test;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostRegisterControllerTest {

    private GameCenter gamecenter = new GameCenter();
    private PostRegisterController cut = new PostRegisterController(gamecenter);

    private Request request;
    private Session session;
    private Response response;
    private Player player;


    static final String PLAYER_ATTR = "PlayerName";

    static final String USERNAME1 = "test1";


    @Before
    public void setUp() throws Exception {
        request = mock(Request.class);
        player = mock(Player.class);
        session = mock(Session.class);
        when(request.session()).thenReturn(session);
        response = mock(Response.class);
    }
    @Test(expected=spark.HaltException.class)
    public void registeredSucss(){
        when(request.queryParams(PLAYER_ATTR)).thenReturn(USERNAME1);
        final ModelAndView result = cut.handle(request, response);
    }


}