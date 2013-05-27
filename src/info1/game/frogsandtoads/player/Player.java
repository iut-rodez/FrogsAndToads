package info1.game.frogsandtoads.player;

import info1.game.frogsandtoads.element.CharacterType;
import info1.game.frogsandtoads.element.Game;
import info1.game.frogsandtoads.element.GameCharacter;

/**
 * Abstract player
 * 
 * @author INFO1
 * @version 0.1.0
 */
public abstract class Player {
    
    /**
     * Type of character controlled by the player
     */
    protected CharacterType type;
    
    /**
     * Array of characters controlled by the player
     */
    protected GameCharacter[] characters;
        
    /**
     * Creates a new player of a given type
     * 
     * @param type Type of characters controlled by the new player
     * @param characters Characters controlled by the player
     */
    public Player(CharacterType type, GameCharacter[] characters) {
        
        this.type = type;
        this.characters = characters;
        
    }

    /**
     * Returns the type of character the player controls
     * 
     * @return Type of character
     */
    public CharacterType getType() {
        
        return type;
    
    }
    
    /**
     * Tests if the player can move a character
     * 
     * @return True if a character can be moved, false if the player is stuck
     */
    public boolean canMove() {
        
        for (int i = 0; i < characters.length; ++i) {
            
            if (characters[i].canMove()) {
                
                return true;
                
            }
            
        }
        
        return false;
        
    }
    
    /**
     * Requests the player to play its turn
     *
     * @param gameState Reference to the game state
     * @return True if the player has been able to play, false if no move was
     *         possible
     */
    public abstract boolean playTurn(Game gameState);
    
}
