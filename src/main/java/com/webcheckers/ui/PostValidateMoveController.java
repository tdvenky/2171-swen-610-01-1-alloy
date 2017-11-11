package com.webcheckers.ui;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Move;
import com.webcheckers.model.message;
import com.webcheckers.model.webcheckersGame;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import spark.Request;
import spark.Response;
import spark.Route;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        String playerOne = request.session().attribute("playerName");


        final String data = request.body();

        final Move move = JsonUtils.fromJson(request.body(),Move.class);

        String playerOp = request.session().attribute(playerOne);

        if (playerOp==null){
            playerOp =  gameCenter.getOpponetplayerFromPairedList(playerOne);
        }

        System.out.println(playerOp+playerOne);
        game = gameCenter.getGameBy(playerOne,playerOp);
        if (game ==null){

            System.out.println("Game ais null");

            return new message("the other palaer has resign the game, you win this game. to exit  ", message.Type.info);
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
