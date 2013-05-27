package info1.game.frogsandtoads.element;

import info1.game.frogsandtoads.element.Game;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests info1.game.frogsandtoads.element.GameCharacter
 * 
 * @author INFO1
 */
public class GameCharacterTest {
    
    // Fixture
    private GameCharacter char1;
    private GameCharacter char2;
    private GameCharacter char3;
    private Leaf leaf1;
    private Leaf leaf2;
    private Leaf leaf3;
    private Leaf leaf4;
    private Leaf leaf5;
    
    /**
     * Set up the fixture
     */
    @Before
    public void setUp() {
        
        char1 = new GameCharacter(CharacterType.CHR_FROG);
        char2 = new GameCharacter(CharacterType.CHR_FROG);
        char3 = new GameCharacter(CharacterType.CHR_TOAD);
        
        leaf1 = new Leaf(null);
        leaf2 = new Leaf(leaf1);
        leaf3 = new Leaf(leaf2);
        leaf4 = new Leaf(leaf3);
        leaf5 = new Leaf(leaf4);
        
        char1.setLeaf(leaf1);
        char2.setLeaf(leaf3);
        char3.setLeaf(leaf4);
        
    }
    
    /**
     * Test of setLeaf method, of class GameCharacter.
     */
    @Test
    public void testSetLeaf() {
        
        char1.setLeaf(leaf1);
        assertEquals(char1, leaf1.getCharacter());
        
    }

    /**
     * Test of getLeaf method, of class GameCharacter.
     */
    @Test
    public void testGetLeaf() {
        
       assertEquals(leaf1, char1.getLeaf()); 
        
    }

    /**
     * Test of isInGame method, of class GameCharacter.
     */
    @Test
    public void testIsInGame() {
        
        GameCharacter charl1 = new GameCharacter(CharacterType.CHR_FROG);
        
        char1.setLeaf(leaf1);
        assertTrue(char1.isInGame());
        assertFalse(charl1.isInGame());
        
    }

    /**
     * Test of getHopDestination method, of class GameCharacter.
     */
    @Test
    public void testGetHopDestination() {
        
        assertEquals(leaf2, char1.getHopDestination());
        
    }

    /**
     * Test of getJumpDestination method, of class GameCharacter.
     */
    @Test
    public void testGetJumpDestination() {
        
        assertEquals(leaf5, char2.getJumpDestination());
        
    }

    /**
     * Test of canHop method, of class GameCharacter.
     */
    @Test
    public void testCanHop() {
        
        assertTrue(char1.canHop());
        assertFalse(char2.canHop());
        assertFalse(char3.canHop());
        
    }

    /**
     * Test of canJump method, of class GameCharacter.
     */
    @Test
    public void testCanJump() {
        
        assertFalse(char1.canJump());
        assertTrue(char2.canJump());
        assertTrue(char3.canJump());
        
    }

    /**
     * Test of canMove method, of class GameCharacter.
     */
    @Test
    public void testCanMove() {
        
        assertTrue(char1.canMove());
        assertTrue(char2.canMove());
        assertTrue(char3.canMove());
        
    }

    /**
     * Test of getMove method, of class GameCharacter.
     */
    @Test
    public void testGetMove() {
        
        assertEquals(leaf2, char1.getMove());
        assertEquals(leaf5, char2.getMove());
        
    }

    /**
     * Test of move method, of class GameCharacter.
     */
    @Test
    public void testMove() {
        
        assertTrue(char1.move());
        assertEquals(leaf2, char1.getLeaf());
        
        assertTrue(char2.move());
        assertEquals(leaf5, char2.getLeaf());
        
    }
    
}
