package info1.game.frogsandtoads.element;

import info1.game.frogsandtoads.player.Player;

/**
 * Represents a running game and lets other subsystems interact with it
 * 
 * @author INFO1
 * @version 0.1.0
 */
public final class Game {
    
    /**
     * Game area
     */
    private River river;
    
    /**
     * Player controlling the frogs
     */
    private Player frogPlayer;
    
    /**
     * Player controlling the toads
     */
    private Player toadPlayer;
    
    /**
     * Which type plays next
     */
    private CharacterType turn;
    
    /**
     * Creates a new game
     * 
     * @param river Game area
     * @param frogPlayer Player controlling the frogs
     * @param toadPlayer Player controlling the toads
     */
    public Game(River river, Player frogPlayer, Player toadPlayer) {
        
        this.river = river;
        turn = CharacterType.CHR_FROG;
        
        setPlayers(frogPlayer, toadPlayer);
                
    }
    
    /**
     * Changes the players
     * 
     * @param frogPlayer Player controlling the frogs
     * @param toadPlayer Player controlling the toads
     */
    private void setPlayers(Player frogPlayer, Player toadPlayer) {
        
        this.frogPlayer = frogPlayer;
        this.toadPlayer = toadPlayer;
        
    }
    
    /**
     * Returns a reference to the player controlling characters of type 
     * {@code type}
     * 
     * @param type Type of character
     * @return Reference to a player
     */
    public Player getPlayer(CharacterType type) {
        
        if (type == CharacterType.CHR_FROG) {
            
            return frogPlayer;
            
        } else {
            
            return toadPlayer;
            
        }
        
    }
    
    /**
     * Returns a reference to the game area
     * 
     * @return Reference to the game area
     */
    public River getRiver() {
        
        return river;
        
    }
    
    /**
     * Returns the type who's turn it is to play
     * 
     * @return Character type
     */
    public CharacterType getTurn() {
        
        return turn;
        
    }
    
    /**
     * Move on to the next turn
     */
    public void nextTurn() {
        
        if (turn == CharacterType.CHR_FROG) {
            
            turn = CharacterType.CHR_TOAD;
            
        } else {
            
            turn = CharacterType.CHR_FROG;
            
        }
        
    }
    
    /**
     * Moves a character if such a move is permitted
     * 
     * @param character Character to move
     * @return True if character was moved, false otherwise
     */
    public boolean requestMove(GameCharacter character) {
        
        if (character != null 
                && character.getType() == turn) {
            
            return character.move();
            
        }
        
        return false;
        
    }
    
}
