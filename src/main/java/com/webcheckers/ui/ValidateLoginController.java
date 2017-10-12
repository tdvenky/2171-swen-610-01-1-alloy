package com.webcheckers.ui;


import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Board;
import com.webcheckers.model.Player;
import com.webcheckers.model.message;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class ValidateLoginController implements TemplateViewRoute {
    private final GameCenter gameCenter;


    ValidateLoginController(final GameCenter gameCenter) {
        // validation
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");
        //
        this.gameCenter = gameCenter;
    }
    @Override
    public ModelAndView handle(Request request, Response response) {
      Map<String, Object> vm = new HashMap<>();
        vm.put("title", "Welcome!");
        String name = request.queryParams("login");
        String selectedOpponent = request.queryParams("opponentList");
        Boolean added = false;
        String AddedName = null;
        vm.put("errorMessage", "");

        if (name != AddedName){
            if(!gameCenter.isUserTaken(name)) {
                gameCenter.loginPlayers.add(new Player(name, Player.color.RED));
                added = true;
                AddedName = name;
                // System.out.println(gameCenter.userGame.values());
            } else {
                vm.put("title", "Welcome!");
                vm.put("errorMessage", "Username has already been taken, try another name!");
            }
        }


            if (selectedOpponent != null && !selectedOpponent.equals("opponent")&& AddedName !=null){

                gameCenter.player = new Player(name, Player.color.RED);
                gameCenter.opponetPlayer = new Player(selectedOpponent, Player.color.WHITE);

                response.redirect(WebServer.GAME_URL);

            }else {
                vm.put("playNmae", name);

                vm.put("errorMessage", ""+name+" has been added but  No opponents are present to play the game OR you didn't select an opponent!");

            }
        if (gameCenter.loginPlayers.size()>0){
            vm.put("loginPlayers",gameCenter.loginPlayers );

        }



        return new ModelAndView(vm, "login.ftl");
    }



}
