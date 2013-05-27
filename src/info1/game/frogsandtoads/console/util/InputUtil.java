package info1.game.frogsandtoads.console.util;

import info1.game.frogsandtoads.element.Leaf;
import info1.game.frogsandtoads.element.River;
import java.util.Scanner;

/**
 * Utility class for reading data from the standard input
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class InputUtil {
    
    /**
     * Visually inform the player that the game is waiting for some input
     */
    public static void showPrompt() {
        
        System.out.print("> ");
        
    }
    
    /**
     * Reads coordinates and returns the corresponding leaf
     * 
     * @param scanner Scanner
     * @param river River in which a leaf is to be selected
     * @return Reference to a leaf
     */
    public static Leaf readLeaf(Scanner scanner, River river) {

        String coordinates;
        
        int path;
        int leaf;
        
        Leaf selection;
        
        selection = null;
        
        while (selection == null) {
            
            showPrompt();
            
            if (scanner.hasNext("[a-zA-Z][0-9]{1,2}")) {
                
                coordinates = scanner.next("[a-zA-Z][0-9]{1,2}").toUpperCase();
                
                // Read the letter corresponding to the row
                path = coordinates.charAt(0);
                path -= 'A';       // Convert the letter back into a row id
                
                leaf = Integer.parseInt(coordinates.substring(1));

                if (river.getPath(path) != null) {

                    selection = river.getPath(path).getLeaf(leaf);

                }
                
            } else {
                
                scanner.nextLine();
                
            }
            
        }
        scanner.nextLine();
        
        return selection;
        
    }
    
    /**
     * Reads an integer smaller than {@code upperBound} and greater than
     * {@code lowerBound}
     * 
     * @param scanner Scanner
     * @param lowerBound Smallest value permitted
     * @param upperBound Biggest value permitted
     * @return Integer read
     */
    public static int readInt(Scanner scanner, int lowerBound, int upperBound) {
        
        int input;
        
        // Make sure upperBound > lowerBound
        lowerBound = Math.min(lowerBound, upperBound);
        upperBound = Math.max(lowerBound, upperBound);
        
        input = upperBound + 1;
        
        do {
            
            showPrompt();
            
            if (scanner.hasNextInt()) {
                
                input = scanner.nextInt();
                
            } else {
                
                scanner.nextLine();
                
            }
            
        } while (input < lowerBound || input > upperBound);
        
        return input;
        
    }
    
}
