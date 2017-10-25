package com.webcheckers.model;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class messageTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void move (){
        String messsageTitle = "This our testing step";

        message cut = new message(messsageTitle, message.Type.info);

        assertEquals("testing ",messsageTitle,cut.getText());
        assertEquals("testing ",message.Type.info,cut.getType());

    }
}