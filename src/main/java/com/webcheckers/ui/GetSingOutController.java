package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import spark.*;

public class GetSingOutController implements TemplateViewRoute {
	GameCenter gameCenter;

	public GetSingOutController(GameCenter gameCenter) {
		this.gameCenter = gameCenter;
	}

	@Override
	public ModelAndView handle(Request request, Response response) {


		String Player = request.session().attribute("playerName");
		gameCenter.resignGameby(Player);
		gameCenter.removePlayer(request.session().attribute("playerName"));
		request.session().removeAttribute("playerName");
		request.session().removeAttribute(request.session().attribute("playerName"));
		request.session().invalidate();

		response.redirect("/");
		return null;
	}
}
