package com.webcheckers.ui;
import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Color;
import com.webcheckers.model.Player;
import com.webcheckers.model.webcheckersGame;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameControllerTest {
    private GameCenter gamecenter = new GameCenter();

    private static final Player PLAYER1 = new Player("test1", Color.RED);
    private static final Player PLAYER2 = new Player("test2", Color.WHITE);
    private Session session = mock(Session.class);

    private Request request = mock(Request.class);
    private Response response = mock(Response.class);
    GameController cut;
    @Before
    public void setUp() throws Exception {
        gamecenter.registerPlayer( "test1");
        gamecenter.registerPlayer( "test2");
        gamecenter.makeMatchAndSetUpGame(PLAYER1,PLAYER2);
        when(request.session()).thenReturn(session);
        when(session.attribute("playerName")).thenReturn("test1");
        when(request.queryParams("OpponetPlayer")).thenReturn("test2");
        cut = new GameController(gamecenter);
    }


    @Test
    public void handel(){

        TestCase.assertNotNull(cut.handle(request,response));
    }
    @Test(expected = spark.HaltException.class)
    public void GameControllerDiffrentBehavior(){
        when(request.queryParams("OpponetPlayer")).thenReturn("test5");

        assertNull(cut.handle(request,response));
    }
    @Test
    public void GameControllerOp(){
        when(session.attribute("playerName")).thenReturn("test2");
        when(request.queryParams("OpponetPlayer")).thenReturn("test1");
        assertNotNull(cut.handle(request,response));
    }
    @Test(expected = spark.HaltException.class)
    public void WonGame(){

        webcheckersGame game = gamecenter.getGameBy(PLAYER1.getPlayerName(),PLAYER2.getPlayerName());
        game.currentPlayer = PLAYER1;
        game.getBoard().removedWhitePiece = 10;
        assertNull(cut.handle(request,response));
    }
    @Test(expected = spark.HaltException.class)
    public void WonOpGame(){

        webcheckersGame game = gamecenter.getGameBy(PLAYER1.getPlayerName(),PLAYER2.getPlayerName());
        game.currentPlayer = PLAYER2;
        game.getBoard().removedRedPiece = 10;
        assertNull(cut.handle(request,response));
    }


}