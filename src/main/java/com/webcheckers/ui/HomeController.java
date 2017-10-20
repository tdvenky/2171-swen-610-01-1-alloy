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
  final Session httpSession = request.session();

    // start building the View-Model
    final Map<String, Object> vm = new HashMap<>();
    if (gameCenter.playersList.size()>0){
      vm.put("playersList",gameCenter.playersList );

    }

    if(httpSession.isNew()){
      response.redirect("/signin");
      halt();
      return null;
    }


    if(gameCenter.playerbusyPlaying(httpSession.attribute("playerName")))
    {
      String OpponetPlayer = gameCenter.getOpponetplayerFromPairedList(httpSession.attribute("playerName"));
        response.redirect("/game?OpponetPlayer="+OpponetPlayer);
        halt();
        return null;

    }

    vm.put("title", "Welcome!");
    vm.put("playerName",httpSession.attribute("playerName"));
    vm.put("playersList",gameCenter.playersList);
    System.out.println("playerName"+httpSession.attribute("playerName"));


    return new ModelAndView(vm, "home.ftl");

  }

}