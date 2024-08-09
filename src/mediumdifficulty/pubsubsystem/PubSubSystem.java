package mediumdifficulty.pubsubsystem;

import java.util.ArrayList;

public class PubSubSystem {

    static PubSubSystem pubSubSystem;
    ArrayList<Publisher> publishers;
    ArrayList<Subscriber> subscribers;
    ArrayList<Topic> topics;

    public PubSubSystem(){
        publishers = new ArrayList<>();
        subscribers = new ArrayList<>();
        topics = new ArrayList<>();
    }

    public synchronized static PubSubSystem getInstance(){
        System.out.println("Creating a new synchronized instance of PubSubSystem");
        if( pubSubSystem == null ){
            pubSubSystem = new PubSubSystem();
        }

        return pubSubSystem;
    }

    public Publisher createNewPublisher( String name, String orgName, String roleName, String city, String state ){
        System.out.println("Creating a new publisher using createNewPublisher()");
        LocDetail locDetail = new LocDetail( city, state );
        OffDetail    officeDetail = new OffDetail( orgName, roleName );

        Publisher pub1 = new Publisher( name, locDetail, officeDetail );

        publishers.add(pub1);

        return pub1;
    }

    public Topic createTopic( String topicName, String topicDescription ){
        System.out.println("Creating a new topic using createTopic()");

        Topic top1 = new Topic(topicName, topicDescription);

        topics.add(top1);

        return top1;
    }

    public void registerTopicInPublisher( Publisher pub1, Topic t1 ){
        System.out.println("Registering a topic with a publisher");
        pub1.registerTopic( t1 );
    }

    public Address createAddress( String theStreet1, String theStreet2, String city, String state, int postcode ){
        System.out.println("Creating a new address");
        return new Address( theStreet1, theStreet2, city, state, postcode );
    }

    public Subscriber createSubscriber( String firstName, String lastName, Address addr ){
        System.out.println("Creating a new subscriber");

        Subscriber sub1 = new Subscriber( firstName, lastName, addr );

        subscribers.add(sub1);

        return sub1;
    }

    public void subscribeTopic( Subscriber sub1, Topic t1 ){
        System.out.println("Subscribing to a topic");
        t1.addSubscriber( sub1 );
    }

    public Message createMessage( String title, String content ){
        System.out.println("Creating a new message");
        return new Message(title, content);
    }

    public void createMessage( Publisher pub1, Topic t1, Message m1 ){
        System.out.println("Publishing the message");
        pub1.getTopic( t1 ).addMessage( m1 );
    }

}
