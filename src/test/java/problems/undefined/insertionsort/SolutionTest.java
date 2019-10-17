package problems.undefined.insertionsort;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void name() {

        int[] array = new int[]{1, 3, 2};
        int[] sortedArray = new int[]{1, 2, 3};
        int[] rSortedArray = new int[]{3,2,1};

        assertArrayEquals(rSortedArray, Solution.insertionSortImperative(array));

    }
}