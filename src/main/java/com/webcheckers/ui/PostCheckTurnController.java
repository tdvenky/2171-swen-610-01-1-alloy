package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.webcheckersGame;
import spark.*;

import java.util.Objects;

public class PostCheckTurnController implements Route {

    private final GameCenter gameCenter;

    PostCheckTurnController(final GameCenter gameCenter) {
        //Validate that GameCenter is not null
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");
        this.gameCenter = gameCenter;
    }


    @Override
    public Object handle(Request request, Response response) {
        String playerOne = request.session().attribute("playerName");
        String playerOp = request.session().attribute(playerOne);

        System.out.println("PostSubmitTurnController "+playerOp);
        webcheckersGame game = gameCenter.getGameBy(playerOne, playerOp);
        if (game ==null){

            System.out.println("Game is null");
            response.redirect("/");
            return null;


        }



        return  game ==null || game.isTurn(game.currentPlayer);
    }
}