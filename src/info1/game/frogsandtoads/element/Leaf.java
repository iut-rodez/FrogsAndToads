package info1.game.frogsandtoads.element;

import java.io.Serializable;

/**
 * Node the leaf graph
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class Leaf implements Serializable {
    
    /**
     * Previous node in the graph, from left to right
     */
    private Leaf previousLeaf;
    
    /**
     * Next node in the graph, from left to right
     */
    private Leaf nextLeaf;
    
    /**
     * GameCharacter currently standing on the leaf
     */
    private GameCharacter character;
    
    /**
     * Creates a node and links it to the previous one when possible.
     * 
     * @param previous Previous node when the graph is read from left to right,
     *                 or null if the node being constructed is the first one
     *                 in the graph
     */
    @SuppressWarnings("LeakingThisInConstructor") /* Passing a reference to this
                                                   * node in the constructor
                                                   * reasonably safe in this
                                                   * case
                                                   */
    Leaf(Leaf previous) {
        
        previousLeaf = previous;
        
        if (previous != null) {
            
            previous.nextLeaf = this;
            
        }
        
    }
    
    /**
     * Next leaf in the graph
     * 
     * @return A reference to the next leaf
     */
    public Leaf next() {
        
        return nextLeaf;
        
    }
    
    /**
     * Previous leaf in the graph
     * 
     * @return A reference to the previous leaf
     */
    public Leaf previous() {
        
        return previousLeaf;
        
    }
    
    /**
     * Check if the leaf is the first one in the graph, in which case a call
     * to {@code previous()} would return {@code null}
     * 
     * @return True if the leaf is the first one in the graph
     */
    public boolean isFirst() {
    
        return (previousLeaf == null);
        
    }
    
    /**
     * Check if the leaf is the last one in the graph, in which case a call
     * to {@code next()} would return {@code null}
     * 
     * @return True if the leaf is the last one in the graph
     */
    public boolean isLast() {
        
        return (nextLeaf == null);
        
    }
    
    /**
     * Moves a character onto, or away from, the leaf
     * 
     * @param character GameCharacter to move onto the leaf, or null if the leaf
     *                  is to be become vacant
     */
    void setCharacter(GameCharacter character) {
        
        this.character = character;
        
    }
    
    /**
     * Returns a reference to the character standing on the leaf
     * 
     * @return Reference to a character, or null if the leaf is vacant
     */
    public GameCharacter getCharacter() {
        
        return character;
        
    }
    
}
