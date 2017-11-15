package com.webcheckers.appl;

import com.webcheckers.model.*;
import spark.Session;

import java.util.*;
import java.util.logging.Logger;

/**
 * The object to coordinate the state of the Web Application.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */

public class GameCenter {
	private static final Logger LOG = Logger.getLogger(GameCenter.class.getName());

	/**
	 * The user session attribute name that points to a game object.
	 */
	public final static String PLAYER_NAME = "playerName";

	public List<String> playersList = new ArrayList<String>();

	public List<webcheckersGame> getGames() {
		return games;
	}

	private List<webcheckersGame> games = new ArrayList<webcheckersGame>();

	public List<PairGameWithPlayers> gamesPaired = new ArrayList<PairGameWithPlayers>();

	public List<PairGameWithPlayers> gameOver = new ArrayList<PairGameWithPlayers>();

	/**
	 * To check if thr palaer is liked with other Players. that meas if the user
	 * currently playing
	 * 
	 * @param playerName
	 *            the player name is key for checking if the user likned or not
	 * @return
	 */
	public boolean playerAlreadyPaired(String playerName) {

		for (PairGameWithPlayers gamesPaired : gamesPaired) {
			if (gamesPaired.gameStat == gameStatus.active) {
				if (gamesPaired.getPlayerName().equalsIgnoreCase(playerName)
						|| gamesPaired.getOpponetPlayer().equalsIgnoreCase(playerName)) {
					return true;
				}
			}
		}
		return false;

	}

	public GameCenter() {

		registerPlayer("khalid");
		registerPlayer("Venky");
		registerPlayer("Ommar");
		registerPlayer("kritten");

	}

	/**
	 * mehtod to send back the object of player that has the same name that been
	 * sent
	 * 
	 * @param plyerName
	 * @param game
	 * @return
	 */
	public Player getPlayerObjectBy(String plyerName, webcheckersGame game) {

		if (game.getPlayerOne().getPlayerName().equalsIgnoreCase(plyerName)) {
			return game.getPlayerOne();
		} else if (game.getOpponetPlayer().getPlayerName().equalsIgnoreCase(plyerName)) {
			return game.getOpponetPlayer();
		}
		return null;
	}

	/**
	 * This method to get the Opponent name from paired players
	 * 
	 * @param playerName
	 * @return
	 */
	public String getOpponetplayerFromPairedList(String playerName) {

		for (PairGameWithPlayers gamesPaired : gamesPaired) {
			if (gamesPaired.gameStat == gameStatus.active) {
				if (gamesPaired.getPlayerName().equalsIgnoreCase(playerName)) {
					return gamesPaired.getOpponetPlayer();
				} else {
					return gamesPaired.getPlayerName();
				}
			}
		}
		return null;

	}

	/**
	 * save the playerName in the created Session
	 * 
	 * @param name
	 * @param session
	 */
	public void PlayerNameAsSession(String name, Session session) {

		session.attribute("playerName", name);

	}

	/**
	 * this method is the key method that start game between to players.
	 * 
	 * @param player1
	 * @param player2
	 * @return return true if the tow players match, and false if not
	 */
	public boolean makeMatchAndSetUpGame(Player player1, Player player2) {
		if (!playerAlreadyPaired(player1.getPlayerName()) && !playerAlreadyPaired(player2.getPlayerName())) {
			if (player1.getPlayerName().equalsIgnoreCase(player2.getPlayerName())) {
				return false;
			}
			webcheckersGame game = new webcheckersGame(player1, player2, new Board());

			game.setGameID(player1.getPlayerName() + player2.getPlayerName());

			game.currentPlayer = player1;

			PairGameWithPlayers linked = new PairGameWithPlayers(player1.getPlayerName(), player2.getPlayerName(),
					game);

			linked.gameStat = gameStatus.active;

			addPairedGame(linked);
			return true;
		} else if (ArePlayersInSameGame(player1.getPlayerName(), player2.getPlayerName())) {
			return true;
		} else {
			return false;
		}
	}

	public void addPairedGame(PairGameWithPlayers game) {
		for (PairGameWithPlayers gamesPaired : gamesPaired) {

			if (gamesPaired.getId().equalsIgnoreCase(game.getId())) {
				return;
			}

		}

		gamesPaired.add(game);
	}

