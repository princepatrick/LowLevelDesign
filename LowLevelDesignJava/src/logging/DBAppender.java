package logging;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

//An appender implementation to print the logs into a new table in the DB
public class DBAppender implements LogAppender {

    String jdbcUrl;
    String userName;
    String password;
    LoggerLevel logLevel;

    DBAppender(){
        jdbcUrl = "";
        userName = "";
        password = "";
    }

    //The implementation of the log() to print inside the table logs in the db
    @Override
    public void log(LoggerLevel messageLevel, Message message) {
        if( logLevel.ordinal() <= messageLevel.ordinal() ){
            try(
                    Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO logs (level, message, timestamp) VALUES (?, ?, ?)")
                ){
                System.out.println("The message to be printed in DBAppender() is " + message );
                statement.setString(1, messageLevel.toString());
                statement.setString(2, message.getContent());
                statement.setLong(3, message.getTimestamp());
                statement.executeUpdate();

            } catch (Exception e){
                System.out.println( "The exception that occurred is " + e );
            }
        } else {
            System.out.println("Since the logged message is not of the priority of the logger level, we are not printing the log statements");
        }
    }
}
