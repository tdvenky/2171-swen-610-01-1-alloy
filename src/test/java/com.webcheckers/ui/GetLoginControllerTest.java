package com.webcheckers.ui;

import org.junit.Before;
import org.junit.Test;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetLoginControllerTest {
    Request request;
    Session session;
    Response response;
    GetLoginController cut;
    @Before
    public void setUp() throws Exception {

        request = mock(Request.class);
        session = mock(Session.class);
        when(request.session()).thenReturn(session);
        response = mock(Response.class);
        cut = new GetLoginController();

    }

    @Test
    public void preventUserFromLogin(){





        final ModelAndView result = cut.handle(request, response);
        assertNotNull(result);
        final Object model = result.getModel();
        assertNotNull(model);
        assertTrue(model instanceof Map);
        final Map<String, Object> vm = (Map<String, Object>) model;
        assertEquals("signin.ftl", result.getViewName());
        assertEquals("Sign In", vm.get("title"));
    }


}