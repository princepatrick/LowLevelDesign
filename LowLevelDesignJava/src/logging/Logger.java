package logging;

public class Logger {

    //The variables: a static object logger that operates the entire flow and config to
    // store the current configuration (Logging level, and Logging appender) of the log
    public static Logger logger;
    private LoggerConfig config;

    //The constructor to define the logger config
    public Logger(){
        config = new LoggerConfig( LoggerLevel.INFO, new ConsoleAppender(LoggerLevel.INFO) );
    }

    //The getInstance() returns the Logger object
    public static Logger getInstance(){
        if( logger == null ){
            logger = new Logger();
        }
        
        return logger;
    }

    //The central method that generates the log based on the level used
    public void log(LoggerLevel level, String message){
        Message message1 = new Message( level, message );
        logger.getAppender(logger.getConfig()).log(level, message1);
    }

    //The method is used to generate logs of method INFO
    public void info(String message){
        logger.log(LoggerLevel.INFO, message);
    }

    //The method is used to generate logs of method DEBUG
    public void debug(String message){
        logger.log(LoggerLevel.DEBUG, message);
    }

    //The method is used to generate logs of method WARNING
    public void warning(String message){
        logger.log(LoggerLevel.WARNING, message);
    }

    //The method is used to generate logs of method ERROR
    public void error(String message){
        logger.log(LoggerLevel.ERROR, message);
    }

    //The method is used to generate logs of method FATAL
    public void fatal(String message){
        logger.log(LoggerLevel.FATAL, message);
    }

    //The method is used to retrieve the current logging config
    public LoggerConfig getConfig(){
        return config;
    }

    //The method is used to get the LoggerAppender object
    public LogAppender getAppender( LoggerConfig logConfig ){
        return logConfig.getAppender();
    }

    //The method is used to set the logger configuration
    public void setConfig( LoggerConfig theConfig ){
        config = theConfig;
    }
    
    
}
