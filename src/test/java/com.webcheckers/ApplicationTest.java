package com.webcheckers;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.ui.WebServer;
import org.junit.Before;
import org.junit.Test;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

import static org.junit.Assert.*;

public class ApplicationTest {
    Application app;
    WebServer webServer;
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void main() throws Exception {
        final TemplateEngine templateEngine = new FreeMarkerEngine();
        final GameCenter gameCenter = new GameCenter();

        // inject the game center and freemarker engine into web server

        // create the one and only game center

        webServer = new WebServer(templateEngine, gameCenter);


        app = new Application(webServer);
    }

}