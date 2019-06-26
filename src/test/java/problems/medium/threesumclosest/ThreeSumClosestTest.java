package problems.medium.threesumclosest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static problems.medium.threesumclosest.ThreeSumClosest.threeSumClosest;

public class ThreeSumClosestTest {

    @Test
    public void exactSum() {
        assertEquals(2, threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}