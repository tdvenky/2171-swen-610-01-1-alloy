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
    public   Player currentPlayer;

    private  String gameID ;
    private String playerWhoHasResigned;

    private boolean playerTurn = true;

    private Space removedSpace;

    private Board board;

    private message message;

    List<Move> moves = new ArrayList<Move>();

    private int numberCurrentPlayers = 2 ;


    public String getPlayerWhoHasResigned() { return playerWhoHasResigned; }

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




    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public webcheckersGame(final Player player, final Player opponetPlayer)
    {
        this.opponetPlayer = opponetPlayer;
        this.playerOne = player;
    }
    public void resignStatus(String playerWhoHasResigned){
        this.playerWhoHasResigned=playerWhoHasResigned;
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

                } else if (move.getMoveMagnitude() == 2) {  // Jump

                    return jumpCheck(move, playerPiece.getColor());
                }
            } else if (playerPiece.getColor() == Color.WHITE) {


                // regular move

                if (move.getMoveMagnitude() == 1) {
                    return singleMoveCheck(move, playerPiece.getColor());

                } else if (move.getMoveMagnitude() == 2) { // Jump

                    return jumpCheck(move, playerPiece.getColor());


                }


            }


        } else if (playerPiece.getType() == Piece.Type.KING) {

            System.out.println("getMoveMagnitude   :  " + move.getMoveMagnitude());

            if (move.getMoveMagnitude() == 1) { // singale move
                if (singleForwardMove(move) || singleBackwardMove(move)) {


                    return true;
                } else {
                    return false;
                }


            } else if (move.getMoveMagnitude() == 2) {

                if (jumpForwardMove(move)) {

                    return checkForOpponentForward(move);
                }

                if (jumpBackwardMove(move)) {
                    return checkForOpponentBackWard(move);

                }


            }

        }
        return false;

    }

    public boolean singleForwardMove(Move move) {

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

    public boolean singleBackwardMove(Move move) {

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

    public boolean singleMoveCheck(Move move, Color color) {


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


    /**
     * to check for jumping location in the forward direction for a disc. Checking the location in terms of rows and columns.
     * to check for red disc jump (which travels from row 0 to row 7) and king jump
     * @param move
     * @return true if valid move else false
     */
    public boolean jumpForwardMove(Move move) {
        if (((move.getEnd().getRow() == move.getStart().getRow() + 2) &&
                (((move.getEnd().getCell() == move.getStart().getCell() + 2))
                        || (move.getEnd().getCell() == move.getStart().getCell() - 2)))) {

            return true;
        } else {
            return false;
        }
    }

    public boolean checkForOpponentForward(Move move) {
        int startCol = move.getStart().getCell();
        int endCol = move.getEnd().getCell();
        Space jumpForwardSpace;

        if (startCol < endCol) {
            jumpForwardSpace = board.rows.get(move.getStart().getRow() + 1).spaces.get(move.getStart().getCell() + 1);

        } else {
            jumpForwardSpace = board.rows.get(move.getStart().getRow() + 1).spaces.get(move.getStart().getCell() - 1);

        }
        if (jumpForwardSpace != null) {
            if (currentPlayer.getPlayerColor() != jumpForwardSpace.getPiece().getColor()) {
                removedSpace = jumpForwardSpace;

                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean checkForOpponentBackWard(Move move) {

        int startCol = move.getStart().getCell();
        int endCol = move.getEnd().getCell();
        Space space;

        if (startCol < endCol) {
            space = board.rows.get(move.getStart().getRow() - 1).spaces.get(move.getStart().getCell() + 1);

        } else {
            space = board.rows.get(move.getStart().getRow() - 1).spaces.get(move.getStart().getCell() - 1);

        }


        if (space != null) {
            if (currentPlayer.getPlayerColor() != space.getPiece().getColor()) {
                removedSpace = space;
                return true;
            } else {
                return false;
            }
        }
        return false;

    }


    public void removePiece() {

        if (removedSpace != null) {

            System.out.println("r******************" + removedSpace.getCellIdx());
            System.out.println("***************" + removedSpace.getPiece().getColor());

            this.removedSpace.setPiece(null);
            this.removedSpace = null;

        }
    }


    /**
     * to jump in the backward direction. (for white coin which travels from row number 7 till row 0 and for the king jump)
     * @param move
     * @return true if valid jump else return false
     */
    public boolean jumpBackwardMove(Move move) {


        if (((move.getEnd().getRow() == move.getStart().getRow() - 2) &&
                (((move.getEnd().getCell() == move.getStart().getCell() - 2))
                        || (move.getEnd().getCell() == move.getStart().getCell() + 2)))) {

            return true;
        } else {
            return false;
        }
    }

    public boolean jumpCheck(Move move, Color color) { //checking before jumping whether the opponent disc is placed or no.


        if (color == Color.RED) {
            if (jumpForwardMove(move)) {
                return checkForOpponentForward(move);

            }


        } else {

            if (jumpBackwardMove(move)) {
                return checkForOpponentBackWard(move);
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        // If the object is compared with itself then return true
        if (obj == this) {
            return true;
        }


        if (!(obj instanceof webcheckersGame)) {
            return false;
        }

        obj = (webcheckersGame) obj;

        return  this.opponetPlayer == ((webcheckersGame) obj).opponetPlayer
                && this.playerTurn == ((webcheckersGame) obj).playerTurn
                && this.playerOne == ((webcheckersGame) obj).playerOne
                && this.playerWhoHasResigned == ((webcheckersGame) obj).playerWhoHasResigned
                && this.gameID == ((webcheckersGame) obj).gameID
                && this.currentPlayer == ((webcheckersGame) obj).currentPlayer
                && this.board == ((webcheckersGame) obj).board
                && this.message == ((webcheckersGame) obj).message
                && this.moves == ((webcheckersGame) obj).moves
                && this.numberCurrentPlayers == ((webcheckersGame) obj).numberCurrentPlayers;
    }
}


