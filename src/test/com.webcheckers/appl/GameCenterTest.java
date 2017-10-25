package webcheckers.appl;

import org.junit.Test;

public class GameCenterTest {
    @Test
    public void removePlayerGames() throws Exception {
        GameCenter cut=new GameCenter();
        String playerName="james bond";
        //cut.registerPlayer(playerName);
        assertTrue("playerName added",cut.registerPlayer(playerName) );
        //cut.removePlayer(playerName);
        assertTrue("playerName removed",cut.removePlayer(playerName) );
    }


}