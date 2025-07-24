package mediumdifficulty.tictactoe;

public class TicTacToeDemoRun {

    public static void run() {
        Player p1 = new Player( "Random Guy", "Chennai" );
        Player p2 = new Player( "Aaronstone", "Chennai" );

        Game game = Game.getInstance( p1, p2 );

        game.startGame();

    }
}
