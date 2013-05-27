package info1.game.frogsandtoads.element;

import java.io.Serializable;

/**
 * Describes the possible moves of the characters. A path is a graph consisting
 * of leaves.
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class Path implements Serializable {
    
    /**
     * Length of the path
     */
    private int length;
    
    /**
     * Leaves composing the path
     */
    private Leaf[] leaves;
    
    /**
     * Constructs a path
     * 
     * @param length Number of leaves
     */
    Path(int length) {
        
        this.length = length;
        
        if (length > 2) {
            
            leaves = new Leaf[length];
            
            leaves[0] = new Leaf(null);
            
            // Populate the path with leaves
            for (int i = 1; i < length; ++i) {
                
                leaves[i] = new Leaf(leaves[i - 1]);
                
            }
            
        }
        
    }
    
    /**
     * Length of the path
     * 
     * @return Number of leaves in the path
     */
    public int getLength() {
        
        return length;
        
    }
    
    /**
     * Returns a reference to the leaf identified by {@code number}
     * 
     * @param number Number corresponding to the leaf, from left to right with
     *               the first one being 0
     * @return Reference to a Leaf object, or null if no leaf is identified by
     *         the given value
     */
    public Leaf getLeaf(int number) {
        
        if (number >= 0 && number < length) {
            
            return leaves[number];
            
        }
        
        return null;
        
    }
    
    /**
     * Returns the first leaf in the graph
     * 
     * @return Reference to a Leaf object
     */
    public Leaf getFirst() {
        
        return getLeaf(0);
        
    }
    
    /**
     * Returns the last leaf in the graph
     * 
     * @return Reference to a leaf object
     */
    public Leaf getLast() {
        
        return getLeaf(getLength() - 1);
        
    }
    
}
