package stackoverflow_own;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private User questionOwner;
    private String questionText;
    private int questionId;
    private int upvoteCount;
    private int questionIdMark = 2000;
    //ArrayList for Answers
    List<Answer> answerList;

    //ArrayList of comments
    List<Comment> commentList;


    public Question( User user, String theQuestionText ){
        System.out.println( "Forming the question for the user " + user + " and the question is " + theQuestionText );

        questionOwner = user;
        questionText = theQuestionText;
        upvoteCount = 0;
        questionId = questionIdMark;
        questionIdMark++;
        answerList = new ArrayList<>();
        commentList = new ArrayList<>();

    }

    public User getQuestionOwner(){
        return questionOwner;
    }

    public void editQuestion( String newText ){
        System.out.println("The question text is updated to " + newText );
        questionText = newText;
    }

    public int getQuestionId(){
        return questionId;
    }

    public String getQuestionText(){
        System.out.println("Returns the question text");
        return questionText;
    }

    public Answer addAnswer( User user, String answerText ){
        System.out.println("Creating a new answer: " + answerText +" for the user "
                + user.getUserId() + " and the question " + this.getQuestionId() );
        Answer answer = new Answer( user, this, answerText );
        answerList.add(answer);
        return answer;
    }

    public Comment addComment( User user, String commentText ){
        System.out.println("Creating a new comment in a question "
                + commentText +" for the user " + user.getUserId()
                + " and the question " + this.getQuestionId() );
        Comment comment = new Comment(user, commentText, this );
        commentList.add(comment);
        return comment;
    }

    public List<Answer> getAnswerList(){
        System.out.println("Return the answer list");
        return answerList;
    }

    public void addUpvote(){
        System.out.println("Adding the upvote for the question");
        upvoteCount++;
        System.out.println("The new upvote count is " + upvoteCount);
    }

    public void addDownvote(){
        System.out.println("Adding the downvote for the question");
        upvoteCount--;
        System.out.println("The new upvote count is " + upvoteCount);
    }

}
