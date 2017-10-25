package webcheckers.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setPlayerNameAndColor() throws Exception {

        Player playerUnderTest = new Player("testNmae", Player.color.RED);

        assertEquals("","testNmae",playerUnderTest.getPlayerName());
        assertEquals("", Player.color.RED,playerUnderTest.getPlayerColor());


    }

    @Test
    public void setPlayerStatus() throws Exception {
    }

    @Test
    public void getPlayerName() throws Exception {
    }

    @Test
    public void getPlayerColor() throws Exception {
    }

}