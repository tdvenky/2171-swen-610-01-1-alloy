package webcheckers.ui;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import webcheckers.appl.GameCenter;
import webcheckers.model.Player;
import webcheckers.model.webcheckersGame;
import spark.*;



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

            if (gameCenter.makeMatchAndSetUpGame(new Player(playerOne, Player.color.RED),new Player(playerOppnot, Player.color.WHITE))){

                    game = gameCenter.getGameBy(playerOne+playerOppnot);
                    if(game == null){
                        game = gameCenter.getGameBy(playerOppnot+playerOne);

                    }
                System.out.println("game  "+game);

                vm.put("title", "welcome");
              //  vm.put("currentPlayerName", game.currentPlayerName);
       //         vm.put("currentPlayerName", game.getPlayerOne());

                if (game.getPlayerOne().getPlayerName().equalsIgnoreCase(playerOne)){
                    vm.put("playerName",  game.getPlayerOne().getPlayerName());
                    vm.put("playerColor", game.getPlayerOne().getPlayerColor());

                    vm.put("opponentName", game.getOpponetPlayer().getPlayerName());
                    vm.put("opponentColor", game.getOpponetPlayer().getPlayerColor());


                }else {

                    vm.put("playerName",  game.getOpponetPlayer().getPlayerName());
                    vm.put("playerColor", game.getOpponetPlayer().getPlayerColor());

                    vm.put("opponentName", game.getPlayerOne().getPlayerName());
                    vm.put("opponentColor", game.getPlayerOne().getPlayerColor());


                }

                if (game.currentPlayerName.equalsIgnoreCase(playerOne)){
                    vm.put("isMyTurn", true);

                }else {
                    vm.put("isMyTurn", false);

                }
                vm.put("message", game.getMessage());
                vm.put("board", game.getBoard());

              }
        }else {

        }


        return new ModelAndView(vm, "./game.ftl");
    }

}
