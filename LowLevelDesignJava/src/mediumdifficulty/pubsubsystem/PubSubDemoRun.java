package mediumdifficulty.pubsubsystem;

public class PubSubDemoRun {

    public static void run(){

        //Creating an instance of the PubSubSystem class. This is the gateway to the implementation
        PubSubSystem pss = PubSubSystem.getInstance();

        //Creating publishers using createNewPublisher()
        Publisher pub1 = pss.createNewPublisher( "Grokking", "Amazon", "Sen ior Architect", "Sacramento", "CA" );

        Publisher pub2 = pss.createNewPublisher( "Ashish", "Microsoft", "Senior Engineer", "Lake Mary", "FL" );

        //Creating topics using createTopic()
        Topic topic1 = pss.createTopic( "System Design", "Detailed description of system design materials" );

        Topic topic2 = pss.createTopic( "Low Level Design", "The details on low level design" );

        Topic topic3 = pss.createTopic( "DSA", "A curated list of 300 problems on DSA" );

        Topic topic4 = pss.createTopic( "Projects", "Implementation of Simple Projects" );

        //Registering topics with publishers
        pss.registerTopicInPublisher( pub1, topic1 );

        pss.registerTopicInPublisher( pub1, topic2 );

        pss.registerTopicInPublisher( pub2, topic3 );

        pss.registerTopicInPublisher( pub2, topic4 );

        //Creating addresses
        Address addr = pss.createAddress(" Street 1", "Apartment 2", "City 3", "State", 31567 );

        //Creating subscribers in the application
        Subscriber sub1 = pss.createSubscriber( "person1 first name", "person1 last name", addr );

        Subscriber sub2 = pss.createSubscriber( "person2 first name", "person2 last name", addr );

        Subscriber sub3 = pss.createSubscriber( "person3 first name", "person3 last name", addr );

        Subscriber sub4 = pss.createSubscriber( "person4 first name", "person4 last name", addr );

        //The subscribers subscribe to a specific topic
        pss.subscribeTopic( sub1, topic1 );

        pss.subscribeTopic( sub1, topic2 );

        pss.subscribeTopic( sub1, topic3 );

        pss.subscribeTopic( sub1, topic4 );

        pss.subscribeTopic( sub2, topic1 );

        pss.subscribeTopic( sub2, topic3 );

        pss.subscribeTopic( sub2, topic4 );

        pss.subscribeTopic( sub3, topic2 );

        pss.subscribeTopic( sub3, topic3 );

        //Instantiating messages using the createMessage()
        Message msg1 = pss.createMessage( "Kafka", "A description on architecture of Apache Kafka" );

        Message msg2 = pss.createMessage( "Netflix Clone", "A reimplementation of Netflix" );

        Message msg3 = pss.createMessage( "DP Series", "A series on Dynamic Programming" );

        //Created messages are published into the relevant topics
        pss.createMessage( pub1, topic1, msg1 );

        pss.createMessage( pub2, topic3, msg3 );

        pss.createMessage( pub2, topic4, msg2 );

        //Subscribers subscribe to topic using subscribeTopic()
        pss.subscribeTopic( sub1, topic1 );

        pss.subscribeTopic( sub1, topic2 );

        pss.subscribeTopic( sub1, topic3 );

        Message msg4 = pss.createMessage( "Chat System Implementation", "A project on chat system" );

        pss.createMessage( pub2, topic4, msg4 );

        System.out.println("The PubSubDemoRun is completed successfully");

    }

}
