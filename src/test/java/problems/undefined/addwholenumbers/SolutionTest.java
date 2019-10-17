package problems.undefined.addwholenumbers;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void name() {
        System.out.println(Integer.valueOf("+4"));
        assertEquals(0, new Solution().add("10+4-3-22-2123+0+0+2134"));
    }
}