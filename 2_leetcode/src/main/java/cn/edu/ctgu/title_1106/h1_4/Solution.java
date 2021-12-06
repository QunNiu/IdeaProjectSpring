package cn.edu.ctgu.title_1106.h1_4;

import java.util.Arrays;

/**
 * @author NiuQun
 * @date 2021/11/6
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2, 4, 6};
        System.out.println(findMedianSortedArrays1(nums1, nums2));
    }
    /**
     * 先合并再排序
     * 时间复杂度:O（m+n）
     * 空间复杂度:O（m+n）
     * 由于只需要查找中位数，我们并不需要另外开辟一个数组真的把两个数组合并并排序
     * 我们只需要找到找到中位数即可（奇数是第(m+n+1)/2个，偶数是(m+n）/2个 和 (m+n)/2+1个的平均值）
     * 可以合并为都查找第（m+n+1）/2个 和 第(m+n+2)/2个数字的平均数
     * 或者第m+（n-m+1）/2个 和 m+（n-m+2）/2个的平均数， 令n>=m
     * 这样时间复杂度：O(m+n)， 空间复杂度：O(1)
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < nums1.length) {
            nums[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            nums[k] = nums2[j];
            j++;
            k++;
        }

        // 如果合并后的有序数组是偶数个，则取中间两个数的平均数
        if (nums.length % 2 == 0) {
            return ((double)nums[nums.length/2] + nums[nums.length/2 - 1]) / 2;

        } else {
            // 如果合并后的有序数组是奇数个，则取中间的那个数
            return nums[nums.length/2];
        }
    }

    /**
     * 二分查找思想
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 这里是为了将m+n是奇数或偶数的两种情况合并
        double i =  findKthNumber(nums1, 0, m-1, nums2, 0, n-1, (m+n+1)/2);
        double j =  findKthNumber(nums1, 0, m-1, nums2, 0, n-1, (m+n+2)/2);
        return (i+j)/2;
    }

    /**
     * 用于查找num1 和num2中第k大的数据
     * @param nums1
     * @param left1
     * @param right1
     * @param nums2
     * @param left2
     * @param right2
     * @param k
     * @return
     */
    public static double findKthNumber(int[] nums1, int left1, int right1,
                                       int[] nums2, int left2, int right2, int k) {
        // 数组1有效长度
        int nums1Length = right1 - left1 + 1;
        // 数组2有效长度
        int nums2Length = right2 - left2 + 1;

        // 如果nums1中的有效长度 > nums2中的有效长度,则调换两者位置，确保nums1的有效长度 始终<= nums2的有效长度
        // 保证最后如果有数组为空，则一定是nums1
        if (nums1Length > nums2Length) {
            return findKthNumber(nums2, left2, right2, nums1, left1, right1, k);
        }

        // 递归出口
        // 如果当数组1的有效长度为0，则肯定是可以在nums2中直接找到第k大的数
        if (nums1Length == 0) {
            return nums2[left2 + k - 1];
        }
        // 如果需要查找两个数组中的最小的一个数据，则该数据肯定是两个数组中最小的那个数据中较小的一个
        if (k == 1) {
            return Math.min(nums1[left1], nums2[left2]);
        }

        // 如果没有达到递归出口，且nums1的有效长度 <= nums2的长度
        // 这是真正的递归体
        // i表示nums1中第 k/2个有效元素的索引，因为可能在递归的过程中，
        // 导致某个数组有效部分过短（但是该数组有效长度一定>=1, 因为如果=0,那么就在前边直接返回结果了，不可能到达这里），
        // 而不存在第k/2个有效元素
        // 总之就是保证，如果nums1中有效长度如果 小于 k/2, 那么就让k/2指针指向最右边的那个有效数据
        int i = left1 + Math.min(nums1Length, k/2) - 1;
        // j表示nums2中第 k/2个有效元素的索引, ......
        int j = left2 + Math.min(nums2Length, k/2) - 1;

        // 如果nums1中的第k/2个有效元素 < nums2中的第k/2个有效元素，
        // 则表明第k大个元素一定不在 nums1中的前k/2个有效元素中,
        if (nums1[i] < nums2[j]) {
            // 表示nums1中的前k/2个（不一定是k/2个，因为有可能原本有效元素个数就小于k/2，）有效元素排除
            return findKthNumber(nums1, i+1, right1, nums2, left2, right2, k-Math.min(nums1Length, k/2));
        } else {
            // 表示nums2中的前k/2个（不一定是k/2个，因为有可能原本有效元素个数就小于k/2，）有效元素排除
            return findKthNumber(nums1, left1, right1, nums2, j+1, right2, k-Math.min(nums2Length, k/2));
        }
    }
}
