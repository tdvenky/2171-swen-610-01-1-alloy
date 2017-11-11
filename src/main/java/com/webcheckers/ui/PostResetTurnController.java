package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateViewRoute;

public class PostResetTurnController implements  Route {
    public PostResetTurnController(GameCenter gameCenter) {
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        return null;
    }
}
