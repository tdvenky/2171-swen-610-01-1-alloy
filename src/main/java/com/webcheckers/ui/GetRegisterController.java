package com.webcheckers.ui;

import spark.*;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.halt;

public class GetRegisterController implements TemplateViewRoute {
	static final String VIEW_NAME = "Registration.ftl";
	static final String TITLE_ATTR = "title";

	@Override

	public ModelAndView handle(Request request, Response response) {
		Map<String, Object> vm = new HashMap<>();
		if (request.session().attributes().contains("playerName")) {
			response.redirect("/");
			halt();
			return null;
		}
		vm.put(TITLE_ATTR, "Registration Page");
		return new ModelAndView(vm, VIEW_NAME);
	}
}
