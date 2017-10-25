package com.webcheckers.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import webcheckers.model.Move;
import webcheckers.model.Position;

import static org.junit.Assert.*;

public class MoveTest {
    Position stratMove;
    Position  endMove;
    Move Cut;
    @Before
    public void setUp() throws Exception {

          stratMove = new Position(1,1);
          endMove = new Position(2,2);
          Cut = new Move(stratMove,endMove);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getStart() throws Exception {
        assertEquals(stratMove,Cut.getStart());
    }

    @Test
    public void getEnd() throws Exception {

        assertEquals(endMove,Cut.getEnd());

    }

  @Test
    public void move (){




      assertEquals("im testing strat move",stratMove,Cut.getStart());
      assertEquals("im testing end move",endMove,Cut.getEnd());

  }


}