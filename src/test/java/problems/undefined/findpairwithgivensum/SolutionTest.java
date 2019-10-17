package problems.undefined.findpairwithgivensum;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void name() {
        assertArrayEquals(new int[]{2, 3}, new Solution().findPair(new int[]{1, 10, 25, 35, 60}, 90));
        assertArrayEquals(new int[]{1, 5}, new Solution().findPair(new int[]{20, 50, 40, 25, 30, 10}, 90));
    }
}