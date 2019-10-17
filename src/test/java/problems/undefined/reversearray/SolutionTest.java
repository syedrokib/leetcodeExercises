package problems.undefined.reversearray;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void name() {
        assertArrayEquals(new int[]{0, 8, 9, 0}, new Solution().reverseArray(new int[]{0, 9, 8, 0}));
    }
}