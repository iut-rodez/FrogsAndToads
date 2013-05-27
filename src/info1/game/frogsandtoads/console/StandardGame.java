package info1.game.frogsandtoads.console;

import info1.game.frogsandtoads.console.util.OutputUtil;
import info1.game.frogsandtoads.element.CharacterType;
import info1.game.frogsandtoads.element.Game;
import info1.game.frogsandtoads.player.Player;
import java.util.Scanner;

/**
 * Standard game mode. Two players take turn in trying to block each other's
 * progress. Whichever player successfully blocks the other wins.
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class StandardGame {
    
    /**
     * Starts the game
     * 
     * @param game Game to start
     */
    public static void play(Game game) {
        
        Player currentPlayer;
        Player winner;          // Winning player
        Player loser;           // Losing player
        
        Scanner scanner = new Scanner(System.in);
        
        winner = null;
        loser = null;
        
        while (winner == null) {
            
            OutputUtil.clearScreen();
            OutputUtil.renderGameArea(game.getRiver());
            
            // Get this turn's player
            currentPlayer = game.getPlayer(game.getTurn());
            
            if (currentPlayer.canMove()) {
                
                // Announce the player's turn
                if (game.getTurn() == CharacterType.CHR_FROG) {
                    
                    System.out.println("Frogs play...");
                    
                } else {
                    
                    System.out.println("Toads play...");
                    
                }
                
                // Tell the player to play its turn
                currentPlayer.playTurn(game);
                game.nextTurn();
                
            } else {
                
                // Someone got stuck
                
                loser = currentPlayer;
                
                if (currentPlayer.getType() == CharacterType.CHR_FROG) {
                    
                    winner = game.getPlayer(CharacterType.CHR_TOAD);
                    
                } else {
                    
                    winner = game.getPlayer(CharacterType.CHR_FROG);
                    
                }
                
            }
            
        }
        
        OutputUtil.clearScreen();
        OutputUtil.renderGameArea(game.getRiver());
        System.out.println();
        
        // Announce the winning type
        if (winner.getType() == CharacterType.CHR_FROG) {
            
            System.out.println("Frogs win !");
            
        } else {
            
            System.out.println("Toads win !");
            
        }
        
        scanner.nextLine();
        
    }
    
}
