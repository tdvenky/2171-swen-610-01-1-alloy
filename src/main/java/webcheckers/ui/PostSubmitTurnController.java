package webcheckers.ui;

import webcheckers.appl.GameCenter;
import webcheckers.model.webcheckersGame;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;

public class PostSubmitTurnController implements  Route {

    private final GameCenter gameCenter;

    static final String PLAYER = "player";

    private webcheckersGame game;

    PostSubmitTurnController(final GameCenter gameCenter) {
        //Validate that GameCenter is not null
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");
        this.gameCenter = gameCenter;
    }


    @Override
    public Object handle(Request request, Response response) {
        System.out.println("handle");

        game = gameCenter.getGameBy("khalidVENKY");
        if(game == null){
            game = gameCenter.getGameBy("VENKYkhalid");

        }
        game.switchTurn();
        response.redirect("/game");


        return null;
    }
}
