package com.webcheckers.model;

        import com.webcheckers.model.Move;
        import com.webcheckers.model.Position;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;

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
    @Test
    public void getMoveMagnitude() throws Exception {
        stratMove = new Position(2,3);
        endMove = new Position(3,4);
        Cut = new Move(stratMove,endMove);
        assertEquals(Cut.getMoveMagnitude(),1);

        stratMove = new Position(4,3);
        endMove = new Position(2,5);
        Cut = new Move(stratMove,endMove);
        assertEquals(Cut.getMoveMagnitude(),2);
    }





}