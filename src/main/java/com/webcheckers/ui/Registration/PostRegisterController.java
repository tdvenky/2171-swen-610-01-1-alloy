package com.webcheckers.ui.Registration;

import com.webcheckers.appl.GameCenter;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static spark.Spark.halt;

public class PostRegisterController implements TemplateViewRoute {
    private final GameCenter gameCenter;
    final static String PLAYER_ATTR = "PlayerName";
    final static String ISTAKEN_ATTR = "isTaken";

    public PostRegisterController(GameCenter gameCenter) {
        //Validate that GameCenter is not null
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");
        this.gameCenter = gameCenter;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {
        final Map<String, Object> vm = new HashMap<>();
        final String playerNameStr = request.queryParams(PLAYER_ATTR);
        vm.put("title", "");
        if (!playerNameStr.isEmpty() || playerNameStr!=null) {

            if (gameCenter.registerPlayer(playerNameStr)) {

                gameCenter.PlayerNameAsSession(playerNameStr, request.session());
                response.redirect("/");
                halt();
                return null;
            } else {
                vm.put(ISTAKEN_ATTR, "is taken");
            }
        }

        return new ModelAndView(vm, "Registration.ftl");
    }
}

