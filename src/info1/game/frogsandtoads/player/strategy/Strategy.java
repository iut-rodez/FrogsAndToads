package info1.game.frogsandtoads.player.strategy;

import info1.game.frogsandtoads.element.Game;
import info1.game.frogsandtoads.element.GameCharacter;

/**
 * Abstract AI strategy
 * 
 * @author INFO1
 * @version 0.1.0
 */
public abstract class Strategy {
    
    /**
     * Returns the optimal move for the current strategy
     * 
     * @param game Reference to the game state
     * @param characters Characters controlled by the virtual player
     * @return Character to be moved
     */
    public abstract GameCharacter getMove(
            Game game, GameCharacter[] characters);
    
}
