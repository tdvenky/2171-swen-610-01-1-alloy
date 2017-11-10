package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Move;
import com.webcheckers.model.Piece;
import com.webcheckers.model.message;
import com.webcheckers.model.webcheckersGame;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateViewRoute;

import java.awt.*;
import java.util.Objects;

public class PostValidateMoveController implements  Route {

    private final GameCenter gameCenter;

    static final String PLAYER = "player";

    private webcheckersGame game;

    PostValidateMoveController(final GameCenter gameCenter) {
        //Validate that GameCenter is not null
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");
        this.gameCenter = gameCenter;
    }


    @Override
    public Object handle(Request request, Response response) {
        final Move move = JsonUtils.fromJson(request.body(), Move.class);

        String playerOne = request.session().attribute("playerName");

        game = gameCenter.getGameBy(playerOne);
        if (game ==null){

            System.out.println("Game is null");
            return new message("problem has happened  .", message.Type.error);

        }

        if (game.isValidMove(move)){
            game.makeTheMove(move);
            game.removePiece();
            System.out.println(game.currentPlayer.getPlayerColor());


            return new message("Your move is legal .", message.Type.info);


        }else {
            return new message("Your move is illegal ", message.Type.error);

        }
    }
}
