package com.webcheckers.ui;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class GameController implements TemplateViewRoute {
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
//        vm.put("title", "Welcome!");
//        vm.put("playerName", "Welcome!");
//        vm.put("playerColor", "Welcome!");
//        vm.put("isMyTurn", true);
//        vm.put("opponentName", "Welcome!");
//        vm.put("opponentColor", "Welcome!");
//        vm.put("message", "Welcome!");
//        vm.put("board", "Welcome!");
//        vm.put("currentPlayer", "Welcome!");
        return new ModelAndView(vm , "game.ftl");
    }
}
