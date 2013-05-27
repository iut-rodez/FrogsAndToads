package info1.game.frogsandtoads.console;

import info1.game.frogsandtoads.console.util.InputUtil;
import info1.game.frogsandtoads.console.util.OutputUtil;
import java.util.Scanner;

/**
 * Main menu
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class MainMenu {

    /**
     * Displays the main menu and lets the player interact with it
     * 
     * @return Player's choice
     */
    public static int run() {
        
        Scanner scanner = new Scanner(System.in);
        
        OutputUtil.clearScreen();
        
        System.out.println(" ****** Frogs'n'Toads ****** ");
        System.out.println();
        System.out.println("Main menu");
        System.out.println();
        System.out.println("    1. Load preset");
        System.out.println("    2. Custom game");
        System.out.println("    3. Puzzle game");
        System.out.println();
        System.out.println("    0. Exit");
        System.out.println();
        
        return InputUtil.readInt(scanner, 0, 3);
        
    }
    
}
