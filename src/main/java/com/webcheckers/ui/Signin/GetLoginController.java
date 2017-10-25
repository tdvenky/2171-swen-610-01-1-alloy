package com.webcheckers.ui.Signin;

import com.webcheckers.appl.GameCenter;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static spark.Spark.halt;

public class GetLoginController implements TemplateViewRoute {
    static final String VIEW_NAME = "signin.ftl";
    static final String TITLE_ATTR = "title";



    @Override
    public ModelAndView handle(Request request, Response response) {

        if(request.session().attributes().contains("playerName"))
        {
            response.redirect("/");
            halt();
            return null;
        }
        final Map<String, Object> vm = new HashMap<>();
        vm.put(TITLE_ATTR,"Sign In");
        return new ModelAndView(vm, VIEW_NAME);
    }
}
