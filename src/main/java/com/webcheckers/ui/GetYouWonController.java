package com.webcheckers.ui;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class GetYouWonController implements TemplateViewRoute {
	@Override
	public ModelAndView handle(Request request, Response response) {
		return new ModelAndView(null, "youWon.ftl");
	}
}
