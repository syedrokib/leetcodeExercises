package problems.medium.threesumclosest;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/3sum-closest/
class ThreeSumClosest {

    static int threeSumClosest(int[] nums, int target) {

        HashMap<Integer, int[]> sumsOfPairs = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sumsOfPairs.put(nums[i] + nums[j], new int[]{nums[i], nums[j], i, j});
            }
        }

        int champion = Integer.MAX_VALUE;
        int totalOfChampion = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int requiredDifference = target - num;
            if (sumsOfPairs.containsKey(requiredDifference) && !isIndexReused(i, sumsOfPairs.get(requiredDifference)))
                return target;   // True -> there exists 3 different numbers in the array that add to the given target.

            for (Map.Entry<Integer, int[]> entry : sumsOfPairs.entrySet()) {
                // Try and find two other numbers that can be used in conjunction with this number to get as close as possible to the target.
                if (isIndexReused(i, entry.getValue())) continue;   // Skip invalid combination.
                int sum = entry.getKey();
                int challenger = Math.abs(target - (nums[i] + sum));
                if (challenger < champion) {
                    champion = challenger;
                    totalOfChampion = sum + nums[i];
                }
            }
        }
        return totalOfChampion;
    }

    private static boolean isIndexReused(int index, int[] pair) {
        int firstIndex = pair[2];
        int secondIndex = pair[3];
        return firstIndex == index || secondIndex == index;
    }
}