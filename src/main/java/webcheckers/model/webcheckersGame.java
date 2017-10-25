package webcheckers.model;

import java.util.ArrayList;
import java.util.List;

public class webcheckersGame {
    /**
     * Attributes
     */
//    public List<Row> row = new ArrayList<Row>();

    private  Player playerOne;
    private  Player opponetPlayer;
    private boolean playerTurn = true;
    public String currentPlayerName ;

    public Player getPlayerOne() {
        return playerOne;
    }


    public Player getOpponetPlayer() {
        return opponetPlayer;
    }


    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public webcheckers.model.message getMessage() {
        return message;
    }

    public void setMessage(webcheckers.model.message message) {
        this.message = message;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getNumberCurrentPlayers() {
        return numberCurrentPlayers;
    }

    public void setNumberCurrentPlayers(int numberCurrentPlayers) {
        this.numberCurrentPlayers = numberCurrentPlayers;
    }

    private Board board;

    private message message;
    List<Move> moves = new ArrayList<Move>();
    private int numberCurrentPlayers = 2 ;


    public webcheckersGame(final Player player, final Player opponetPlayer)
    {
        this.opponetPlayer = opponetPlayer;
        this.playerOne = player;
    }

    /**
     * @param player
     * @param opponetPlayer
     * @param board
     */
    public webcheckersGame(final Player player, final Player opponetPlayer,final Board board)
    {
        this(player,opponetPlayer);
        this.board = board;

    }


    /**
     *  exaplant
     */
    public void backupMove()
    {

    }

    /**
     *
     *
     * @return - Returns a boolean showing which players turn is playing now
     */
    public boolean switchTurn()
    {
        if (playerTurn)
        {
            currentPlayerName = opponetPlayer.getPlayerName();
           return playerTurn = false;
        }

        currentPlayerName = playerOne.getPlayerName();

        return playerTurn= true;
    }

    /**
     * Checks if the game object has a player with the given name
     *
     * @param playerName
     *            - Given name to be found
     * @return - return boolean if the player is in the game or not
     */

    public boolean isExsit(String playerName)
    {
        return opponetPlayer.getPlayerName().equals(playerName) || playerOne.getPlayerName().equals(playerName);
    }
    public Player playerObjectFor(String playerName)
    {
        if (playerOne.getPlayerName().equals(playerName)){

            return  playerOne;
          }
          return opponetPlayer;
    }

    // TODO: 10/20/17 how to set the cureent player. who request the game will be frist
    public boolean isTurn(Player player)
    {
        if (playerOne.getPlayerName().equals(player.getPlayerName()) && playerTurn)
        {
            return true;
        }

        return  false;
    }

}

