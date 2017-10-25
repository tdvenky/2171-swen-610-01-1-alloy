package com.webcheckers.ui;

import webcheckers.appl.GameCenter;
import org.junit.Test;
import spark.TemplateEngine;
import webcheckers.ui.WebServer;

import static org.mockito.Mockito.mock;

public class WebServerTest {
    @Test
    public void initialize() throws Exception {

         TemplateEngine templateEngine = mock(TemplateEngine.class);
         final GameCenter gameCenter = new GameCenter();
         WebServer cut = new WebServer( templateEngine,gameCenter);
        cut.initialize();


    }

}