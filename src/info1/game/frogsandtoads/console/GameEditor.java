package info1.game.frogsandtoads.console;

import info1.game.frogsandtoads.Preset;
import info1.game.frogsandtoads.PresetManager;
import info1.game.frogsandtoads.console.util.InputUtil;
import info1.game.frogsandtoads.console.util.OutputUtil;
import info1.game.frogsandtoads.element.*;
import java.util.Scanner;

/**
 * Custom game editor
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class GameEditor {
    
    /**
     * Assists the user in creating a custom game area
     * 
     * @param presets Preset manager, used for saving the game area if the user
     *                wishes to do so
     * @return Resulting river object
     */
    public static River run(PresetManager presets) {
        
        int riverWidth;
        int riverHeight;
        
        int maxCharacters;  // Maximum number of characters that can be placed
                            // on the game area
        int frogs;          // Number of frogs the user wishes to create
        int toads;          // Number of toads the user wishes to create
        
        GameCharacter newCharacter;   // Used when instantiating new characters
        Leaf startingPosition;        // Starting position for the newly created
                                      // character
        
        River river;        // Game area the user is working on
        
        String presetName;  // Holds a name for the preset if the user wishes to
                            // save their work
        
        Scanner scanner = new Scanner(System.in);
                
        OutputUtil.clearScreen();
        
        // Assist the user in creating the river
        System.out.println("How wide is the river ? " 
                + "(" + River.MIN_WIDTH + " to " + River.MAX_WIDTH + ")");
        
        riverWidth = InputUtil.readInt(
                scanner, River.MIN_WIDTH, River.MAX_WIDTH);
        
        System.out.println("\nHow many rows of leaves are there ? " 
                + "(" + River.MIN_HEIGHT + " to " + River.MAX_HEIGHT + ")");
        
        riverHeight = InputUtil.readInt(
                scanner, River.MIN_HEIGHT, River.MAX_HEIGHT);
        
        // Create the river
        river = new River(riverWidth, riverHeight);
        
        // Prompt the user for the number of characters of each type to create
        maxCharacters = (riverWidth / 2) * riverHeight;
        
        System.out.println(
                "\nHow many frogs do you want ? (1 to " + maxCharacters + ")");
        
        frogs = InputUtil.readInt(scanner, 1, maxCharacters);
        
        System.out.println(
                "\nHow many toads do you want ? (1 to " + maxCharacters + ")");
        
        toads = InputUtil.readInt(scanner, 1, maxCharacters);
                
        // Place the frogs
        for (int i = 0; i < frogs; ++i) {
            
            OutputUtil.clearScreen();
            OutputUtil.renderGameArea(river);
            
            System.out.println("Enter coordinates for a frog (E.g.: A5) :");
            
            // Prompt the user for the starting position of the new character
            do {
                
                startingPosition = InputUtil.readLeaf(scanner, river);
                
            } while (startingPosition.getCharacter() != null);
            
            // Add the character to the game area
            newCharacter = new GameCharacter(CharacterType.CHR_FROG);
            river.addCharacter(newCharacter, startingPosition);
                
        }
        
        // Place the toads
        for (int i = 0; i < toads; ++i) {
            
            OutputUtil.clearScreen();
            OutputUtil.renderGameArea(river);
            
            System.out.println("Enter coordinates for a toad (E.g.: B2) :");
            
            // Prompt the user for the starting position of the new character
            startingPosition = InputUtil.readLeaf(scanner, river);
            
            // Make sure no character is currently occupying the leaf
            if (startingPosition.getCharacter() == null) {
                
                // Add the character to the game area
                newCharacter = new GameCharacter(CharacterType.CHR_TOAD);
                river.addCharacter(newCharacter, startingPosition);
                
            }
            
        }
        
        // Displays the final state of the game area
        OutputUtil.clearScreen();
        OutputUtil.renderGameArea(river);
        
        System.out.println("Press return to confirm...");
        scanner.nextLine();
        
        // Allow the user to save their work
        OutputUtil.clearScreen();
        System.out.println(
                "Enter a name for your new preset (return to skip) :");
        
        presetName = scanner.nextLine();
        
        if (presetName.length() > 0) {
            
            // A preset name has been entered
            presets.addPreset(new Preset(presetName, river));
            presets.save();
            
        }
        
        return river;
        
    }
    
}
