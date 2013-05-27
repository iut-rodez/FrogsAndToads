package info1.game.frogsandtoads.console.util;

import info1.game.frogsandtoads.element.CharacterType;
import info1.game.frogsandtoads.element.GameCharacter;
import info1.game.frogsandtoads.element.Path;
import info1.game.frogsandtoads.element.River;

/**
 * Utility class for drawing into the console
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class OutputUtil {

    /**
     * Clears the console by printing 25 empty lines, which is the default
     * height of the Windows terminal
     */
    public static void clearScreen() {
        
        for (int i = 0; i < 25; ++i) {
            
            System.out.println();
            
        }
        
    }
    
    /**
     * Renders a given game area
     * 
     * @param river River to be displayed in the console
     */
    public static void renderGameArea(River river) {
        
        int height;
        int width;
        
        height = river.getHeight();
        width = river.getPath(0).getLength();
        
        OutputUtil.clearScreen();
        
        System.out.print(" \t");
        
        // Print column header
        for (int i = 0; i < width; ++i) {
            
            if (i < 10) {
                
                System.out.print(" ");
                
            }
            
            System.out.print(i + " ");
            
        }
        
        System.out.println();
        
        for (int i = 0; i < height; ++i) {
            
            // Print line identifier
            System.out.print(((char) ('A' + i)) + "\t");
            
            printPath(river.getPath(i));
            System.out.println();
            
        }
        
        System.out.println();
        
    }
        
    /**
     * Draws a line of leaves into the console
     * 
     * @param path Line to draw
     */
    private static void printPath(Path path) {
        
        int length;
        GameCharacter currentCharacter;     // Character standing on the current
                                            // leaf
        
        length = path.getLength();
        
        for (int i = 0; i < length; ++i) {
            
            currentCharacter = path.getLeaf(i).getCharacter();
            
            if (currentCharacter == null) {
                
                // The leaf is empty
                System.out.print("( )");
                
            } else if (currentCharacter.getType() == CharacterType.CHR_FROG) {
                
                // A frog is standing on the leaf
                System.out.print("(F)");
                
            } else {
                
                // A toad is standing on the leaf
                System.out.print("(T)");
                
            }
            
        }
        
    }
    
}
