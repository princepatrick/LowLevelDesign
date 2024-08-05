package stackoverflow_own;

public class Comment {

    private String commentText;
    private Question commentParentQuestion;
    private Answer commentParentAnswer;
    private int commentIndex = 5000;
    private int commentId;
    private User commentOwner;

    public Comment( User user, String commentText, Question commentQuestion ){
        System.out.println("Creating a new comment " + commentText +" for the user " + user.getUserId() );
        commentId = commentIndex;
        commentIndex++;
        commentParentQuestion = commentQuestion;
        commentOwner = user;
    }

    public Comment( User user, String commentText, Answer commentAnswer ){
        System.out.println("Creating a new comment " + commentText +" for the user " + user.getUserId() );
        commentId = commentIndex;
        commentIndex++;
        commentParentAnswer = commentAnswer;
        commentOwner = user;
    }

}
