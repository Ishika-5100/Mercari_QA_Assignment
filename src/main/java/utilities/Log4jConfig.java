package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jConfig {
    private static final Logger logger = LogManager.getLogger(Log4jConfig.class);

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message, Throwable t) {
        logger.error(message, t);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void trace(String message) {
        logger.trace(message);
    }
}
