package problems.medium;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.medium.FractionAddition.fractionAddition;

public class FractionAdditionTest {

    @Test
    public void test() {
        assertNull(fractionAddition("-1/2+1/2-55/9-9/5"));
        assertNull(fractionAddition("9/5-1/2+1/2-55/9-9/5"));
    }
}