package problems.undefined.twosumuniquepairs;

import java.util.*;

public class Solution {

    public int twoSum(int[] nums, int target) {


        Map<Integer, Boolean> map = new HashMap<>();
        int pairs = 0;

        for (int i = 0; i < nums.length; i++) {

            int difference = target - nums[i];

            if (map.containsKey(difference)) {

                if (!map.get(difference)) {
                    pairs++;
                    map.put(difference, true);
                }

                map.put(nums[i], true);

            } else {
                map.put(nums[i], false);
            }

        }
        return pairs;

//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
//            else map.put(nums[i], 1);
//        }
//
//        Set<List<Integer>> set = new HashSet<>();
//
//        for (int i = 0; i < nums.length; i++) {
//
//            int difference = target - nums[i];
//
//            if (map.containsKey(difference)) {
//                if (difference == nums[i] && map.get(nums[i]) < 2) continue;
//                if (difference < nums[i]) set.add(Arrays.asList(difference, nums[i]));
//                else set.add(Arrays.asList(nums[i], difference));
//
//
//            }
//        }
//        System.out.println(set);
//        return set.size();
    }
}
