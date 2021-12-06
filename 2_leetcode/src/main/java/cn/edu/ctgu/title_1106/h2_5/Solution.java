package cn.edu.ctgu.title_1106.h2_5;

import java.util.Arrays;

/**
 * 回文字符串
 * @author NiuQun
 * @date 2021/11/7
 */
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 动态规划法：
     * @param s
     * @return
     */
    public static String longestPalindrome(String s){
        int length = s.length();
        if (length < 2) {
            return s;
        }
        // dp[i][j]表示字符串s从下标i到j是否是回文字符串，如果是，则dp[i][j]存储回文字符串的长度，
        // 如果不是，dp[i][j]值为0
        int[][] dp =  new int[length][length];

        for (int i = 0; i < length; i++) {
            Arrays.fill(dp[i], -1);
        }

        // max用于存储最长的那个回文字符串
        int max = 0;
        // left用于存储最长的回文字符串的左索引，right用于存储最长的回文字符串的右索引
        int left = 0;
        int right = 0;

        // 字符串s的子串长度从1~s.length()
        for (int l = 1; l <= length; l++) {
            // 长度为3的子串，需要根据长度为1的子串来获取结果
            // 长度为4的子串，需要根据长度为2的子串来获取结果
            // ...
            // 长度为l的子串，需要根据长度为l-2的子串来获取结果
            // 所以初始化为：l=1 和 l=2
            // 状态转换方程为dp[i+1][j-1] -->dp[i][j]
            // i为子串的左索引
            for (int i = 0; i < length; i++) {
                // j为子串的右索引，可以根据左索引和子串的长度来算出
                int j = i+l-1;
                // 子串的右索引j不能超出s的最大索引，即j<length
                if (j >= length) {
                   break;
                }
                // 初始化
                // 长度为1的子串一定是回文字符串，且回文字符串的长度为1
                if (l == 1) {
                    dp[i][j] = dp[j][i] = 1;
                    // 长度为2的子串，如果两个字符相同，那么他就是回文字符串，且长度为2
                }else if (l == 2) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[j][i] = 2;
                    } else {
                        dp[i][j] = dp[j][i] = 0;
                    }
                    // 对于长度为3~l的子串，可以由状态转化方程得出结果
                }else {
                    if (dp[i+1][j-1] > 0 && (s.charAt(i) == s.charAt(j))) {
                        dp[i][j] = dp[j][i] = dp[i+1][j-1] + 2;
                    }else {
                        dp[i][j] = dp[j][i] =  0;
                    }

                }

                // max的初始值为0，显然，如果要满足max< dp[i][j],则该子串必须是一个回文字符串，
                // 而且回文字符串长度大于之前的最长的回文字符串长度
                if (max < dp[i][j]) {
                    max = dp[i][j];
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right+1);
    }

    /**
     * 中心扩展法
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            int length1 = expand(s, i, i);
            int length2 = expand(s, i, i+1);
            int length = Math.max(length1, length2);

            if (maxLength < length) {
                maxLength = length;
                left = i - (length-1)/2;
                right = i + (length)/2;
            }
        }
        return s.substring(left, right+1);
    }

    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        return right-left-1;
    }
}
