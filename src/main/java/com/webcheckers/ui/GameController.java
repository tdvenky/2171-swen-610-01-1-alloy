package com.webcheckers.ui;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Color;
import com.webcheckers.model.Player;
import com.webcheckers.model.webcheckersGame;
import spark.*;

import static spark.Spark.halt;


public class GameController implements TemplateViewRoute {
    private final GameCenter gameCenter;
    private  webcheckersGame game ;


    GameController(final GameCenter gameCenter) {
        // validation
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");
        //
        this.gameCenter = gameCenter;
    }


    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();


        String playerOne = request.session().attribute("playerName");
        String playerOppnot = request.queryParams("OpponetPlayer");




        System.out.println("playerOne  "+playerOne);
        System.out.println("playerOppnot  "+playerOppnot);
        if (playerOne != null && playerOppnot != null){

            if (gameCenter.makeMatchAndSetUpGame(new Player(playerOne, Color.RED),new Player(playerOppnot, Color.WHITE))){

                game = gameCenter.getGameBy(playerOne);
                if(game == null){

                    System.out.println("game is null");
                }
                System.out.println("game  "+game.getGameID());

                vm.put("title", "welcome");
                vm.put("GameID",game.getGameID() );



                if (game.getPlayerOne().getPlayerName().equalsIgnoreCase(playerOne)){
                    vm.put("playerName",  game.getPlayerOne().getPlayerName());
                    vm.put("playerColor", game.getPlayerOne().getPlayerColor());

                    vm.put("opponentName", game.getOpponetPlayer().getPlayerName());
                    vm.put("opponentColor", game.getOpponetPlayer().getPlayerColor());
                    vm.put("rotate","rotate");


                }else {

                    vm.put("playerName",  game.getOpponetPlayer().getPlayerName());
                    vm.put("playerColor", game.getOpponetPlayer().getPlayerColor());

                    vm.put("opponentName", game.getPlayerOne().getPlayerName());
                    vm.put("opponentColor", game.getPlayerOne().getPlayerColor());


                }

                if (game.currentPlayer.getPlayerName().equalsIgnoreCase(playerOne)){
                    vm.put("isMyTurn", true);

                }else {
                    vm.put("isMyTurn", false);

                }
                vm.put("message", game.getMessage());
                vm.put("board", game.getBoard());

            }
        }else {

            response.redirect("/");
            halt();
            return null;
        }


        return new ModelAndView(vm, "./game.ftl");
    }

}
