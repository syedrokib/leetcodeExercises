package problems.undefined.reversearray;

public class Solution {
    public int[] reverseArray(int[] a) {


        for (int i = 0; i < a.length / 2; i++) {

            int thisEntry = a[i];
            int toSwap = a[a.length - 1 - i];

            a[i] = toSwap;
            a[a.length - 1 - i] = thisEntry;
        }

        return a;

    }
}
