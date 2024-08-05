package stackoverflow_own;

public class StackOverflowDemo {

    public static void run(){
        /*
        Beginning of test for Own Implementation
        * */

        //Create a new instance for stack overflow app
        StackOverflow stackOverflow = StackOverflow.getInstance();

        //Create User 1 - return user object
        User user1 = new User("Richard Parker", stackOverflow );

        //Create User 2 - return user object
        User user2 = new User("Benny Marriot", stackOverflow );

        //Create User 3 - return user object
        User user3 = new User("Rudra Pratap", stackOverflow );

        //Create User 4 - return user object
        User user4 = new User("Jeremy Nuggets", stackOverflow );

        //Using user1 create a question - return question object
        String questionText1 = "What is the difference between static and instance objects";
        Question question1 = stackOverflow.createQuestion( user1, questionText1);

        //Using user2 and question1 create an answer1 - return answer object
        String answerText1 = "In object-oriented programming, static and instance" +
                " refer to different types of members (variables and methods) within a class";
        Question questionFind1 = stackOverflow.findQuestion( question1.getQuestionId() );
        Answer answer1 = null;

        if( questionFind1 != null ) {
            answer1 = questionFind1.addAnswer(user2, answerText1);
        }

        //Using user3 and question1 create an answer2 - return answer object
        String answerText2 = "Also known as class variables, static variables are shared among all instances of a class." +
                " Methods that belong to the class rather than any instance.";
        Question questionFind2 = stackOverflow.findQuestion( question1.getQuestionId() );
        Answer answer2;

        if( questionFind2 != null ) {
            answer2 = questionFind2.addAnswer(user3, answerText2);
        }


        //Using user4 and question1 create a comment to question1
        String comment1 = "The same issue happened in my system!";
        Comment commentObj1 = null;

        if( questionFind1 != null ) {
            commentObj1 = questionFind1.addComment( user4, comment1 );
        }

        //Using user3 and answer1 create a comment to answer1
        String comment2 = "Thanks it resolved my issue.";
        Answer answerFind1 = stackOverflow.findAnswer( answer1.getAnswerId() );
        if( answerFind1 != null ){
            answerFind1.addComment( user4, comment2 );
        }


        //Should not be permissible - since same user is posting the question and upvoting the question
        user1.upvote(question1);

        //Upvoting the question1 - upvote count= +1
        user2.upvote(question1);

        //Upvoting the question1 - upvote count = +2
        user3.upvote(question1);

        //Downvoting the question1 - upvote count= +1
        user4.downvote(question1);

        //Upvoting the question1 - upvote count = +1
        user1.upvote(answer1);

        //Downvoting the question1 - upvote count= 0
        user3.downvote(answer1);

        //Downvoting the question1 - upvote count= -1
        user3.downvote(answer1);

        /*
            Ending of test for Own Implementation
        * */
    }



}
