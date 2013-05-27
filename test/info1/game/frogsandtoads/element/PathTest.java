package info1.game.frogsandtoads.element;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests info1.game.frogsandtoads.element.Path
 * 
 * @author INFO1
 */
public class PathTest {
    
    // Fixture
    private Path path1;
    
    /**
     * Set up fixture
     */
    @Before
    public void setUp() {
        
        path1 = new Path(5);
        
    }
    
    /**
     * Test of getLeaf method, of class Path.
     */
    @Test
    public void testGetLeaf() {
        
        for (int i = 0; i < path1.getLength(); ++i) {
            
            assertNotNull(path1.getLeaf(i));
            
        }
        
    }

    /**
     * Test of getFirst method, of class Path.
     */
    @Test
    public void testGetFirst() {
        
        Leaf leaf = path1.getFirst();
        
        assertTrue(leaf.isFirst());
        
    }

    /**
     * Test of getLast method, of class Path.
     */
    @Test
    public void testGetLast() {
        
        Leaf leaf = path1.getLast();
        
        assertTrue(leaf.isLast());
        
    }
}
