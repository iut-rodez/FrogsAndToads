package info1.game.frogsandtoads.element;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests info1.game.frogsandtoads.element.Leaf
 * 
 * @author INFO1
 */
public class LeafTest {
    
    // Fixture
    private Leaf leaf1;
    private Leaf leaf2;
    private Leaf leaf3;
    
    /**
     * Set up the fixture
     */
    @Before
    public void setUp() {
    
        leaf1 = new Leaf(null);
        leaf2 = new Leaf(leaf1);
        leaf3 = new Leaf(leaf2);
        
    }

    /**
     * Test of next method, of class Leaf.
     */
    @Test
    public void testNext() {
        
        assertEquals(leaf2, leaf1.next());
        assertEquals(leaf3, leaf2.next());
        assertEquals(null, leaf3.next());
        
    }

    /**
     * Test of previous method, of class Leaf.
     */
    @Test
    public void testPrevious() {
        
        assertEquals(leaf2, leaf3.previous());
        assertEquals(leaf1, leaf2.previous());
        assertEquals(null, leaf1.previous());
        
    }

    /**
     * Test of isFirst method, of class Leaf.
     */
    @Test
    public void testIsFirst() {
        
        assertTrue(leaf1.isFirst());
        assertFalse(leaf2.isFirst());
        assertFalse(leaf3.isFirst());
        
    }

    /**
     * Test of isLast method, of class Leaf.
     */
    @Test
    public void testIsLast() {
        
        assertTrue(leaf3.isLast());
        assertFalse(leaf2.isLast());
        assertFalse(leaf1.isLast());
        
    }

}