	/**
	 * this main purpose of the method is to check if the players paling same game.
	 * 
	 * @param player1
	 * @param player2
	 * @return True if yes same game , False if not
	 */
	public boolean ArePlayersInSameGame(String player1, String player2) {

		for (PairGameWithPlayers gamesPaired : gamesPaired) {
			if (gamesPaired.gameStat == gameStatus.active) {

				if (gamesPaired.getPlayerName().equalsIgnoreCase(player1)
						&& gamesPaired.getOpponetPlayer().equalsIgnoreCase(player2)) {
					return true;
				} else if (gamesPaired.getPlayerName().equalsIgnoreCase(player2)
						&& gamesPaired.getOpponetPlayer().equalsIgnoreCase(player1)) {
					return true;
				}

			}
		}
		return false;

	}

	/**
	 * get the game data
	 * 
	 * @param player1,player2
	 * @return game object , null if there is no game
	 */
	public webcheckersGame getGameBy(String player1, String player2) {

		for (PairGameWithPlayers game : gamesPaired) {
			if (game.gameStat == gameStatus.active) {
				if (game.getId().equalsIgnoreCase(player1 + player2)) {
					return game.getGame();
				} else if (game.getId().equalsIgnoreCase(player2 + player1)) {

					return game.getGame();

				}
			}
		}
		return null;
	}

	public List<String> getPlayerWinGames(String palyerName) {

		List<String> wins = new ArrayList<String>();

		for (PairGameWithPlayers PlayedGame : gameOver) {

			if (PlayedGame.getOpponetPlayer().equalsIgnoreCase(palyerName)
					|| PlayedGame.getPlayerName().equalsIgnoreCase(palyerName)) {
				if (PlayedGame.getGame().getPlayerWhoHasResigned() != null) {
					if (!PlayedGame.getGame().getPlayerWhoHasResigned().equals(palyerName)) {
						wins.add("You Won the Game against " + PlayedGame.getGame().getPlayerWhoHasResigned());

					}
				} else {

					if (PlayedGame.getGame().isWon().getPlayerName().equalsIgnoreCase(palyerName)) {
						wins.add("You Won the Game against " + PlayedGame.getGame().getOpponetPlayer().getPlayerName());

					}
				}

			}

		}

		return wins;
	}



	public PairGameWithPlayers getPairObjectBy(webcheckersGame game) {
		for (PairGameWithPlayers gameObject : gamesPaired) {

			if (game.equals(gameObject.getGame())) {

				return gameObject;

			}
		}
		return null;
	}

	public void resignGameby(String playerName) {

		Iterator<PairGameWithPlayers> iter = gamesPaired.iterator();

		while (iter.hasNext()) {
			PairGameWithPlayers temp = iter.next();

			if (temp.getPlayerName().equalsIgnoreCase(playerName)) {

				gameOver.add(temp);
				gamesPaired.remove(temp);
			} else if (temp.getOpponetPlayer().equalsIgnoreCase(playerName)) {

				gameOver.add(temp);
				gamesPaired.remove(temp);
			}
		}

	}

	public void resignGame(webcheckersGame game) {
		PairGameWithPlayers temp = getPairObjectBy(game);

		if (temp != null) {
			gameOver.add(temp);
			gamesPaired.remove(temp);
		}
	}

	// user Management

	/**
	 * registerPlayer
	 * 
	 * @param name
	 * @return True if the user is resisted
	 */
	public boolean registerPlayer(String name) {

		if (isUserTaken(name)) {
			return false;

		} else {

			playersList.add(name.trim());
			return true;

		}

	}

	/**
	 * relase the name of the game
	 * 
	 * @param name
	 * @return
	 */
	public boolean removePlayer(String name) {

		if (isUserTaken(name)) {
			playersList.remove(name.trim());
			return true;
		} else {
			return false;
		}

	}

	/**
	 * check if the User name is Taken
	 * 
	 * @param playerName
	 * @return True if the user name is taken , false is not.
	 */
	public boolean isUserTaken(String playerName) {

		for (String player : playersList) {
			if (player.trim().equalsIgnoreCase(playerName.trim())) {
				return true;
			}
		}
		return false;
	}

}
