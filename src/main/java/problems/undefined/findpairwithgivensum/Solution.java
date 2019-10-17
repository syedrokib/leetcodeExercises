package problems.undefined.findpairwithgivensum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] findPair(int[] a, int target) {

        target -= 30;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) map.put(a[i], i);

        int[] result = new int[2];

        for (int i = 0; i < a.length; i++) {

            int diff = target - a[i];

            if (map.containsKey(diff)) {

                int[] r = new int[2];

                r[0] = Math.min(diff, a[i]);
                r[1] = Math.max(diff, a[i]);

                if (r[1] > result[1]) result = r;
            }
        }

        int firstIndex = map.get(result[0]);
        int secondIndex = map.get(result[1]);

        if (firstIndex < secondIndex) return new int[]{firstIndex, secondIndex};
        return new int[]{secondIndex, firstIndex};
    }
}
