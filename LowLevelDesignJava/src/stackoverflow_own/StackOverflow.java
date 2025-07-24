package stackoverflow_own;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackOverflow {

    static StackOverflow stackOverflow;

    List<Question> questionList;

    public StackOverflow(){
        questionList = new ArrayList<>();
    }

    public static StackOverflow getInstance(){
        System.out.println("Creating a new static instance of StackOverflow");

        if( stackOverflow == null ){
            stackOverflow = new StackOverflow();
        }

        return stackOverflow;
    }

    public Question findQuestion( int questionId ){

        System.out.println("In findQuestion(): The question is attempted to be searched");
        if( !questionList.isEmpty()  ){
            for( Question question : questionList ){
                if( question.getQuestionId() == questionId ){
                    System.out.println("In findQuestion(): The question is found");
                    return question;
                }
            }

            System.out.println("In findQuestion(): The question is not found");

        } else {
            System.out.println("There are no questions available");
        }

        return null;
    }

    public Answer findAnswer( int answerId ){

        System.out.println("In findAnswer(): Going to search for answer");

        for( Question question : questionList ){
            for( Answer answer : question.getAnswerList() ){
                if( answer.getAnswerId() == answerId ){
                    System.out.println("In findAnswer(): found the answer");
                    return answer;
                }
            }
        }

        System.out.println("In findAnswer(): not able to find the answer");
        return null;
    }

    public Question createQuestion( User user, String questionText ){
        Question question = new Question(user, questionText);
        System.out.println("Adding the question into the list");
        questionList.add(question);
        return question;
    }
}
