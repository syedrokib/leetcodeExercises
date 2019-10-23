package problems.undefined.numberscore;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

//Find the score for each number, you got points for:
//        +1 for number divisible by 7
//        +2 for even digits
//        +4 for each 9
//        +5 for 2 consecutive 1 and +5 for each consecutive followine one
//        +N2 for every continous sequnce of the form 123 or 4567 of length N

public class Solution {

    @Test
    public void test() {
//        assertEquals(0, numberScore(99992));
//        assertEquals(20, numberScore(113113111));
//        assertEquals(35, numberScore(1111111211));
        assertEquals(35, numberScore(123493212));
    }

    public int numberScore(int num) {

        int score = 0;
        if (num % 7 == 0) score++;

        score += digitScore(num);
        score += countOnes(num);
        score += increasingSequence(num);


        return score;
    }

    private int increasingSequence(int num) {

        String n = String.valueOf(num);
        ArrayList<Integer> lengths = new ArrayList<>();

        int length = 1;
        for (int i = 1; i < n.length(); i++) {

            int thisDigit = (int) n.charAt(i);
            int prevDigit = (int) n.charAt(i - 1);

            if (thisDigit == prevDigit + 1) length++;
            else {
                lengths.add(length);
                length = 1;
            }
        }

        lengths.add(length);

        int score = 0;
        for (Integer l : lengths) score += l * l;

        return score;
    }

    private int countOnes(int num) {

        int score = 0;
        int numOnes = 0;

        while (num != 0) {
            int digit = num % 10;

            if (digit == 1) numOnes++;
            else {
                if (numOnes == 2) score += 5;
                if (numOnes >= 3) score += 5 + (5 * (numOnes - 2));
                numOnes = 0;
            }
            num /= 10;
        }

        if (numOnes == 2) score += 5;
        if (numOnes >= 3) score += 5 + (5 * (numOnes - 2));

        return score;
    }

    private int digitScore(int num) {

        int score = 0;

        while (num != 0) {

            int digit = num % 10;

            if (digit % 2 == 0) score += 2;
            if (digit == 9) score += 4;

            num /= 10;
        }

        return score;
    }
}
