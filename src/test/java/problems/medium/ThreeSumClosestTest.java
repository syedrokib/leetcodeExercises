package problems.medium;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class ThreeSumClosestTest {

    @Test
    public void test() {
        int[] nums = {-1, 2, 1, -4};
        assertNull(ThreeSumClosest.threeSumClosest(nums, 0));
    }
}