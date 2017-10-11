package com.webcheckers.ui;


import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Board;
import com.webcheckers.model.Player;
import com.webcheckers.model.message;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class PostLoginController implements TemplateViewRoute {
    private final GameCenter gameCenter;


    PostLoginController(final GameCenter gameCenter) {
        // validation
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");
        //
        this.gameCenter = gameCenter;
    }
    @Override
    public ModelAndView handle(Request request, Response response) {
      Map<String, Object> vm = new HashMap<>();

        String name = request.queryParams("login");
        gameCenter.loginPlayers.add(new Player(name, Player.color.RED));
       // System.out.println(gameCenter.userGame.values());
        response.redirect(WebServer.GAME_URL);
        String username = request.queryParams("login");
        String password = request.queryParams("password");

        if(username.equals("venkatesh") && password.equals("venkatesh") ||
                username.equals("khalid") && password.equals("khalid") ||
                username.equals("omar") && password.equals("omar") ||
                username.equals("kritin") && password.equals("kritin")) {
            response.redirect(WebServer.GAME_URL);
        } else {
            vm.put("title", "Welcome!");
            vm.put("errorMessage", "Invalid credentials");
        }



        return new ModelAndView(vm, "home.ftl");
    }

}
