package webcheckers.model;

public class Player {


    private String playerName;
    private color playerColor;

    public status getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(status playerStatus) {
        this.playerStatus = playerStatus;
    }

    private status playerStatus;

    public enum color {
        RED, WHITE
    }
    public enum status {
        Playing, WatingForMatch
    }
    public Player(String playerName,color color){
        this.playerName = playerName;
        this.playerColor = color;
        this.playerStatus = status.WatingForMatch;
    }
    public String getPlayerName() {
        return playerName;
    }

    public color getPlayerColor() {
        return playerColor;
    }
}
