import java.util.Scanner;

public class Person {
    // Decision points are allocated evenly upon instantiation
    private int decisionPts = 10;
    
    private String cuisine = "";
    private int cuisineWt = 0;
    private String ambiance = "";
    private int ambianceWt = 0;
    private String cost = "";
    private int costWt = 0;
    private String withinRange;
    private int withinRangeWt = 0;
    private int groupIndex;

    Person(int groupIndex){
        this.groupIndex = groupIndex;
    }
    
    void setCuisine(String cuisine, int cuisineWt){
        this.cuisine = cuisine;
        this.cuisineWt = cuisineWt;
    }

    void setAmbiance(String ambiance, int ambienceWt){
        this.ambiance = ambiance;
        this.ambianceWt = ambienceWt;
    }
    
    void setCost(String cost, int costWt){
        this.cost = cost;
        this.costWt = costWt;
    }

    void setRange(String withinRange, int withinRangeWt){
        this.withinRange = withinRange;
        this.withinRangeWt = withinRangeWt;
    }

    int getDecisionPts(){
        return this.decisionPts;
    }

    String getCuisine(){
        return this.cuisine;
    }

    int getCuisineWt(){
        return this.cuisineWt;
    }

    String getAmbiance(){
        return this.ambiance;
    }

    int getAmbianceWt(){
        return this.ambianceWt;
    }

    String getCost(){
        return this.cost;
    }
    
    int getCostWt(){
        return this.costWt;
    }

    String getWithinRange(){
        return this.withinRange;
    }

    int getWithinRangePref(){
        return this.withinRangeWt;
    }

    int getGroupIndex(){
        return this.groupIndex;
    }

    // This function is used to check if the user has enough points remaining then award them to the 
    // proper category and subtract them for the points that the user has left to spend.
    int allocateDecisionPoints(int desiredPointAmt, Scanner sc){
        boolean allocating = true;

        while(allocating){
            if(desiredPointAmt <= this.decisionPts){
                decisionPts -= desiredPointAmt;
                allocating = false;
                return desiredPointAmt;
            } else {
                System.out.printf("Not enough points remaining, please allocate a number under or equal to %d: ", decisionPts);
                desiredPointAmt = Validate.checkInt(sc.nextLine(), sc);
            }
        }
    
    return desiredPointAmt;
    }

}
