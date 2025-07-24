package mediumdifficulty.pubsubsystem;

public class Message {

    String messageTitle;
    String messageContent;

    public Message( String msgTitle, String msgContent ){
        System.out.println("Creating the Location Details");
        messageTitle = msgTitle;
        messageContent = msgContent;
    }
}
