package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Color;
import com.webcheckers.model.Player;
import com.webcheckers.model.webcheckersGame;
import spark.*;

import static spark.Spark.halt;

public class GameController implements TemplateViewRoute {
	private final GameCenter gameCenter;
	private webcheckersGame game;

	GameController(final GameCenter gameCenter) {
		// validation
		Objects.requireNonNull(gameCenter, "gameCenter must not be null");
		//
		this.gameCenter = gameCenter;
	}

	@Override
	public ModelAndView handle(Request request, Response response) {
		Map<String, Object> vm = new HashMap<>();

		// getting Player Names
		String playerOne = request.session().attribute("playerName");
		String playerOppnot = request.queryParams("OpponetPlayer");

		vm.put("title", "welcome");

		// check if the names are not null
		game = gameCenter.getGameBy(playerOne, playerOppnot);

		if (game == null) {
			if (playerOne != null && playerOppnot != null) {
				// make the match and start game
				if (gameCenter.makeMatchAndSetUpGame(new Player(playerOne, Color.RED),
						new Player(playerOppnot, Color.WHITE))) {
					game = gameCenter.getGameBy(playerOne, playerOppnot);

				}

			} else {

				response.redirect("/");
				halt();
				return null;
			}
		}

		if (game == null) {
			response.redirect("/");
			halt();
			return null;
		}

		if (game.isWon() != null) {

			if (game.isWon().getPlayerName().equalsIgnoreCase(playerOne)) {
				response.redirect("/youWon");
				halt();
				return null;
			} else {
				response.redirect("/youLost");
				halt();
				return null;
			}

		}
		if (game.getPlayerOne().getPlayerName().equalsIgnoreCase(playerOne)) {
			vm.put("playerName", game.getPlayerOne().getPlayerName());
			vm.put("playerColor", game.getPlayerOne().getPlayerColor());

			vm.put("opponentName", game.getOpponetPlayer().getPlayerName());
			vm.put("opponentColor", game.getOpponetPlayer().getPlayerColor());
			vm.put("rotate", "rotate");

			request.session().attribute(playerOne, game.getOpponetPlayer().getPlayerName());

		} else {

			vm.put("playerName", game.getOpponetPlayer().getPlayerName());
			vm.put("playerColor", game.getOpponetPlayer().getPlayerColor());

			vm.put("opponentName", game.getPlayerOne().getPlayerName());
			vm.put("opponentColor", game.getPlayerOne().getPlayerColor());

			request.session().attribute(game.getOpponetPlayer().getPlayerName(), game.getPlayerOne().getPlayerName());

		}
		vm.put("title", "welcome");
		vm.put("GameID", game.getGameID());

		vm.put("isMyTurn", game.isTurn(playerOne));

		vm.put("message", game.getMessage());
		vm.put("board", game.getBoard());

		return new ModelAndView(vm, "./game.ftl");
	}
}
