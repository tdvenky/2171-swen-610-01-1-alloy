package com.webcheckers.ui;


import com.webcheckers.model.Board;
import com.webcheckers.model.Player;
import com.webcheckers.model.message;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;


public class PostLoginController implements TemplateViewRoute {

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();

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
