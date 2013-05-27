package info1.game.frogsandtoads.player.strategy;

import info1.game.frogsandtoads.element.Game;
import info1.game.frogsandtoads.element.GameCharacter;

/**
 * Suggests the first character found to be able to move
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class FirstMovable extends Strategy {

    /**
     * Returns the optimal move for the current strategy
     * 
     * @param game Reference to the game state
     * @param characters Characters controlled by the virtual player
     * @return Character to be moved
     */
    @Override
    public GameCharacter getMove(Game game, GameCharacter[] characters) {
        
        for (int i = 0; i < characters.length; ++i) {
        
            if (characters[i].canMove()) {
                
                return characters[i];
                
            }
        
        }
        
        return null;
        
    }
        
}
