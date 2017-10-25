package com.webcheckers.appl;

import com.webcheckers.model.Board;
import com.webcheckers.model.Player;
import com.webcheckers.model.webcheckersGame;
import spark.Session;

import java.util.*;
import java.util.logging.Logger;


/**
 * The object to coordinate the state of the Web Application.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
class PairGameWithPlayers{



  private String id;
  private String playerName;
  private String opponetPlayer;
  private webcheckersGame game;

  PairGameWithPlayers(String playerName,String opponetPlayer,webcheckersGame game){

    this.playerName = playerName;
    this.opponetPlayer = opponetPlayer;
    this.game = game;
    this.id =  playerName+opponetPlayer;


  }
  public String getId() {
    return id;
  }

  public String getPlayerName() {
    return playerName;
  }

  public String getOpponetPlayer() {
    return opponetPlayer;
  }

  public webcheckersGame getGame() {
    return game;
  }

}
public class GameCenter {
  private static final Logger LOG = Logger.getLogger(GameCenter.class.getName());

  // TODO: 10/20/17 strcture that have plaer name with there game id

  /**
   * The user session attribute name that points to a game object.
   */
  public final static String PLAYER_NAME = "playerName";


  public List<String> playersList = new ArrayList<String>();

  public List<webcheckersGame> getGames() {
    return games;
  }

  private List<webcheckersGame> games = new ArrayList<webcheckersGame>();

  public static List<PairGameWithPlayers> gamesPaired = new ArrayList<PairGameWithPlayers>();

  public  Player player;
  public  Player opponetPlayer;

  public boolean isGameCreated = false;


public boolean playerAlreadyPaired(String playerName){

  for(PairGameWithPlayers  gamesPaired : gamesPaired) {
    if(gamesPaired.getPlayerName().equalsIgnoreCase(playerName) || gamesPaired.getOpponetPlayer().equalsIgnoreCase(playerName)) {
      return true;
    }
  }
  return false;

}

  public GameCenter(){

    registerPlayer("khalid");
    registerPlayer("Venky");
    registerPlayer("Ommar");
    registerPlayer("kritin");

  }


  public String getOpponetplayerFromPairedList(String playerName){

    for(PairGameWithPlayers  gamesPaired : gamesPaired) {
      if(gamesPaired.getPlayerName().equalsIgnoreCase(playerName)) {
        return gamesPaired.getOpponetPlayer();
      }else {
        return gamesPaired.getPlayerName();
      }
    }
    return null;

  }

public void PlayerNameAsSession(String name, Session session ){

  session.attribute("playerName",name);


}

 public boolean makeMatchAndSetUpGame(Player player1,Player player2){
    if (!playerAlreadyPaired(player1.getPlayerName()) && !playerAlreadyPaired(player2.getPlayerName()) )
    {
      if (player1.getPlayerName().equalsIgnoreCase(player2.getPlayerName()) ){
        return false;
      }
      webcheckersGame game = new webcheckersGame(player1,player2, new Board());
      gamesPaired.add( new PairGameWithPlayers(player1.getPlayerName(),player2.getPlayerName(),game));
      return true;
    }else if (ArePlayersInSameGame(player1.getPlayerName(),player2.getPlayerName())) {
      return true;
    }else {
      return false;
    }
 }
 public boolean ArePlayersInSameGame(String player1,String player2) {

   for (PairGameWithPlayers gamesPaired : gamesPaired) {
     if (gamesPaired.getPlayerName().equalsIgnoreCase(player1) && gamesPaired.getOpponetPlayer().equalsIgnoreCase(player2)) {
       return true;
     } else if (gamesPaired.getPlayerName().equalsIgnoreCase(player2) && gamesPaired.getOpponetPlayer().equalsIgnoreCase(player1)) {
       return true;
     }

   }
   return false;

 }

 public webcheckersGame getGameBy(String Id){

   for (PairGameWithPlayers game: gamesPaired)
   {
     if (Id.equalsIgnoreCase(game.getId())){
       return game.getGame();
     }
   }
   return null;
 }
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
   // session.removeAttribute(GAME_ID);
    // do some application-wide book-keeping
    synchronized (this) {  // protect the critical code

    }
  }

  public boolean registerPlayer(String name){

    if (isUserTaken(name)){
     return false;

    }else {

      playersList.add(name.trim());
      return true;

    }

  }

  public boolean removePlayer(String name){

    if (isUserTaken(name)){
      playersList.remove(name.trim());
      return true;
    }else {
      return false;
    }

  }

  public boolean isUserTaken(String playerName) {

    for(String player : playersList) {
       if(player.trim().equalsIgnoreCase(playerName.trim())) {
         return true;
      }
    }
    return false;
  }


  public webcheckersGame getGame(Session session) {
    String name = session.attribute(PLAYER_NAME);

    for (webcheckersGame game: games)
    {
      if(game.isExsit(name))
      {
        return game;
      }
    }
    return null;
  }


}
