package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.webcheckersGame;
import spark.*;

import java.util.Objects;

public class PostCheckTurnController implements Route {

    private final GameCenter gameCenter;

    static final String PLAYER = "player";

    private webcheckersGame game;

    PostCheckTurnController(final GameCenter gameCenter) {
        //Validate that GameCenter is not null
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");
        this.gameCenter = gameCenter;
    }


    @Override
    public Object handle(Request request, Response response) {
        game = gameCenter.getGame(request.session());

        return game == null || game.isTurn(game.playerObjectFor(game.currentPlayer.getPlayerName()));
    }
}