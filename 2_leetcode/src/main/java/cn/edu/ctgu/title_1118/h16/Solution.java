package cn.edu.ctgu.title_1118.h16;

import java.util.Arrays;

/**
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 输入：[-3, -2, -5, 3, -4], -1
 * 输出：-2
 *
 * @author NiuQun
 * @date 2021/11/18
 */
public class Solution {
    public static void main(String[] args) {
        // int[] nums = {-1,2,1,-4};
        int[] nums = {-3, -2, -5, 3, -4};
        int target = -1;
        System.out.println(threeSumClosest(nums, target));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // 用result来保存最后的结果
        int result = 4000;

        for (int i = 0; i <= nums.length-3; i++) {
            // 取出重复判断的情况
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i+1;
            int right = nums.length-1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return target;
                }
                // 根据差值来更新答案
                // 如果当前三个数的和sum更加接近target，就更新result为sum
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }

                // 如果当前三个数之和小于target，则尝试让left指针右移，扩大三数之和，来尝试找到更接近target的三个数
                if (sum < target) {
                    left++;
                    // 此时为了保证不必要的重复运算，我们需要将left指针移动到下一个与原值不等的位置
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                } else {
                    right--;
                    while (left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
