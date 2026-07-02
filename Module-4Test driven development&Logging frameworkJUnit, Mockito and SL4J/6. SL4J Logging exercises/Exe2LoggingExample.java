import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exe2LoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {

        String username = "Rithika";
        int age = 21;

        logger.info("User {} is {} years old", username, age);

        logger.debug("Debugging user {}", username);
    }
}