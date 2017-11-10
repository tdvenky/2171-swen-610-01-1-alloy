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

  public boolean isGameCreated = false;


public boolean playerAlreadyPaired(String playerName){

  for(PairGameWithPlayers  gamesPaired : gamesPaired) {
    if(gamesPaired.getPlayerName().equalsIgnoreCase(playerName) || gamesPaired.getOpponetPlayer().equalsIgnoreCase(playerName)) {
      if (gamesPaired.gameStat == gameStatus.active){
        return true;

      }else {
        return false;
      }
    }
  }
  return false;

}

  public GameCenter(){

    registerPlayer("khalid");
    registerPlayer("Venky");
    registerPlayer("Ommar");
    registerPlayer("kritten");

    Player pl = new Player("hjsdj", Color.RED);
    Player p2 = new Player("hjsdj", Color.RED);
    Board board= new Board();


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

      game.setGameID(player1.getPlayerName()+player2.getPlayerName());

      game.currentPlayer = player1;

      PairGameWithPlayers linked = new PairGameWithPlayers(player1.getPlayerName(),player2.getPlayerName(),game);
      linked.gameStat = gameStatus.active;

      gamesPaired.add(linked );

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

 public webcheckersGame getGameBy(String playerName){



   for (PairGameWithPlayers game: gamesPaired)
   {
     System.out.println("getGameBy"+game.getId());
     if (playerName.equalsIgnoreCase(game.getPlayerName())){
       return game.getGame();
     }else if (playerName.equalsIgnoreCase(game.getOpponetPlayer())){
       return game.getGame();

     }
   }
   return null;
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



public List<String> getPlayerWinGames(String palyerName){

  List<PairGameWithPlayers> temp = getPlayerPlayedGames(palyerName);
  List<String> wins = new ArrayList<String>();

  for (PairGameWithPlayers PlayedGame: temp){

    if (PlayedGame.gameStat == gameStatus.inActive){
      if (!PlayedGame.getGame().getPlayerWhoHasResigned().equals(palyerName))
      wins.add("won against"+PlayedGame.getGame().getPlayerWhoHasResigned());
    }
  }
  System.out.println("game wins "+wins.size());

  return wins;
}
  private List<PairGameWithPlayers> getPlayerPlayedGames(String palyerName){
     List<PairGameWithPlayers> temp = new ArrayList<PairGameWithPlayers>();

    for (PairGameWithPlayers gameObject: gamesPaired)
    {
     if(gameObject.getPlayerName().equals(palyerName)){
       temp.add(gameObject);
     }else if (gameObject.getOpponetPlayer().equals(palyerName)){

       temp.add(gameObject);

     }
    }

    return temp;
  }

 public void makeGameInactive(webcheckersGame game){

   for (PairGameWithPlayers gameObject: gamesPaired)
   {
     if (game.equals(gameObject.getGame())){

        gameObject.gameStat = gameStatus.inActive;

     }
   }


 }



}
