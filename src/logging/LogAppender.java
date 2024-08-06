package logging;

//A common interface to establish a contract for future appenders
public interface LogAppender {


    public void log( LoggerLevel level, Message message );

}
