package cn.edu.ctgu.title_1105.h4_1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author NiuQun
 * @date 2021/11/6
 */
public class Solution {
    /**
     * HashMap方式解法
     * @param nums
     * @param target
     * @return
     */
    public  static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target-nums[i])) {
                return new int[]{hashMap.get(target-nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

    /**
     * 如果给的数组的nums是有序的，那么可以采用双指针的方式
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int slow = 0;
        int fast = nums.length;
        Arrays.sort(nums);
        while (slow < fast) {
            if (nums[slow] + nums[fast] == target) {
                return new int[]{slow, fast};
            } else if (nums[slow] + nums[fast] < target) {
                slow++;
            } else {
                fast--;
            }
        }
        return null;
    }

}
