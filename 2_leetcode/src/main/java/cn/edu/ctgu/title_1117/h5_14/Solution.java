package cn.edu.ctgu.title_1117.h5_14;

import java.util.*;

/**
 * @author NiuQun
 * @date 2021/11/7
 */
class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        new HashMap<>();
    }

    /**
     * 1.横向扫描法
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        String result = strs[0];

        for (int i = 1; i < strs.length; i++) {
            result = lcp(result, strs[i]);
            if ("".equals(result)) {
                return "";
            }
        }
        return result;
    }

    /**
     * 获取字符串str1和str2的最长公共前缀
     * @param str1
     * @param str2
     * @return
     */
    public static String lcp(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                result.append(str1.charAt(i));
            } else {
                break;
            }
        }
        return result.toString();
    }

    /**
     * 2.纵向扫描法
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            // 取第一个字符串的第i个字符
            char ch = strs[0].charAt(i);

            // 如果第一个字符串的第i个字符和后边每一个字符串的第i个字符相同，
            // 则该字符属于最长公共前缀的一部分，一旦某一个不同，则终止
            // 只有第一个字符串的该字符的前边部分是最长公共前缀
            for (int j = 1; j < strs.length; j++) {
                // 1.遍历到某个字符不符合时应当结束
                // 2.如果后边的某个字符串比第一个字符串短，那么当该字符遍历完后应当结束
                if (ch != strs[j].charAt(i) || i == strs[j].length()) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
