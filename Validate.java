import java.util.Scanner;
import java.util.ArrayList;

public class Validate {
    String inputString = "";

    // There isn't any validation necessary to return the string 
    public static String checkString(String inputString){
        return inputString;
    }


    // We check an input integer for being valid here and provide 
    // additional instructions if the user is unable to execute 
    // the task properly the first time. The loop will sustain until
    // the user enters a proper integer.
    public static int checkInt(String originalInput, Scanner sc){
        boolean validating = true;
        int validatedInt = 0;
        
        while(validating == true){
            try {
                validatedInt = Integer.parseInt(originalInput);
                validating = false;
                return validatedInt;
            } catch (Exception e) {
                // Catching anything but a valid int and requesting another attempt
                System.out.print("Please input a valid whole number: ");
                originalInput = sc.nextLine();
                validating = true;
        }
    }
    return validatedInt;
    }


    // Checking that the cuisine is one of the provided options and nothing else
    // If the cuisine entered is out of scope the user is provided additional instructions
    // and given another opportunity to enter valid input.
    public static String checkCuisine(String input, ArrayList<String> cuisineOptions, Scanner sc){
        String loweredInput = input.toLowerCase();
        ArrayList<String> validCuisine = new ArrayList<String>();
        String validatedInput = "";
        boolean validated = false;

        // Building list to check user input agains
        for(String cuisine : cuisineOptions){
            validCuisine.add(cuisine);
        }
                
        while(validated == false){
            // Checking a case-normalized user input against the list of valid cuisine
            for(String item : validCuisine){
                if(item.toLowerCase().equals(loweredInput)){
                    validatedInput = item;
                    validated = true;
                    return validatedInput;
                    } 
                }

            // Providing additional instructions and new input attempt if the previousl input was invalid
            if(validated != true){
                    System.out.println("Please enter a valid option from the list:");
                    for(String cuisineType : validCuisine){
                        System.out.println("- " + cuisineType);
                    }

                    String nextInput = sc.next();

                    loweredInput = nextInput.toLowerCase();
               }
        }
        return validatedInput;
}


    // Validating that the user input matches one of the three possible items.
    // If the input does not match the user is given another opportunity 
    // with additional instructions.
    public static String checkPrice(String input, Scanner sc){
        String[] priceRange= {"$", "$$", "$$$"};
        String validatedInput = "";
        boolean validated = false;
        
        while(validated == false){
            // Checking a case-normalized user input against the list of valid cuisine
            for(String item : priceRange){
                if(item.equals(input)){
                    validatedInput = item;
                    validated = true;
                    return validatedInput;
                    } 
                }

            // Providing additional instructions and new input attempt if the previousl input was invalid
            if(validated != true){
                    System.out.println("Please enter a valid option from the list.");
                    for(String price : priceRange){
                        System.out.print("|" + price + "|");
                    }
                    System.out.print(": ");

                    String nextInput = sc.next();
                    input = nextInput.toLowerCase();
               }
        }
        return validatedInput;
}


    // Validating that the distance the user has entered is one of the four options 
    // provided. If it is not, the user is provided another opportunity to enter
    // a distance with additional guidance.
    public static String checkDistance(String input, Scanner sc){
        String[] distOptions = {"1", "5", "10", "20"};
        String validatedInput = "";
        boolean validated = false;
        
        while(validated == false){
            // Checking a case-normalized user input against the list of valid cuisine
            for(String item : distOptions){
                if(item.equals(input)){
                    validatedInput = item;
                    validated = true;
                    return validatedInput;
                    } 
                }

            // Providing additional instructions and new input attempt if the previousl input was invalid
            if(validated != true){
                    System.out.println("Please enter a valid option from the list.");
                    for(String distance : distOptions){
                        System.out.print("|" + distance + "|");
                    }
                    System.out.print(": ");

                    String nextInput = sc.next();
                    input = nextInput.toLowerCase();
               }
        }
        return validatedInput;
}

}
