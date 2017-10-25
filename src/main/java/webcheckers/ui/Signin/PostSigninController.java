package webcheckers.ui.Signin;

import webcheckers.appl.GameCenter;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static spark.Spark.halt;

public class PostSigninController implements  TemplateViewRoute {
    private final GameCenter gameCenter;
    final static String PLAYER_ATTR = "PlayerName";
    final static String NO_EXIST_ATTR = "noExistUser";

    public PostSigninController(final GameCenter gameCenter) {
        // validation
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");
        //
        this.gameCenter = gameCenter;
    }

    @Override
    public  ModelAndView handle(Request request, Response response) {
        final Map<String, Object> vm = new HashMap<>();
        final String playerNameStr = request.queryParams(PLAYER_ATTR);
        vm.put("title", "Sign In");

        if (!playerNameStr.isEmpty() || playerNameStr!=null) {
            if (gameCenter.isUserTaken(playerNameStr)) {
                gameCenter.PlayerNameAsSession(playerNameStr, request.session());

                response.redirect("/");
                halt();
                return null;
            } else {
                vm.put(NO_EXIST_ATTR, "No user add try again");

            }
        }

        return new ModelAndView(vm,"signin.ftl");
    }

}
