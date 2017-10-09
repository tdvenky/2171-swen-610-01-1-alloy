package com.webcheckers.ui;

<<<<<<< HEAD
<<<<<<< HEAD
import com.webcheckers.model.Board;
import com.webcheckers.model.Player;
=======
>>>>>>> 753f41fbf011a04aebbf196a4989f2fed3195a88
=======
>>>>>>> 753f41fbf011a04aebbf196a4989f2fed3195a88
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class GameController implements TemplateViewRoute {
<<<<<<< HEAD
<<<<<<< HEAD

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
=======
=======
>>>>>>> 753f41fbf011a04aebbf196a4989f2fed3195a88
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
//        vm.put("title", "Welcome!");
//        vm.put("playerName", "Welcome!");
//        vm.put("playerColor", "Welcome!");
//        vm.put("isMyTurn", true);
//        vm.put("opponentName", "Welcome!");
//        vm.put("opponentColor", "Welcome!");
//        vm.put("message", "Welcome!");
//        vm.put("board", "Welcome!");
//        vm.put("currentPlayer", "Welcome!");
        return new ModelAndView(vm , "game.ftl");
<<<<<<< HEAD
>>>>>>> 753f41fbf011a04aebbf196a4989f2fed3195a88
=======
>>>>>>> 753f41fbf011a04aebbf196a4989f2fed3195a88
    }
}
