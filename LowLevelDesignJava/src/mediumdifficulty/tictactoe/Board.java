package mediumdifficulty.tictactoe;

import java.util.ArrayList;

public class Board {

    int dimensions;

    ArrayList<ArrayList<String>> boardValues;

    public Board( int n ){
        dimensions = n;
        boardValues = new  ArrayList<ArrayList<String>>();
        setDefaultBoardValues();
    }

    public void setDefaultBoardValues(){
        for( int i=0 ; i<dimensions ; i++ ){
            boardValues.add(new ArrayList<>());
            for( int j=0  ;j<dimensions ; j++ ){
                System.out.println("The index in setDefaultBoardValues() is " + i + " and " + j );
                boardValues.get(i).add(".");
            }
        }
    }

    public boolean isFull() {
        int count = 0;

        for( int i=0 ; i<dimensions ; i++ ){
            for( int j=0  ;j<dimensions ; j++ ){
                String existStr = boardValues.get(i).get(j);
                if( existStr != "." ){
                    count++;
                }
            }
        }

        System.out.println("The number of empty cells are " + count);

        return (count == ( dimensions * dimensions ));
    }

    public boolean isAnyWinner( Player p ) {
        String currPlayerChar = p.getPlayerMove();

        //This implementation check is done with 3 * 3 in mind. Will update a more complete check later
        if( ( boardValues.get(0).get(0) == currPlayerChar && boardValues.get(0).get(1) == currPlayerChar && boardValues.get(0).get(2) == currPlayerChar )
            ||
            ( boardValues.get(1).get(0) == currPlayerChar && boardValues.get(1).get(1) == currPlayerChar && boardValues.get(1).get(2) == currPlayerChar )
            ||
            ( boardValues.get(2).get(0) == currPlayerChar && boardValues.get(2).get(1) == currPlayerChar && boardValues.get(2).get(2) == currPlayerChar )
            ||
            ( boardValues.get(0).get(0) == currPlayerChar && boardValues.get(1).get(0) == currPlayerChar && boardValues.get(2).get(0) == currPlayerChar )
            ||
            ( boardValues.get(0).get(1) == currPlayerChar && boardValues.get(1).get(1) == currPlayerChar  && boardValues.get(2).get(1) == currPlayerChar )
            ||
            ( boardValues.get(0).get(2) == currPlayerChar && boardValues.get(1).get(2) == currPlayerChar  && boardValues.get(2).get(2) == currPlayerChar )
            ||
            ( boardValues.get(0).get(0) == currPlayerChar  && boardValues.get(1).get(1) == currPlayerChar && boardValues.get(2).get(2) == currPlayerChar )
            ||
            ( boardValues.get(0).get(2) == currPlayerChar && boardValues.get(1).get(1) == currPlayerChar && boardValues.get(2).get(0) == currPlayerChar )
        ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkValid( int x, int y ) {
        if( x > 2 || x < 0 ){
            System.out.println("The index x coordinate is out of range ");
            return false;
        } else if( y > 2 || y < 0 ){
            System.out.println("The index y coordinate is out of range ");
            return false;
        } else {
            String existStr = boardValues.get(x).get(y);
            if( existStr == "." ){
                System.out.println("The index is valid and empty. You can enter the user input");
            } else {
                System.out.println("The index already contains a string input. Please enter another value again!");
                return false;
            }
        }
        return true;
    }

    public void setCoords( int x, int y, Player p ) {
        String moveChar = p.getPlayerMove();
        boardValues.get( x ).set( y, moveChar );
    }

    public void printBoard(){
        for( int i=0 ; i<dimensions ; i++ ){
            for( int j=0  ;j<dimensions ; j++ ){
                String existStr = boardValues.get(i).get(j);

                System.out.print( existStr +" ");
            }
            System.out.println();
        }
    }
}
