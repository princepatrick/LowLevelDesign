package logging;

public class LoggerConfig {
    //Stores the Logger Level, and Logging Appender class
    private LoggerLevel level;
    private LogAppender appender;

    //The default constructor for setting the loggers
    public LoggerConfig( LoggerLevel theLevel, LogAppender theAppender ){
        level = theLevel;
        appender = theAppender;
    }

    //Retrieves the logAppender set in the Logger Config
    public LogAppender getAppender(){
        return appender;
    }

    //Retrieves the logging level set in the Logger Config
    public LoggerLevel getLevel(){
        return level;
    }
}
