package com.webcheckers.ui;

import spark.*;

public class GetYouLostController implements TemplateViewRoute {
	@Override
	public ModelAndView handle(Request request, Response response) {
		return new ModelAndView(null, "youLost.ftl");
	}
}
