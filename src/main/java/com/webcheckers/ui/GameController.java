package com.webcheckers.ui;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Board;
import com.webcheckers.model.Player;
import com.webcheckers.model.message;
import spark.*;


public class GameController implements TemplateViewRoute {
    private final GameCenter gameCenter;


    GameController(final GameCenter gameCenter) {
        // validation
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");
        //
        this.gameCenter = gameCenter;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();

<<<<<<< HEAD

        Player player = new Player("khalid", Player.color.RED);
        Player opponetPlayer = new Player("abood", Player.color.WHITE);
=======
        Player player = new Player("kritin", Player.color.White);
        Player opponetPlayer = new Player("khalid", Player.color.RED);
>>>>>>> e91ff59bac406266e67248e3fcb11cb5228be2eb
        Board board = new Board();
        Boolean isMyTurn = false;
        message message = new message("", com.webcheckers.model.message.Type.info);
        vm.put("title", "welcome");
        vm.put("currentPlayer", player);
        vm.put("playerName", player.getPlayerName());
        vm.put("playerColor", player.getPlayerColor());
        vm.put("opponentName", opponetPlayer.getPlayerName());
        vm.put("opponentColor", opponetPlayer.getPlayerColor());
        vm.put("isMyTurn", isMyTurn);
        vm.put("message", message);
        vm.put("board", board);


        return new ModelAndView(vm, "./game.ftl");
    }

}
