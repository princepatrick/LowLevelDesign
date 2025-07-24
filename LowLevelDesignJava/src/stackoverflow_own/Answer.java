package stackoverflow_own;

import java.util.ArrayList;
import java.util.List;

public class Answer {

    private User answerOwner;
    private Question relevantQuestion;
    private String answerText;
    private int upvoteCount;
    private int answerId;
    private int answerIdVal = 3000;
    //ArrayList of comments
    List<Comment> commentList;

    public Answer( User user, Question question, String theAnswerText ){
        answerOwner = user;
        relevantQuestion = question;
        answerText = theAnswerText;
        upvoteCount = 0;
        answerId = answerIdVal;
        answerIdVal++;
        commentList = new ArrayList<>();
    }

    public int getAnswerId() {
        return answerId;
    }

    public String getAnswerText(){
        return answerText;
    }

    public void updateAnswer( String newText ){
        answerText = newText;
    }

    public User getAnswerOwner(){
        return answerOwner;
    }

    public Question getQuestion(){
        return relevantQuestion;
    }

    public void addComment( User user, String comment ){
        System.out.println("Creating a new comment in an answer " + comment +" for the user " + user.getUserId() );

        Comment commentObj = new Comment(user, comment, this );

        commentList.add(commentObj);
    }

    public void addUpvote(){
        System.out.println("Adding the upvote for the answer");
        upvoteCount++;
        System.out.println("The new upvote count is " + upvoteCount);
    }

    public void addDownvote(){
        System.out.println("Adding the downvote for the answer");
        upvoteCount--;
        System.out.println("The new upvote count is " + upvoteCount);
    }
}
