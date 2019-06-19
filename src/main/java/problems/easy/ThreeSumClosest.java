package problems.easy;

import java.util.HashMap;

//https://leetcode.com/problems/fraction-addition-and-subtraction/
public class ThreeSumClosest {

    static String threeSumClosest(int[] nums, int target) {

        // map sum of pairs -> to pairs

        HashMap<Integer, int[]> map = new HashMap<>();


        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                map.put(nums[i] + nums[j], new int[]{nums[i], nums[j]});


        System.out.println(map);
        return null;
    }

}
