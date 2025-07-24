package logging;

import java.sql.Time;

public class Message {

    //The message with logging level, content and timestamp
    LoggerLevel logLevel;
    String content;
    Long timestamp;

    //The message constructor to define the logging level, content and timestamp
    Message( LoggerLevel messaggeLevel, String theContent ){
        logLevel = messaggeLevel;
        content = theContent;
        timestamp = System.currentTimeMillis();
    }

    //The method retrieves the content
    public String getContent(){
        return content;
    }

    //The method retrieves the timestamp
    public Long getTimestamp(){
        return timestamp;
    }

}
