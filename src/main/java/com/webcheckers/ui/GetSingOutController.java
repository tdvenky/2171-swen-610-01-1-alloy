package com.webcheckers.ui;

import spark.*;

public class GetSingOutController implements TemplateViewRoute {
    @Override
    public ModelAndView handle(Request request, Response response) {

        request.session().removeAttribute("playerName");
        request.session().invalidate();

        response.redirect("/");
        return null;
    }
}
