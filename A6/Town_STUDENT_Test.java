import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class Town_STUDENT_Test {
    private Town town;

    @Before
    public void setUp() throws Exception
    {
        town = new Town("Minas Tirith");
    }

    @After
    public void tearDown() throws Exception
    {
        town = null;
    }

    @Test
    public void testGetName()
    {
    }

    @Test
    public void testCompareTo()
    {
    	
    }
}
