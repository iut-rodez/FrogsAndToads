package info1.game.frogsandtoads.player;

import info1.game.frogsandtoads.console.util.InputUtil;
import info1.game.frogsandtoads.element.CharacterType;
import info1.game.frogsandtoads.element.Game;
import info1.game.frogsandtoads.element.GameCharacter;
import info1.game.frogsandtoads.element.Leaf;
import java.util.Scanner;

/**
 * Human player class
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class HumanPlayer extends Player {

    /**
     * Creates a new human player for a given type
     * 
     * @param type Type of characters controlled by the human player
     * @param characters Characters controlled by the human player
     */
    public HumanPlayer(CharacterType type, GameCharacter[] characters) {
        
        super(type, characters);
        
    }
    
    /**
     * Requests the player to play its turn
     * 
     * @param gameState Reference to the game state
     * @return True if the turn was played, false if no move was possible.
     */
    @Override
    public boolean playTurn(Game gameState) {
        
        Leaf selection;
        
        Scanner scanner = new Scanner(System.in);
           
        do {
            
            System.out.println();
            System.out.println("What's your move ?");
            selection = InputUtil.readLeaf(scanner, gameState.getRiver());
            
        } while (!gameState.requestMove(selection.getCharacter()));
        
        return true;
        
    }
    
}
