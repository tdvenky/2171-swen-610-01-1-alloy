package webcheckers.ui;

import webcheckers.appl.GameCenter;
import webcheckers.model.Move;
import webcheckers.model.message;
import webcheckers.model.webcheckersGame;
import spark.Request;
import spark.Response;
import spark.Route;

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
        game = gameCenter.getGame(request.session());
        final Move move = JsonUtils.fromJson(request.body(), Move.class);
        System.out.println("Player move: " + request.attribute("currentPlayer")+"---- mocve :  "+ move.toString());

        return new message("Other player has resigned, submit turn to end game.", message.Type.info);
    }
}
