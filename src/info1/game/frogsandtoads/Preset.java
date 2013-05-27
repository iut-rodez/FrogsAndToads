package info1.game.frogsandtoads;

import info1.game.frogsandtoads.element.River;
import java.io.Serializable;

/**
 * Representation of a game preset. A preset consists of a name and an initial
 * game area, containing the characters at their default position.
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class Preset implements Serializable {

    /**
     * Preset name
     */
    private String name;
    
    /**
     * Initial game state
     */
    private River river;
    
    /**
     * Creates a game preset with a given name
     * 
     * @param name Preset name
     * @param river Initial game area
     */
    public Preset(String name, River river) {
        
        this.name = name;
        this.river = river;
        
    }
    
    /**
     * Returns the name of the preset
     * 
     * @return Name of the preset
     */
    public String getName() {
        
        return name;
        
    }
    
    /**
     * Returns a reference to the initial game area
     * 
     * @return {@code River} object
     */
    public River getRiver() {
        
        return river;
        
    }

}
