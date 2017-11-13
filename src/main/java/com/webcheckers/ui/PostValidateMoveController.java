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
import org.json.JSONObject;
import spark.Request;
import spark.Response;
import spark.Route;


import java.io.IOException;
import java.util.*;

public class PostValidateMoveController implements  Route {

    private final GameCenter gameCenter;

    static final String PLAYER = "player";

    private webcheckersGame game;

    PostValidateMoveController(final GameCenter gameCenter) {
        //Validate that GameCenter is not null
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");
        this.gameCenter = gameCenter;
    }

    public static Map<String,String> parse(JSONObject json , Map<String,String> out) throws JSONException{
        Iterator<String> keys = json.keys();
        while(keys.hasNext()){
            String key = keys.next();
            String val = null;
            try{
                JSONObject value = json.getJSONObject(key);
                parse(value,out);
            }catch(Exception e){
                val = json.getString(key);
            }

            if(val != null){
                out.put(key,val);
            }
        }
        return out;
    }

    @Override
    public Object handle(Request request, Response response) throws JSONException {
        String playerOne = request.session().attribute("playerName");


        final String data = request.body();

        JSONObject object = new JSONObject();

        try {
             object = new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String opponetName = object.getString("OpponetPlayer");

        System.out.println("opponetName"+opponetName);
        String moveSt = object.getString("move");

        final Move move = JsonUtils.fromJson(moveSt,Move.class);

        String playerOp = object.getString("OpponetPlayer");



        game = gameCenter.getGameBy(playerOne,playerOp);
        if (game ==null){

            System.out.println("Game ais null");

            return new message("the other palaer has resign the game, you win this game. to exit  ", message.Type.info);
        }

        if (game.isValidMove(move)){
            if (game.makeTheMove(move)){
                game.removePiece();
                System.out.println(game.currentPlayer.getPlayerColor());
                return new message("Your move is legal .", message.Type.info);

            }else {
                return new message("Submit your move, you allow to Play on move.", message.Type.error);

            }





        }else {
            return new message("Your move is illegal ", message.Type.error);

        }
    }

}
