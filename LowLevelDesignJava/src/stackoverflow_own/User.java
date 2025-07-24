package stackoverflow_own;

public class User {

    private String name;
    private int userId;
    private int rollingUserIdNum = 1000;
    private int repuatationScore;
    private StackOverflow stackOverflow;

    public User( String userName, StackOverflow stackOverflowObj ){
        System.out.println( "Creating a new user with the name " + userName );
        name = userName;
        userId = rollingUserIdNum;
        rollingUserIdNum++;
        repuatationScore = 0;
        stackOverflow = stackOverflowObj;
    }

    public void upvote( Question question ){
        System.out.println( "Upvoting the question " + question.getQuestionId() );
        question.addUpvote();
    }

    public void downvote( Question question ){
        System.out.println( "Downvoting the question " + question.getQuestionId() );
        question.addDownvote();
    }

    public void upvote( Answer answer ){
        System.out.println( "Upvoting the answer " + answer.getAnswerId() );
        answer.addUpvote();
    }

    public void downvote( Answer answer ){
        System.out.println( "Downvoting the answer " + answer.getAnswerId() );
        answer.addDownvote();
    }

    public int getUserId() {
        return userId;
    }
}
