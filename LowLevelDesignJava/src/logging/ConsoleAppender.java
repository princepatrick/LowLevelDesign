package logging;

//An appender implementation to print the logs into Consoles
public class ConsoleAppender implements LogAppender {

    //The logging level set at the config
    LoggerLevel logLevel;

    public ConsoleAppender( LoggerLevel level ){
        logLevel = level;
    }

    //The implementation of the log() to print at the console
    @Override
    public void log(LoggerLevel messageLevel, Message message) {
        if( logLevel.ordinal() <= messageLevel.ordinal() ){
            System.out.println(" The logged level is " + messageLevel
                    + " and the message content is " + message.getContent()
                    + " and the timestamp of message " + message.getTimestamp() );
        } else {
            System.out.println("Since the logged message is not of the priority of the logger level, we are not printing the log statements");
        }

    }

}
