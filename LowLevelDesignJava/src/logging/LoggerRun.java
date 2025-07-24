package logging;

public class LoggerRun {

    /*
        Level:
            DEBUG, INFO, WARNING, ERROR, FATAL

        Level Order Priority:
            DEBUG < INFO < WARNING < ERROR < FATAL

        Appender Type:
            Console, File, DB
    */

    public static void run(){
        //This is default configuration - Level: INFO, and Appender: Console
        Logger logger = Logger.getInstance();

        //The logger is printed at Debug level - priority level - 1
        logger.debug("The module is built for verification purposes");

        //The logger is printed at Info level - priority level - 2
        logger.info("This is a new implementation");

        //The logger is printed at Warning level - priority level - 3
        logger.warning("Please be careful with the method. It is scheduled to be deprecated in Oct 2025");

        //The logger is printed at Error level - priority level - 4
        logger.error("The code had a breakdown due to the parameters");

        //Creating a new logger config with logging level - Error, and file in the path specified below
        LoggerConfig config = new LoggerConfig( LoggerLevel.ERROR, new FileAppender(LoggerLevel.ERROR, "C:\\Users\\princ\\Documents\\Low Level Design\\VendingMachineFinal\\src\\logging\\Sample.txt") );

        //Setting the new config level for the logger
        logger.setConfig(config);

        //The logger is printed at Warning level - priority level - 3
        logger.warning("This is implementation could lead to uneven performances in very rare cases");

        //The logger is printed at Error level - priority level - 4
        logger.error("The error blocking the issue is : ERROR_DESCRIPTION");

        //The logger is printed at Fatal level - priority level - 5
        logger.fatal("The application flow has been blocked");
    }

}
