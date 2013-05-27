package info1.game.frogsandtoads.player;

import info1.game.frogsandtoads.element.CharacterType;
import info1.game.frogsandtoads.element.Game;
import info1.game.frogsandtoads.element.GameCharacter;
import info1.game.frogsandtoads.player.strategy.FirstMovable;
import info1.game.frogsandtoads.player.strategy.Strategy;

/**
 * Virtual player class
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class VirtualPlayer extends Player {
    
    /**
     * Strategy applied by the virtual player
     */
    private Strategy strategy;
    
    /**
     * Creates a new virtual player for a given type
     * 
     * @param type Type of characters controlled by the virtual player
     * @param characters Characters controlled by the virtual player
     */
    public VirtualPlayer(CharacterType type, GameCharacter[] characters) {
        
        super(type, characters);
        
        strategy = new FirstMovable();
        
    }
    
    /**
     * Requests the player to play its turn
     * 
     * @param gameState Reference to the game state
     * @return True if the turn was played, false if no move was possible.
     */
    @Override
    public boolean playTurn(Game gameState) {
        
        return gameState.requestMove(strategy.getMove(gameState, characters));
        
    }
    
}
