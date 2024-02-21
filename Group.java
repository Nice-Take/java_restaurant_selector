import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Group {
    // Inst the ArrayList to add Person objects to
    ArrayList<Person> party = new ArrayList<>();

    // Function we call in a loop to add the correct members of the party
    void addPerson(Person person){
        this.party.add(person);
    }
    
    // Used for debugging purposes
    void printAll(){
        for(Person person : party){
            // Here we can run through each Person object in the ArrayList
            System.out.println(person.getGroupIndex());
        }
    }

    // Called to calculate the winning cuisine choice
    String getFinalCuisine(){
        int chinese = 0;
        int french = 0;
        int greek = 0;
        int indian = 0;
        int italian = 0;
        int japanese = 0;
        int mexican = 0;
        int thai = 0;

        for(Person person : this.party){
            // Matching categories to get category totals by adding 
            // allocated points from each person
            switch (person.getCuisine()) {
                case "Chinese":
                    chinese += person.getCuisineWt();
                    break;

                case "French":
                    french += person.getCuisineWt();
                    break;
                
                case "Greek":
                    greek += person.getCuisineWt();
                    break;

                case "Indian":
                    indian += person.getCuisineWt();
                    break;

                case "Italian":
                    italian += person.getCuisineWt();
                    break;

                case "Japanese":
                    japanese += person.getCuisineWt();
                    break;

                case "Mexican":
                    mexican += person.getCuisineWt();
                    break;

                case "Thai":
                    thai += person.getCuisineWt();
                    break;
            }
        }
        
        // Packing to Map in order to iterate over the key and value
        Map<String, Integer> cuisineMap = new HashMap<String, Integer>();
        cuisineMap.put("Chinese", chinese);
        cuisineMap.put("French", french);
        cuisineMap.put("Greek", greek);
        cuisineMap.put("Indian", indian);
        cuisineMap.put("Italian", italian);
        cuisineMap.put("Japanese", japanese);
        cuisineMap.put("Mexican", mexican);
        cuisineMap.put("Thai", thai);
        
        // Variables where we keep track of winning key and value
        int highScore = 0;
        String highCuisine = "";

        for(Map.Entry<String, Integer> score : cuisineMap.entrySet()){
            if(score.getValue() >= highScore){
                highScore = score.getValue();
                highCuisine = score.getKey();
                }
            }

        return highCuisine;
    }


    String getFinalPrice(){
        int inexpensive = 0;
        int average = 0;
        int expensive = 0;
        
        // Matching price preferences and totaling score
        for(Person person : this.party){
            switch (person.getCost()) {
                case "$":
                    inexpensive += person.getCostWt();
                    break;

                case "$$":
                    average += person.getCostWt();
                    break;
                
                case "$$$":
                    expensive += person.getCostWt();
                    break;
            }
        }
        
        // Packing to map for iteration
        Map<String, Integer> priceMap = new HashMap<String, Integer>();
        priceMap.put("$", inexpensive);
        priceMap.put("$$", average);
        priceMap.put("$$$", expensive);
       
        // Variables to store winning values
        int highScore = 0;
        String costPreference = "";

        for(Map.Entry<String, Integer> score : priceMap.entrySet()){
            if(score.getValue() >= highScore){
                highScore = score.getValue();
                costPreference = score.getKey();
            }
        }
        return costPreference;
    }



    String getFinalProximity(){
        int one = 0;
        int five = 0;
        int ten = 0;
        int twenty = 0;
        
        for(Person person : this.party){
            // Matching distance preference and totaling score
            switch (person.getWithinRange()) {
                case "1":
                    one += person.getCostWt();
                    break;

                case "5":
                    five += person.getCostWt();
                    break;
                
                case "10":
                    ten += person.getCostWt();
                    break;
                
                case "20":
                    twenty += person.getWithinRangePref();
                    break;
            }
        }
        
        // Packing to Map for iteration
        Map<String, Integer> priceMap = new HashMap<String, Integer>();
        priceMap.put("1", one);
        priceMap.put("5", five);
        priceMap.put("10", ten);
        priceMap.put("20", twenty);
       
        int highScore = 0;
        String proximityPreference = "";

        for(Map.Entry<String, Integer> score : priceMap.entrySet()){
            if(score.getValue() >= highScore){
                highScore = score.getValue();
                proximityPreference = score.getKey();
            }
        }
        return proximityPreference;
    }

}
