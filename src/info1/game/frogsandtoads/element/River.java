package info1.game.frogsandtoads.element;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The river is the main game area, consisting of a set of lines of leaves 
 * (paths)
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class River implements Serializable {
    
    /**
     * Minimum number of leaves per row
     */
    public static final int MIN_WIDTH = 5;
    
    /**
     * Maximum number of leaves per row
     */
    public static final int MAX_WIDTH = 15;
    
    /**
     * Minimum number rows
     */
    public static final int MIN_HEIGHT = 1;
    
    /**
     * Maximum number of rows
     */
    public static final int MAX_HEIGHT = 5;
    
    /**
     * Number of rows of leaves
     */
    private int rows;
    
    /**
     * Array of leaf lines in the river
     */
    private Path[] lines;
    
    /**
     * List of frogs on the game area
     */
    private ArrayList<GameCharacter> frogs;
    
    /**
     * List of toads on the game area
     */
    private ArrayList<GameCharacter> toads;
        
    /**
     * Creates a new river of a given size
     * 
     * @param width Width of the river, in leaves (on a 2D plane)
     * @param height Height of the river, in leaves (on a 2D plane)
     */
    public River(int width, int height) {
        
        rows = height;
        
        lines = new Path[rows];
        
        if (rows > 0) {
            
            for (int i = 0; i < rows; ++i) {
                
                lines[i] = new Path(width);
                
            }
            
        }
        
        frogs = new ArrayList<>();
        toads = new ArrayList<>();
        
    }
    
    /**
     * Returns the height of the river (number of rows)
     * 
     * @return Number of rows of leaves
     */
    public int getHeight() {
        
        return rows;
        
    }
    
    /**
     * Returns the path identified by {@code number}
     * @param number Number of the path, from top to bottom
     * @return Reference to a {@code Path}, or {@code null} if no path is
     *         identified by {@code number}
     */
    public Path getPath(int number) {
        
        if (number >= 0 && number < rows) {
            
            return lines[number];
            
        }
        
        return null;
        
    }
    
    /**
     * Returns an array of references to the frogs on the game area
     * 
     * @return Array of characters
     */
    public GameCharacter[] getFrogs() {
        
        return frogs.toArray(new GameCharacter[frogs.size()]);
        
    }
    
    /**
     * Returns an array of references to the toads on the game area
     * 
     * @return Array of characters
     */
    public GameCharacter[] getToads() {
        
        return toads.toArray(new GameCharacter[toads.size()]);
        
    }
    
    /**
     * Adds a character to the game area
     * 
     * @param character New character
     * @param initialPosition Starting position
     * @return True if the character has been added to the game area, false if
     *         {@code character} was null, or if the initial position was
     *         invalid.
     */
    public boolean addCharacter(GameCharacter character, Leaf initialPosition) {
        
        if (character != null && initialPosition != null
                && initialPosition.getCharacter() == null) {
            
            if (character.getType() == CharacterType.CHR_FROG) {
                
                frogs.add(character);
                
            } else {
                
                toads.add(character);
                
            }
            
            character.setLeaf(initialPosition);
            
        }
        
        return false;
        
    }
    
}
