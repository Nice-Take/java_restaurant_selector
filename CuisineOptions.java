import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


public class CuisineOptions {
    public static ArrayList<String> getCuisineList(){

        // This class/function are built to bring in the cuisine options from a config
        // file in order to avoid hard-coding the options into the program
            
        ArrayList<String> cuisines = new ArrayList<String>();

        try {
            Scanner sc = new Scanner(new File("./config.csv"));       
            sc.useDelimiter(",");
            while(sc.hasNext()){
                String nextItem = sc.next();
                cuisines.add(nextItem);
            }
            sc.close();

        } catch (Exception e) {
            System.out.println("[ERROR] The cuisine configuration has failed to read-in.");
        }

        return cuisines;
    }

}
