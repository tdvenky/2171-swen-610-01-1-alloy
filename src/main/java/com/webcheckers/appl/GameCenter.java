package com.webcheckers.appl;

import com.webcheckers.model.Player;
import com.webcheckers.model.Row;
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

  //
  // Constants
  //


  /**
   * The user session attribute name that points to a game object.
   */
  public final static String GAME_ID = "game";

  public List<Player> loginPlayers = new ArrayList<Player>();

  public  Player player;
  public  Player opponetPlayer;

//
  // Attributes
  //


  //
  // Public methods
  //
  /**

   */


  /**
   * Get the {@linkplain GuessGame game} for the current user
   * (identified by a browser session).
   *
   * @param session
   *   The HTTP session
   *
   * @return
   *   A existing or new {@link GuessGame}
   */


  /**
   * End the user's current
   * and remove it from the session.
   *
   * @param session The HTTP session
   */
  public void end(Session session) {
    // validation
    Objects.requireNonNull(session, "session must not be null");
    // remove the game from the user's session
    session.removeAttribute(GAME_ID);
    // do some application-wide book-keeping
    synchronized (this) {  // protect the critical code

    }
  }

  public boolean isUserTaken(String playerName) {

    for(Player player : loginPlayers) {
       if(player.getPlayerName().trim().equals(playerName.trim())) {
         return true;
      }
    }
    return false;
  }

  public int getNumberOfPlayers() {
    return loginPlayers.size();
  }
}
