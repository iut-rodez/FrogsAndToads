package info1.game.frogsandtoads;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages presets and preset files. The preset manager holds a list of existing
 * game presets, and has the ability to load/save it from/to a given file.
 * 
 * @author INFO1
 * @version 0.1.0
 */
public class PresetManager {
    
    /**
     * List of presets. This object is serialized and written/read to/from the
     * preset file.
     */
    private List<Preset> presets;
    
    /**
     * File to read/write from/to
     */
    private String file;
    
    /**
     * Initializes the preset manager. Upon instantiation, the preset manager
     * will load all existing presets from the file passed as argument (if the
     * said file exists).
     * 
     * @param file Preset file
     */
    public PresetManager(String file) {
        
        FileInputStream fileStream;
        
        fileStream = null;
        
        this.file = file;
        
        try {
            
            fileStream = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(fileStream);
            
            presets = (ArrayList) input.readObject();
                        
        } catch (IOException | ClassNotFoundException e) {
            
            // Something went wrong
            presets = null;
            
        } finally {
            
            try {
                
                if (fileStream != null) {
                    
                    fileStream.close();
                
                }
                
            } catch (IOException e) {}
            
        }
        
        if (presets == null) {
            
            presets = new ArrayList<>();
            
        }
        
    }
    
    /**
     * Serializes the preset list and saves it into the preset file
     * 
     * @return True if the presets were written successfully, false otherwise
     */
    public boolean save() {
        
        FileOutputStream fileStream;
        
        fileStream = null;
        
        try {
            
            fileStream = new FileOutputStream(file);
            ObjectOutputStream output = new ObjectOutputStream(fileStream);
            
            output.writeObject(presets);
            
        } catch (IOException e) {
            
            // Something went wrong
            return false;
            
        } finally {
            
            try {
                
                fileStream.close();
                
            } catch (IOException e) {}
            
        }
        
        return true;
        
    }
    
    /**
     * Returns the number of presets in the preset list
     * 
     * @return Number of presets available
     */
    public int getPresetCount() {
        
        return presets.size();
        
    }
    
    /**
     * Returns a reference to the preset identified by {@code id}
     * 
     * @param id Unique identifier of the preset
     * @return Preset object, or null if {@code id} does not match with any
     *         preset.
     */
    public Preset getPreset(int id) {
        
        if (id >= 0 && id < presets.size()) {
            
            return presets.get(id);
            
        }
        
        // No preset is identified by the given id
        return null;
        
    }
    
    /**
     * Removes the preset identified by {@code id}
     * 
     * @param id Unique identifier of the preset
     * @return  True if a preset was removed, false otherwise
     */
    public boolean removePreset(int id) {
        
        if (id > 0 && id < presets.size()) {
            
            presets.remove(id);
            return true;
            
        }
        
        // No preset is identified by the given id
        return false;
        
    }
    
    /**
     * Adds a preset to the collection
     * 
     * @param preset Preset to add
     */
    public void addPreset(Preset preset) {
        
        if (preset != null) {
            
            presets.add(preset);
            
        }
        
    }
    
}
