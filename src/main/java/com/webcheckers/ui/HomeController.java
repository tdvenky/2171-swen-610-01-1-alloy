package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;

import com.webcheckers.appl.GameCenter;
import spark.*;

import java.util.Objects;
import java.util.logging.Logger;

import static spark.Spark.halt;

/**
 * The Web Controller for the Home page.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
public class HomeController implements TemplateViewRoute {
  private final GameCenter gameCenter;


  HomeController(final GameCenter gameCenter) {
    // validation
    Objects.requireNonNull(gameCenter, "gameCenter must not be null");
    //
    this.gameCenter = gameCenter;
  }

  @Override
  public ModelAndView handle(Request request, Response response) {

    // retrieve the HTTP session
//    final Session httpSession = request.session();


    // start building the View-Model
    final Map<String, Object> vm = new HashMap<>();
    if (gameCenter.loginPlayers.size()>0){
      vm.put("loginPlayers",gameCenter.loginPlayers );

    }

    vm.put("title", "Welcome!");


//    // if this is a brand new browser session
//    if (httpSession.isNew()) {
//      // render the Game Form viewc
//      // report application-wide game statistics
//
//      System.out.println(gameCenter.userGame.values());
//
//      //LOG.fine("New Session/User created: ");
//
//      //vm.put(NEW_SESSION_ATTR, true);
//    }
//    else {
//      // there is a game already being played
//      // so redirect the user to the Game view
//
//      response.redirect(WebServer.GAME_URL);
//      halt();
//      return null;
//    }
    return new ModelAndView(vm, "home.ftl");

  }

}