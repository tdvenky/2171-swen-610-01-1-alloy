package com.webcheckers.model;

import java.util.ArrayList;
import java.util.List;

public class webcheckersGame {
    /**
     * Attributes
     */
//    public List<Row> rows = new ArrayList<Row>();

    private  Player playerOne;
    private  Player opponetPlayer;
    private boolean playerTurn = true;
    public static Player currentPlayer;

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

    public com.webcheckers.model.message getMessage() {
        return message;
    }

    public void setMessage(com.webcheckers.model.message message) {
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
            currentPlayer = opponetPlayer;
           return playerTurn = false;
        }

        currentPlayer = playerOne;

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

    /**
     * the method will make the move depends on the move object. when the move reached the end of the board, it will become a king
     * @param move - Accepted Move parameter, which was sent from Json
     * @return - Void --
     */
    public void makeTheMove(Move move) {
        Piece piece = null;
        if (piece == null) {
            piece = board.rows.get(move.getStart().getRow()).spaces.get(move.getStart().getCell()).getPiece();

            board.rows.get(move.getStart().getRow()).spaces.get(move.getStart().getCell()).setPiece(null); // remove the piece from start portions

            if (piece.getType() == Piece.Type.SINGLE) {
                board.rows.get(move.getEnd().getRow()).spaces.get(move.getEnd().getCell()).setPiece(new Piece(Piece.Type.SINGLE, currentPlayer.getPlayerColor())); // moved

            } else {
                board.rows.get(move.getEnd().getRow()).spaces.get(move.getEnd().getCell()).setPiece(new Piece(Piece.Type.KING, currentPlayer.getPlayerColor())); // moved

            }

            // change the piece when it reaches 7 or 0 to be king
            if (currentPlayer.getPlayerColor() == Color.RED && move.getEnd().getRow() == 7 && piece.getType() == Piece.Type.SINGLE) {

                board.rows.get(move.getEnd().getRow()).spaces.get(move.getEnd().getCell()).setPiece(new Piece(Piece.Type.KING, currentPlayer.getPlayerColor()));


            } else if (currentPlayer.getPlayerColor() == Color.WHITE && move.getEnd().getRow() == 0 & piece.getType() == Piece.Type.SINGLE) {

                board.rows.get(move.getEnd().getRow()).spaces.get(move.getEnd().getCell()).setPiece(new Piece(Piece.Type.KING, currentPlayer.getPlayerColor()));


            }


        } else {
            System.out.println("piece is null");
        }


    }

    /**
     * Check if the move legal
     *
     * @param move - Given player name  d
     * @return - return boolean if the player is turned
     */
    public boolean isValidMove(Move move) {

        int startRow = move.getStart().getRow();
        int startCol = move.getStart().getCell();

        Piece playerPiece = board.rows.get(startRow).spaces.get(startCol).getPiece();


        if (playerPiece.getType() == Piece.Type.SINGLE) {

            if (playerPiece.getColor() == Color.RED) {
                System.out.println("single valid move.");
                System.out.println("red");
                System.out.println("getMoveMagnitude" + move.getMoveMagnitude());

                if (move.getMoveMagnitude() == 1) {

                    return singleMoveCheck(move, playerPiece.getColor());

                }
            } else if (playerPiece.getColor() == Color.WHITE) {
                // regular move
                if (move.getMoveMagnitude() == 1) {
                    return singleMoveCheck(move, playerPiece.getColor());

                }
            }
        }
        return false;
    }

    private boolean singleForwardMove(Move move) {

        int startRow = move.getStart().getRow();
        int startCol = move.getStart().getCell();
        int endRow = move.getEnd().getRow();
        int endCol = move.getEnd().getCell();

        if (((endRow == startRow + 1) && (endCol == startCol + 1)) || ((endRow == startRow + 1) && (endCol == startCol - 1))) {


            return true;
        } else {
            return false;
        }
    }

    private boolean singleBackwardMove(Move move) {

        int startRow = move.getStart().getRow();
        int startCol = move.getStart().getCell();
        int endRow = move.getEnd().getRow();
        int endCol = move.getEnd().getCell();

        if (((endRow == startRow - 1) && (endCol == startCol + 1)) || ((endRow == startRow - 1) && (endCol == startCol - 1))) {

            return true;
        } else {
            return false;
        }
    }

    private boolean singleMoveCheck(Move move, Color color) {


        if (color == Color.RED) {

            return singleForwardMove(move);

        } else if (color == Color.WHITE) {

            return singleBackwardMove(move);

        } else {
            return false;
        }
    }

    public boolean isTurn(Player player)
    {
        if (playerOne.getPlayerName().equals(player.getPlayerName()) && playerTurn)
        {
            return true;
        }

        return  false;
    }

}

