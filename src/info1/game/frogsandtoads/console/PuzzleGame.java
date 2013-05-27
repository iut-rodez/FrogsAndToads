package info1.game.frogsandtoads.console;

import info1.game.frogsandtoads.console.util.InputUtil;
import info1.game.frogsandtoads.console.util.OutputUtil;
import info1.game.frogsandtoads.element.*;
import info1.game.frogsandtoads.player.HumanPlayer;
import info1.game.frogsandtoads.player.Player;
import java.util.Scanner;

/**
 * Puzzle game mode. In this mode, one player controls both the frogs and toads
 * in the order they want. The goal is to make all characters cross the river.
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class PuzzleGame {
    
    /**
     * Starts the game in puzzle mode
     */
    public static void play() {
        
        GameCharacter movingCharacter;     // Character the player wants to move
        
        Scanner scanner = new Scanner(System.in);
        
        River river = new River(5, 1);     // (5, 1) is the size of the original
                                           // puzzle game
        Path path = river.getPath(0);      // Only one path exists
        
        // Create two frogs
        river.addCharacter(
                new GameCharacter(CharacterType.CHR_FROG), path.getLeaf(0));
        river.addCharacter(
                new GameCharacter(CharacterType.CHR_FROG), path.getLeaf(1));
        
        // Create two toads
        river.addCharacter(
                new GameCharacter(CharacterType.CHR_TOAD), path.getLeaf(3));
        river.addCharacter(
                new GameCharacter(CharacterType.CHR_TOAD), path.getLeaf(4));
                
        // Create fictious players for each type, because the game requires one
        // player for each character type
        Player frogs = 
                new HumanPlayer(CharacterType.CHR_FROG, river.getFrogs());
        Player toads = 
                new HumanPlayer(CharacterType.CHR_TOAD, river.getToads());
        
        Game game = new Game(river, frogs, toads);
        
        while (frogs.canMove() || toads.canMove()) {
            
            OutputUtil.clearScreen();
            OutputUtil.renderGameArea(river);
            
            System.out.println("What will you do next ?");
            
            movingCharacter = InputUtil.readLeaf(scanner, river).getCharacter();
            
            if (movingCharacter != null) {
                
                if (game.getTurn() != movingCharacter.getType()) {
                    
                    // Move on to the next turn so that characters of the 
                    // selected type can be moved
                    game.nextTurn();
                    
                }
                
                game.requestMove(movingCharacter);
                
            }
            
        }
                
        OutputUtil.clearScreen();
        OutputUtil.renderGameArea(river);
            
        if (path.getLeaf(0).getCharacter() != null
                && path.getLeaf(1).getCharacter() != null
                && path.getLeaf(0).getCharacter().getType()
                    == path.getLeaf(1).getCharacter().getType()) {
            
            // The player moved two characters to the other end of the river,
            // victory is thus guaranteed.
            System.out.println("You win !");
            
        } else {
            
            System.out.println("You lose !");
            
        }
        
        scanner.nextLine();
        
    }
    
}
