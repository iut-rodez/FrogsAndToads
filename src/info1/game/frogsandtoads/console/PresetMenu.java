package info1.game.frogsandtoads.console;

import info1.game.frogsandtoads.Preset;
import info1.game.frogsandtoads.PresetManager;
import info1.game.frogsandtoads.console.util.InputUtil;
import info1.game.frogsandtoads.console.util.OutputUtil;
import java.util.Scanner;

/**
 * Preset selection menu
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class PresetMenu {
    
    /**
     * Lets the player pick a game preset to load, or delete an existing preset
     * 
     * @param presets Preset manager
     * @return Selected preset
     */
    public static Preset run(PresetManager presets) {
        
        int count;         // Number of presets available
        int selection;     // Selected preset
        
        Scanner scanner = new Scanner(System.in);
        
        OutputUtil.clearScreen();
                
        count = presets.getPresetCount();
        
        if (count == 0) {
            
            // The preset manager doesn't hold any preset
            System.out.println("No presets available.");
            System.out.println("You can create presets by selecting "
                    + "'Custom game' from the main menu.");
            System.out.println("Press return to go back to the main menu.");
            
            scanner.nextLine();
            
            return null;
            
        }
        
        do {
            
            count = presets.getPresetCount();
            
            OutputUtil.clearScreen();
            
            System.out.print("Which preset do you wish to load ? ");
            System.out.print("(start with - to delete)");
            System.out.println();


            // List all presets
            for (int i = 0; i < count; ++i) {

                System.out.println(
                        "    " + i + ".\t" + presets.getPreset(i).getName());

            }

            System.out.println();
            // Read user's input
            selection = InputUtil.readInt(scanner, -(count - 1), count - 1);

            if (selection < 0) {        // The default preset cannot be deleted
                
                // The user wants to delete an existing preset
                presets.removePreset(-selection);
                
            }
            
        } while (selection < 0);
        
        presets.save();         // Save changes to the preset file
        
        return presets.getPreset(selection);
        
    }
    
}
