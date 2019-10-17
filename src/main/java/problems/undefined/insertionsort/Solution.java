package problems.undefined.insertionsort;

import java.util.ArrayList;

public class Solution {

    public static int[] insertionSortImperative(int[] input) {

        for (int i = 1; i < input.length; i++) {
            int key = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] < key) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = key;
        }

        return input;

    }

}
