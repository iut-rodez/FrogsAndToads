package info1.game.frogsandtoads;

import info1.game.frogsandtoads.console.*;
import info1.game.frogsandtoads.element.Game;
import info1.game.frogsandtoads.element.River;

/**
 * Main class
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class FrogsAndToads {
    
    /**
     * Entry point
     * 
     * @param args Not used
     */
    public static void main(String[] args) {
        
        int choice;         // Menu choice
        boolean exit;       // True if the execution should end
        
        PresetManager presets;      // Preset manager
        Preset preset;              // Selected preset
        
        River gameArea;     // Game area loaded from preset or created in the
                            // editor
        Game game;          // Game state
        
        // Load presets from file
        presets = new PresetManager("presets.dat");
        
        gameArea = null;
        exit = false;
        while (!exit) {
            
            choice = MainMenu.run();
            
            switch(choice) {
                
                case 1:     // Load preset
                    preset = PresetMenu.run(presets);
                    
                    if (preset != null) {
                        
                        gameArea = preset.getRiver();
                        
                    }
                    
                    break;
                    
                case 2:     // Custom game
                    gameArea = GameEditor.run(presets);
                    break;
                    
                case 3:     // Puzzle mode
                    PuzzleGame.play();
                    break;
                    
                case 0:     // Exit
                    exit = true;
                    break;
                
            }
            
            if (gameArea != null) {
                
                // Start the game
                game = PlayerMenu.run(gameArea);
                StandardGame.play(game);
                
                // Reset references before starting over
                preset = null;
                gameArea = null;
                game = null;
                
            }
            
        }
        
    }

    
}
