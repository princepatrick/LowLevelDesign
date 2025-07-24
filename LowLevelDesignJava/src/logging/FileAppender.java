package logging;

import java.io.FileWriter;

//An appender implementation to print the logs into a new File
public class FileAppender implements LogAppender {

    LoggerLevel logLevel;
    FileWriter writer;

    //A constructor to create a new FileWriter to create new files as per the "path"
    public FileAppender( LoggerLevel level, String path ){
        System.out.println("The file path in FileAppender() is " + path );
        logLevel = level;
        try{
            writer = new FileWriter(path, true);
        } catch (Exception e){
            System.out.println("There is a possibility of getting the exception in FileAppender() is" + e );
        }
    }

    //The actual implementation to print the log with the Appender
    @Override
    public void log(LoggerLevel messageLevel, Message message) {
        if( logLevel.ordinal() <= messageLevel.ordinal() ){
            try{
                System.out.println("In FileAppender()  the content is " + message.getContent()
                        + " and the timestamp of message " + message.getTimestamp());
                writer.write("the content of the message is " + message.getContent()
                        + " and the timestamp of message " + message.getTimestamp() + "\n");
            } catch (Exception e){
                System.out.println( "The exception that occurred in FileAppender() is " + e );
            }
        } else {
            System.out.println("In FileAppender(), Since the logged message is not of the priority of the logger level, we are not printing the log statements");
        }

    }
}
