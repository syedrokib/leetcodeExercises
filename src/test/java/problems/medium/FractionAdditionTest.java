package problems.medium;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.medium.FractionAddition.fractionAddition;

public class FractionAdditionTest {

    @Test
    public void negativeAnswers() {
        assertEquals("-356/45", fractionAddition("-1/2+1/2-55/9-9/5"));
        assertEquals("-55/9", fractionAddition("9/5-1/2+1/2-55/9-9/5"));
    }

//    @Test
//    public void zero() {
//        assertEquals("0/1", "-1/2+1/2");
//    }
}