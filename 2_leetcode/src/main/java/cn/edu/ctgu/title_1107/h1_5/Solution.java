package cn.edu.ctgu.title_1107.h1_5;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 最长回文字符串
 * @author NiuQun
 * @date 2021/11/7
 */
public class Solution {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome1(s));
    }

    /**
     * 动态规划算法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int length = s.length();
        // 如果字符串为空，则该字符串的最长回文字符串为它本身
        // 如果字符串长度为1，则该字符串的最长回文字符串为它本身
        if (length < 2) {
            return s;
        }

        // dp[i][j]>=1表示索引为i到索引为j之间是回文字符串,且长度为dp[i][j]，
        // dp[i][j]=0表示索引为i到索引为j之间不是回文字符串
        int[][] dp = new int[length][length];

        // 保证最开始所有的都还没有初始化
        for (int i = 0; i < length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int max = 0;
        int left = 0;
        int right = 0;
        // 判断长度为1~s.length()的子串是否是回文字符串
        for (int l = 1; l <= length; l++) {
            // 对字符串s中的每一个字符进行判断
            // i为子串的左索引，通过子串长度l可以得到子串的右索引j
            for (int i = 0; i < length; i++) {
                int j = i+l-1;
                // 如果右索引越界，则结束本次循环
                if (j>=length) {
                    break;
                }

                // 1.长度为1的子串一定是回文字符串，且回文字符串长度为1
                if (l == 1) {
                    dp[i][j] = 1;
                } else if (l == 2) {
                    // 2.长度为2的子串，如果两个字符相同，则它是回文字符串，且长度为2
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2;
                        dp[j][i] = 2;
                    }else {
                        dp[i][j] = 0;
                        dp[j][i] = 0;
                    }
                } else {
                    // 状态转移方程：
                    // 长度为3的子串需要根据长度为1的子串来判断
                    // 长度为4的子串需要根据长度为2的子串来判断
                    // 长度为5的子串需要根据长度为3的子串来判断
                    // 长度为l的子串需要根据长度为l-2的子串来判断
                    // 得出结论：长度为1的子串必须初始化，长度为2的子串必须手动初始化
                    // 长度为3~s.length()的子串可以根据状态转移方程得出结果
                    if (dp[i+1][j-1] > 0 && (s.charAt(i) == s.charAt(j))) {
                        dp[i][j] = dp[j][i] = dp[i+1][j-1]+2;
                    } else {
                        dp[i][j] = dp[j][i] = 0;
                    }
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                    left = i;
                    right = j;
                }
            }
        }

        // 打印dp数组
        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println("left=" + left);
        System.out.println("right=" + right);
        return s.substring(left, right+1);
    }

    /**
     * 中心扩展算法
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        int maxLength = 1;
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            int length1 = expand(s, i, i);
            int length2 = expand(s, i, i+1);
            int length = Math.max(length1, length2);
            // 现在我们知道回文字符串的中心索引是i或者i,i+1，对应的长度分别是length1，length2

            // 如果length是奇数，则回文字符串中心索引肯定是i,长度是length1，
            // 那么左索引是i-length1/2,右索引是i+length1/2;
            // 如果length是偶数，则回文字符串中心索引肯定是i,i+1，长度是length2,
            // 那么左索引是i+1-length1/2,右索引是i-1+length1/2;
            // 实际上可以统一为，左索引为i - ((length-1)/2), 右索引为i+length/2
            if (maxLength < length) {
                maxLength = length;
                left = i - ((length-1)/2);
                right = i + length/2;
            }
        }
        return s.substring(left, right+1);
    }

    public static int expand(String s, int left, int right) {
        while (left >= 0 && right <= s.length()-1 && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
        }
        return right-left-1;
    }
}

