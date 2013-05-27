package info1.game.frogsandtoads.console;

import info1.game.frogsandtoads.console.util.InputUtil;
import info1.game.frogsandtoads.console.util.OutputUtil;
import info1.game.frogsandtoads.element.CharacterType;
import info1.game.frogsandtoads.element.Game;
import info1.game.frogsandtoads.element.River;
import info1.game.frogsandtoads.player.HumanPlayer;
import info1.game.frogsandtoads.player.Player;
import info1.game.frogsandtoads.player.VirtualPlayer;
import java.util.Scanner;

/**
 * Player selection menu
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class PlayerMenu {
    
    /**
     * Lets the user create a new game by selecting a player type for each
     * character type
     * 
     * @param river Game area to play in
     * @return Fully created game
     */
    public static Game run(River river) {
        
        int choice1;    // Frog player type
        int choice2;    // Toad player type
        
        Player player1; // Frog player
        Player player2; // Toad player
        
        Scanner scanner = new Scanner(System.in);
        
        OutputUtil.clearScreen();
        System.out.println("Player types : ");
        System.out.println("    1. Human");
        System.out.println("    2. AI");
        System.out.println();
        
        System.out.println("Who plays the frogs ?");
        choice1 = InputUtil.readInt(scanner, 1, 2);
        
        System.out.println("Who plays the toads ?");
        choice2 = InputUtil.readInt(scanner, 1, 2);
        
        player1 = null;
        
        switch (choice1) {
            
            case 1:
                player1 = new HumanPlayer(
                        CharacterType.CHR_FROG, river.getFrogs());
                break;
            
            case 2:
                player1 = new VirtualPlayer(
                        CharacterType.CHR_FROG, river.getFrogs());
                break;                
                
        }
        
        player2 = null;
        
        switch (choice2) {
            
            case 1:
                player2 = new HumanPlayer(
                        CharacterType.CHR_TOAD, river.getToads());
                break;
            
            case 2:
                player2 = new VirtualPlayer(
                        CharacterType.CHR_TOAD, river.getToads());
                break;                
                
        }
        
        return new Game(river, player1, player2);
        
    }
    
}
