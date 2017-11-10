package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.webcheckersGame;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateViewRoute;

import java.util.Objects;

public class PostSubmitTurnController implements  Route {

    private final GameCenter gameCenter;

    static final String PLAYER = "player";

    private webcheckersGame game;

    PostSubmitTurnController(final GameCenter gameCenter) {
        //Validate that GameCenter is not null
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");
        this.gameCenter = gameCenter;
    }


    @Override
    public Object handle(Request request, Response response) {
        System.out.println(request.queryParams("GameID"));

        String playerOne = request.session().attribute("playerName");
        game = gameCenter.getGameBy(playerOne);
        if (game ==null){

            System.out.println("Game is null");
            response.redirect("/");
            return null;


        }


        game.switchTurn();
        response.redirect("/game");

        return null;
    }
}
