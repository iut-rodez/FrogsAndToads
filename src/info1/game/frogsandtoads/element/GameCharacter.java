package info1.game.frogsandtoads.element;

import java.io.Serializable;

/**
 * Representation of a game character. A character has a type and a leaf
 * corresponding to its current position.
 * 
 * @author INFO1
 * @version 0.1.0
 */
public final class GameCharacter implements Serializable {
    
    /**
     * Type of character
     */
    private CharacterType type;
    
    /**
     * Leaf on which the character is currently standing
     */
    private Leaf leaf;
    
    /**
     * Creates a character of a given type 
     * 
     * @param type Character type
     */
    public GameCharacter(CharacterType type) {
        
        this.type = type;
        
    }
    
    /**
     * Returns the type of the character
     * 
     * @return Type of the character
     */
    public CharacterType getType() {
        
        return type;
        
    }
    
    /**
     * Changes the leaf on which the character is standing. This method will not
     * check whether the move is legal or not.
     * 
     * @param newPosition New leaf
     * @return True if the character was moved, or false if another character 
     *         was already standing on {@code newPosition}
     */
    boolean setLeaf(Leaf newPosition) {
        
        if (newPosition != null && newPosition.getCharacter() == null) {
            
            if (leaf != null) {
                
                leaf.setCharacter(null);
                
            }
            
            leaf = newPosition;
            newPosition.setCharacter(this);
            return true;
            
        }
        
        return false;
        
    }
    
    /**
     * Returns the leaf on which the character is currently standing
     * 
     * @return Leaf object, or null if the character is not in the game area
     */
    public Leaf getLeaf() {
        
        return leaf;
        
    }
    
    /**
     * Test if the character is in the game area
     * 
     * @return True if the character is in the game area, false otherwise
     */
    public boolean isInGame() {
        
        return leaf != null;
        
    }
    
    /**
     * Returns a reference to the leaf that is one hop away from the character
     * 
     * @return Reference to a leaf object, or null if there is nowhere to hop,
     *         or if the character is not in the game area
     */
    public Leaf getHopDestination() {
        
        if (!isInGame()) {
            
            return null;
            
        }
        
        // The direction of the move depends on the character type
        if (type == CharacterType.CHR_FROG) {
            
            return leaf.next();
            
        } else {
            
            return leaf.previous();
            
        }
        
    }
    
    /**
     * Returns a reference to the leaf that is one jump away from the character
     * 
     * @return Reference to a leaf object, or null if there is nowhere to jump
     */
    public Leaf getJumpDestination() {
        
        Leaf hopDestination;
        
        hopDestination = getHopDestination();
        
        // The direction of the move depends on the character type
        if (hopDestination != null) {
            
            if (type == CharacterType.CHR_FROG) {
                
                return hopDestination.next();
                
            } else {
                
                return hopDestination.previous();
                
            }
            
        }
        
        return null;
        
    }
    
    /**
     * Test if the character can hop
     * 
     * @return True if the character can hop, false otherwise
     */
    public boolean canHop() {
        
        Leaf hopDestination;
        
        hopDestination = getHopDestination();
        
        return (hopDestination != null 
                && hopDestination.getCharacter() == null);
        
    }
    
    /**
     * Test if the character can jump
     * 
     * @return True if the character can jump, false otherwise
     */
    public boolean canJump() {
        
        Leaf jumpDestination;
        Leaf hopDestination;
        
        hopDestination = getHopDestination();
        jumpDestination = getJumpDestination();
        
        return (hopDestination != null && jumpDestination != null
                && hopDestination.getCharacter() != null
                && hopDestination.getCharacter().type != type
                && jumpDestination.getCharacter() == null);
        
    }
    
    /**
     * Test if the character can move
     * 
     * @return True if the character can move, false otherwise
     */
    public boolean canMove() {
        
        return (canHop() || canJump());
        
    }
    
    /**
     * Finds the leaf onto which the character can move
     * 
     * @return Reference to a leaf onto which the character can move, or
     *         {@code null} if no such leaf exists
     */
    public Leaf getMove() {
        
        if (canHop()) {
            
            return getHopDestination();
            
        } else if (canJump()) {
            
            return getJumpDestination();
            
        }
        
        return null;
        
    }
    
    /**
     * Move the character
     * 
     * @return True if the character has moved, false if no move was possible
     */
    boolean move() {
        
        Leaf destination;
        
        destination = getMove();
        
        if (destination != null) {
            
            setLeaf(destination);
            return true;
            
        }
        
        return false;
        
    }
    
}
