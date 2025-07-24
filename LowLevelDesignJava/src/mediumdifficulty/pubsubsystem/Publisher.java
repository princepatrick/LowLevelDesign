package mediumdifficulty.pubsubsystem;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    String publisherName;
    LocDetail locationDetail;
    OffDetail officeDetail;
    List<Topic> topicList;

    public Publisher( String thePublisherName, LocDetail theLocationDetail, OffDetail theOfficeDetail ){
        System.out.println("Creating a new publisher using constructor");
        publisherName = thePublisherName;
        locationDetail = theLocationDetail;
        officeDetail = theOfficeDetail;
        topicList = new ArrayList<Topic>();
    }

    public void registerTopic( Topic t1 ){
        System.out.println("Registering the topic");
        topicList.add(t1);
    }

    public Topic getTopic( Topic t ){
        System.out.println("Retrieving the topic using getTopic()");
        for( Topic t1 : topicList ){
            if( t1 == t ){
                System.out.println("Topic found");
                return t1;
            }
        }

        return null;
    }

}
