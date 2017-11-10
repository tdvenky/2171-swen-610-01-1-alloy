package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.message;
import com.webcheckers.model.webcheckersGame;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GetResignController implements TemplateViewRoute, Route {
    private final GameCenter gameCenter;
    public GetResignController(GameCenter gameCenter) {

        Objects.requireNonNull(gameCenter, "gameCenter must not be null");
        this.gameCenter= gameCenter;

    }

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        String playerOne = request.session().attribute("playerName");

        webcheckersGame game = gameCenter.getGameBy(playerOne);
        if (game ==null){

            System.out.println("Game is null");

        }
        game.resignStatus(playerOne);
        gameCenter.makeGameInactive(game);
        return new ModelAndView(vm,"youLost.ftl");

    }
}
