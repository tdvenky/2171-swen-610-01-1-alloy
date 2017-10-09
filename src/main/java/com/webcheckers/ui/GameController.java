package com.webcheckers.ui;

import com.webcheckers.model.Board;
import com.webcheckers.model.Player;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class GameController implements TemplateViewRoute {

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        Player player = new Player("khalid", Player.color.RED);
        Player opponetPlayer = new Player("abood", Player.color.White);
        Board board = new Board();
        Boolean isMyTurn = true;
        message message = new message("no ebd", com.webcheckers.ui.message.Type.info);
        vm.put("title","welcome");
        vm.put("currentPlayer",player);
        vm.put("playerName",player.getPlayerName());
        vm.put("playerColor",player.getPlayerColor());
        vm.put("opponentName",opponetPlayer.getPlayerName());
        vm.put("opponentColor",opponetPlayer.getPlayerColor());
        vm.put("isMyTurn",isMyTurn);
        vm.put("message", message);
        vm.put("board",board);


        return new ModelAndView(vm , "./game.ftl");
    }
}
