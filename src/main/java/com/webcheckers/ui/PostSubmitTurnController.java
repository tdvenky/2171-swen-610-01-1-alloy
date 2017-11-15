package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Player;
import com.webcheckers.model.webcheckersGame;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateViewRoute;

import java.util.Objects;

import static spark.Spark.halt;

public class PostSubmitTurnController implements Route {

	private final GameCenter gameCenter;

	static final String PLAYER = "player";

	private webcheckersGame game;

	PostSubmitTurnController(final GameCenter gameCenter) {
		// Validate that GameCenter is not null
		Objects.requireNonNull(gameCenter, "gameCenter must not be null");
		this.gameCenter = gameCenter;
	}

	@Override
	public Object handle(Request request, Response response) {

		String playerOne = request.session().attribute("playerName");
		String playerOp = request.queryParams("OpponetPlayer");

		System.out.println("PostSubmitTurnController " + playerOp);
		game = gameCenter.getGameBy(playerOne, playerOp);
		if (game == null) {

			System.out.println("Game is null");
			response.redirect("/");
			return null;

		}

		// check who win the game.
		if (game.isWon() != null) {
			Player won = game.isWon();
			System.out.println(won.getPlayerColor());
			System.out.println(game.currentPlayer.getPlayerColor());

			if (game.currentPlayer.getPlayerColor().equals(won.getPlayerColor())) {
				game.switchTurn();

				response.redirect("/youWon");

			} else {
				game.switchTurn();

				response.redirect("/youLost");
			}

			gameCenter.resignGame(game);
			return null;

		}
		game.switchTurn();

		response.redirect("/");
		halt();

		return null;
	}
}
