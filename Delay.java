import java.util.concurrent.TimeUnit;

public class Delay {
    public static void sleep(int sleepDuration){
        // This delay function is used for sleeping the program to build a better user experience
        try {
            TimeUnit.SECONDS.sleep(sleepDuration);
        } catch (Exception e) {
            // Exception printed if the sleep fails for some reason we don't need it to halt program
            // as this function is non-critical and centered around user experience
            System.out.print("Wow, we are moving fast!");
        }
    }

}
