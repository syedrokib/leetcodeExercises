package problems.medium;

import java.util.HashMap;

//https://leetcode.com/problems/fraction-addition-and-subtraction/
class ThreeSumClosest {

    static String threeSumClosest(int[] nums, int target) {

        // map sum of pairs -> to pairs

        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.put(nums[i] + nums[j], new int[]{nums[i], nums[j]});
            }
        }

        for (int num : nums) {
            // find best sum in map that would get this num closest to target

        }

        System.out.println(map);
        return null;
    }

}