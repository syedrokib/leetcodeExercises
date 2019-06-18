package problems.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static problems.medium.FractionAddition.fractionAddition;

public class FractionAdditionTest {

    @Test
    public void negativeAnswers() {
        assertEquals("-356/45", fractionAddition("-1/2+1/2-55/9-9/5"));
        assertEquals("-55/9", fractionAddition("9/5-1/2+1/2-55/9-9/5"));
        assertEquals("-1401/280", fractionAddition("1/3-7/1+3/8+3/5+7/10+3/4-10/7-3/1+5/3+2/1"));

    }

    @Test
    public void zero() {
        assertEquals("0/1", fractionAddition("-1/2+1/2"));
        assertEquals("0/1", fractionAddition("1/2-1/2"));
        assertEquals("0/1", fractionAddition("0/6-0/44"));
        assertEquals("0/1", fractionAddition("-0/6-0/44+0/444"));
        assertEquals("1/1", fractionAddition("-0/6-0/44+0/444+5/5"));
    }

    @Test
    public void positiveAnswers() {
        assertEquals("1/1", fractionAddition("-0/6-0/44+0/444+5/5"));
        assertEquals("149/148", fractionAddition("3/444+5/5"));
        assertEquals("2/1", fractionAddition("2/5+1/5+7/10+1/5+1/2"));
    }
}