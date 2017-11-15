package com.webcheckers.ui;

import com.webcheckers.appl.GameCenter;
import org.junit.Test;
import spark.TemplateEngine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class WebServerTest {
    @Test
    public void initialize() throws Exception {

        TemplateEngine templateEngine = mock(TemplateEngine.class);
        final GameCenter gameCenter = new GameCenter();
        WebServer cut = new WebServer( templateEngine,gameCenter);
        cut.initialize();
        assertNotNull(cut.getGameCenter());
        assertNotNull(cut.getTemplateEngine());



    }

}