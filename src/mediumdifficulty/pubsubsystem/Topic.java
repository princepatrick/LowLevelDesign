package mediumdifficulty.pubsubsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class Topic {

    String topicName;
    String topicDescription;
    List<Subscriber> subscriberList;
    List<Message> messages;

    public Topic( String theTopic, String theDescription ){
        System.out.println("Constructor for the Topic Class");
        topicName = theTopic;
        topicDescription = theDescription;
        subscriberList = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public void addSubscriber( Subscriber sub ){
        System.out.println("Adding a new subscriber");
        subscriberList.add(sub);
    }

    public void addMessage( Message m ){
        System.out.println("Adding a new message in the topic");
        messages.add(m);
    }
}
