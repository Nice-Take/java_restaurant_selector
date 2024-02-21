import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        
        // Read in the config file of possible cuisines first because the program will not work without this
        ArrayList<String> cuisines = CuisineOptions.getCuisineList();

        // Create System.in scanner to pass to various functions that call for user input
        Scanner sc = new Scanner(System.in);

        // Welcome section where we inform the user what to expect from the program
        System.out.println("\n\nWelcome to the restaraunt qualifier program!\n");
        Delay.sleep(1);

        System.out.println("This program will help your group decide what type of restaraunt fits your party best.");
        Delay.sleep(1);
        System.out.println("Each person is allocated 10 decision points to use on the categories they care about most.");
        System.out.println(""); // This extra timed return is in place to help the program feel interactive
        Delay.sleep(1);
        
        System.out.print("To begin, please enter the size of your group: ");
        String originalPartySize = sc.nextLine();
        int partySize = Validate.checkInt(originalPartySize, sc);
        System.out.printf("\nGreat! You entered [%d] people.\n", partySize);
        
        // Create group to add people to
        Group group = new Group();

        // Create an arraylist of people to gather input from
        for(int i = 0; i < partySize; i++){
            // System.out.println(i);
            Person person = new Person(i);
            group.addPerson(person);
        }

        // Begin input looping over each person in the group
        for(Person i : group.party){
            // Prompt for beginning a new user's input entry
            System.out.printf("\nPERSON_%d, Please enter your cuisine preference:\n", i.getGroupIndex()+1);
            for(String option : cuisines){
                System.out.println("- " + option);
            }
            System.out.print("Cuisine Preference: ");

            // Cuisine selection section, reading in and validating option against the config.csv options
            String originalCuisineInput = sc.nextLine();
            String cuisineChoice = Validate.checkCuisine(originalCuisineInput, cuisines, sc);

            // Notify user of remaining points and ask for quantity to allocate
            System.out.printf("\nYou have %d decision points remaining, how many would you like to allocate?: ", i.getDecisionPts());
            String originalCuisineWt = sc.nextLine();
            int cuisineWt = Validate.checkInt(originalCuisineWt, sc);

            // Verify user has enough points then allocate the user's object decision points
            i.allocateDecisionPoints(cuisineWt, sc);

            // Update Person's object cuisine attributes
            i.setCuisine(cuisineChoice, cuisineWt);


            // Price selection section
            System.out.printf("\nPERSON_%d, Please enter your PRICE preference.\n", i.getGroupIndex()+1);
            System.out.print("Enter: $, $$ or $$$: "); 

            // Reading in and validating that user's input matched viable options
            String originalPriceInput = sc.nextLine();
            String priceChoice = Validate.checkPrice(originalPriceInput, sc);

            // Notify user of remaining points and ask for quantity to allocate
            System.out.printf("You have %d decision points remaining, how many would you like to allocate?: ", i.getDecisionPts());
            String originalPriceWt = sc.nextLine();
            int priceWt = Validate.checkInt(originalPriceWt, sc);

            // Verify user has enough points then allocate the user's object decision points
            i.allocateDecisionPoints(priceWt, sc);

            // Update Person's object cuisine attributes
            i.setCost(priceChoice, priceWt);

            
            // Proximity selection section
            System.out.printf("\nPERSON_%d, how many miles are you willing to travel?\n", i.getGroupIndex()+1);
            System.out.print("Enter: 1, 5, 10, or 20: "); 

            // Reading in and validating that user's input matched viable options
            String originalProximityInput = sc.nextLine();
            String proximityChoice = Validate.checkDistance(originalProximityInput, sc);

            // Notify user of remaining points and ask for quantity to allocate
            System.out.printf("You have %d decision points remaining, how many would you like to allocate?: ", i.getDecisionPts());
            String originalProximityWt = sc.nextLine();
            int proximityWt = Validate.checkInt(originalProximityWt, sc);

            // Verify user has enough points then allocate the user's object decision points
            i.allocateDecisionPoints(proximityWt, sc);

            // Update Person's object cuisine attributes
            i.setRange(proximityChoice, proximityWt);
        } 
        
        // We notify the user that their input process is done and we are calculating the result
        System.out.println("\nOne moment, your recommendation is being processed...");
        Delay.sleep(1);
        
        // Delays are incorporated to build excitement for the final result
        System.out.println("\n\n------- FINAL RESULT -------\n");
        Delay.sleep(1);

        // Calling the group calculate functions to total the winning categories
        String groupCuisine = group.getFinalCuisine();
        String groupPrice = group.getFinalPrice();
        String groupProximity = group.getFinalProximity();
        
        System.out.printf("Your group prefers %s cuisine\n", groupCuisine);
        System.out.printf("that is within %s miles,\n", groupProximity);
        System.out.printf("and priced in the %s range.\n", groupPrice);

        Delay.sleep(1);
        
        // Notifying the user that the program has finished and executed it's purpose
        System.out.println("\n--- Thank you and enjoy! ---\n");

        // For good measure we tidy up our scanner
        sc.close();
    }

}