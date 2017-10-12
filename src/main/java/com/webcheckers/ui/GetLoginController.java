package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GetLoginController implements TemplateViewRoute {
    private final GameCenter gameCenter;

    public GetLoginController(final GameCenter gameCenter) {
        // validation
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");
        //
        this.gameCenter = gameCenter;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {

        final Map<String, Object> vm = new HashMap<>();
        if (gameCenter.loginPlayers.size()>0){
            System.out.println("print");
            vm.put("loginPlayers",gameCenter.loginPlayers );

        }
        return new ModelAndView(vm, "login.ftl");
    }
}
