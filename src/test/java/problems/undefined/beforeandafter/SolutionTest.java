package problems.undefined.beforeandafter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void name() {

        List<String> expected = Arrays.asList(
                "a chip off the old block party",
                "a man on a mission impossible",
                "a man on a mission statement",
                "a quick bite to eat my words",
                "chocolate bar of soap"
        );
        Collections.sort(expected);


        List<String> actual = new Solution().beforeAndAfter(Arrays.asList(
                "mission statement",
                "a quick bite to eat",
                "a chip off the old block",
                "chocolate bar",
                "mission impossible",
                "a man on a mission",
                "block party",
                "eat my words",
                "bar of soap"
        ));

        Collections.sort(actual);

        assertEquals(
                expected,
                actual);
    }
}