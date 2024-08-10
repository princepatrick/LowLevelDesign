package mediumdifficulty.tictactoe;

public class Player {

    private String playerName;
    private String playerCity;

    private String playerMove;

    Player( String plName, String plCity ){
        playerName = plName;
        playerCity = plCity;
    }

    public String getPlayerMove() {
        return playerMove;
    }

    public void setPlayerMove(String playerMove) {
        this.playerMove = playerMove;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerCity() {
        return playerCity;
    }


}
