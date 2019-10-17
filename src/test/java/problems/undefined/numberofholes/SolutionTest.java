package problems.undefined.numberofholes;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void name() {
        assertEquals(1, new Solution().numberOfHoles(0));
        assertEquals(0, new Solution().numberOfHoles(1));
        assertEquals(12, new Solution().numberOfHoles(1000000888));


    }
}