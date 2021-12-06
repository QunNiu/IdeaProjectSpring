package cn.edu.ctgu.title_1118.h15;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author NiuQun
 * @date 2021/11/18
 */
public class Solution {
    public static void main(String[] args) {
        // 输入：nums = [-1,0,1,2,-1,-4]
        // 输出：[[-1,-1,2],[-1,0,1]]
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum2(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    /**
     * 双指针法
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // 剩下两数之和为sum
            // 我们需要在num[i]右侧的元素中找到和为sum的两个数
            int sum = -nums[i];

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    ArrayList<Integer> innerList = new ArrayList<>();
                    innerList.add(nums[i]);
                    innerList.add(nums[left]);
                    innerList.add(nums[right]);
                    hashSet.add(innerList);
                    left++;
                } else if (nums[left] + nums[right] > sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return new ArrayList<>(hashSet);
    }

    /**
     * 双指针法改进
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 数组长度小于3的话，返回结果为null
        if (nums.length < 3) {
            return result;
        }

        // 排序后使用双指针法
        Arrays.sort(nums);
        // 如果排序后，第一个数>0, 则说明所有的数都 >0, 则返回结果肯定为null
        if (nums[0] > 0) {
            return result;
        }
        for (int i = 0; i <= nums.length - 3; i++) {
            // 不需要对数值相同的数做多次查找
            // 避免重复结果出现
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 剩下两数之和为sum
            // 我们需要在num[i]右侧的元素中找到和为sum的两个数
            int sum = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // 避免重复结果出现
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                    // 避免重复结果出现
                    while (nums[right] == nums[right + 1] && left < right) {
                        right--;
                    }
                } else if (nums[left] + nums[right] > sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    /**
     * 哈希表法
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 如果nums长度 < 3, 返回的结果肯定为null
        if (nums.length < 3) {
            return result;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // 排序是为了方便去重
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i <= nums.length-3; i++) {
            int target = -nums[i];
            Integer t = 0;
            // 去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i+1; j <= nums.length-2; j++) {
                // 去重
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                // 保证在hashMap中找到第三个数
                if (hashMap.containsKey(target - nums[j])) {
                    // 在找到第三个数的情况下，如果能保证第三个数在第二个数的右边，则是正确的结果，否则就是重复的结果
                    if (hashMap.get(target - nums[j]) > j) {
                        result.add(Arrays.asList(nums[i], nums[j], target-nums[j]));
                    } else {
                        // 如果找到的第三个数在第二个数的左边，那么这种情况就是重复的结果
                        // 下一次循环，j往右移动，那么第二个数增大，相应的第三个数肯定要减小，
                        // 即使找到了第三个数，那么第三个数的索引也一定在第二个数的左边，所以，这里不需要再继续移动第二个数了
                        break;
                    }
                }
                // 如果在hashMap中没有找到第三个数，则进入下一次循环，将第二个数后移一位

                // 总结：在hashMap中找第三个数分为三种情况：
                // 1.压根就找不到第三个数，直接进入下次循环，将第二个数后移一位
                // 2.如果找到第三个数，但是第三个数在第二个数左边或者就是第二个数，那么不符合约定，
                //   显然我们需要进入下次循环，将第二个数后移一位；但是特殊的是，由于此时第三个数 在第二个数 左边
                //   那么将第二个数后移一位后，第二个数增大（前边保证了第二个数不重复判断），那么第三个数肯定要减小，
                //   即使找到第三个数，那么第三个数的索引肯定在第二个数的左边；综上，此后的第二个数就不需要再判断了
                // 3.如果找到第三个数，并且第三个数在的第二个数的右边，那么就符合约定，该结果存入集合
            }
        }
        return result;
    }
}
