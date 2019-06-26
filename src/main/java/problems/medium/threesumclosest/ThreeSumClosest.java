package problems.medium.threesumclosest;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/fraction-addition-and-subtraction/
class ThreeSumClosest {

    static int threeSumClosest(int[] nums, int target) {

        // map sum of pairs -> to pairs

        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.put(nums[i] + nums[j], new int[]{nums[i], nums[j], i, j});
            }
        }

        int min = Integer.MAX_VALUE;
        int total = 0;

        for (int i = 0; i < nums.length; i++) {

            //one pass to see if nums has 3 numbers that add to target
            //indicates that there exists two numbers with sum as key
            //that can be added to i to form an array
            int thisnum = nums[i];
            int diff = target - thisnum;
            if (map.containsKey(diff)) {
                int[] ints = map.get(diff);
//                System.out.println();

                // check for repetition
                if (ints[2] != i && ints[3] != i) {
//                    System.out.println();
                    return target;
                }
            }

            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {

                Integer thiskey = entry.getKey();
                int[] value = entry.getValue();

                int targetDiff = Math.abs(target - (thisnum + thiskey));

                if (targetDiff < min && value[2] != i && value[3] != i) {
                    min = targetDiff;
                    total = thisnum + thiskey;
                }
            }
        }
        return total;
    }

}