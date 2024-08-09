package mediumdifficulty.pubsubsystem;

import java.util.ArrayList;
import java.util.List;

public class Subscriber {

    String firstName;
    String lastName;
    Address address;
    List<Topic> topicList;

    public Subscriber( String theFirstName, String theLastName, Address addr ){
        System.out.println("Creating a new subscriber");
        firstName = theFirstName;
        lastName = theLastName;
        address = addr;
        topicList = new ArrayList<>();
    }

}
