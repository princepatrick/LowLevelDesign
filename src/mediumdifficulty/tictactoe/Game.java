package mediumdifficulty.tictactoe;

import java.util.Scanner;

public class Game {

    private final Player p1;
    private final Player p2;
    private final Board board;
    private static Game game;

    public Game( Player theP1, Player theP2 ){
        p1 = theP1;
        p2 = theP2;
        board = new Board( 3 );
    }

    public static Game getInstance( Player theP1, Player theP2 ){
        if( game == null ){
            game = new Game( theP1, theP2 );
        }

        return game;
    }

    public void startGame(){

        int randInd = ((int) Math.ceil(Math.random() * 10) ) % 2 ;

        Player lastPlayedPlayer;

        if( randInd == 1 ){
            System.out.println("Player 1 won the toss");
            p1.setPlayerMove("X");
            p2.setPlayerMove("O");
            lastPlayedPlayer = p2;
        } else {
            System.out.println("Player 1 won the toss");
            p2.setPlayerMove("X");
            p1.setPlayerMove("O");
            lastPlayedPlayer = p1;
        }

        Player winner = null;

        board.printBoard();

        while( !board.isFull() ){
            Player currentPlayer = (lastPlayedPlayer == p1) ? p2 : p1;

            int xCoord, yCoord;

            System.out.println("The player " + currentPlayer.getPlayerName() + " is to play the move!!"
                    + " Your character move is " + currentPlayer.getPlayerMove() );

            System.out.println("Choose x coordinates from [ 0 - 2 ] ");
            Scanner scanner = new Scanner(System.in);
            xCoord = scanner.nextInt();

            System.out.println("Choose y coordinates from [ 0 - 2 ] ");
            yCoord = scanner.nextInt();

            if( board.checkValid( xCoord, yCoord ) ){
                System.out.println("The coordinates of X: " + xCoord + " and Y: " + yCoord + " are being set.");
                board.setCoords( xCoord, yCoord, currentPlayer );
            } else {
                continue;
            }

            if( board.isAnyWinner(currentPlayer) ){
                System.out.println("The player " + currentPlayer.getPlayerName()
                        + " from the city " + currentPlayer.getPlayerCity() + " won the tournament. ");
                winner = currentPlayer;
                break;
            }

            System.out.println("The board after the move is");
            board.printBoard();

            lastPlayedPlayer = currentPlayer;
        }

        if( winner == null ){
            System.out.println("No player was able to win. Thanks for playing");
        }


    }
}
