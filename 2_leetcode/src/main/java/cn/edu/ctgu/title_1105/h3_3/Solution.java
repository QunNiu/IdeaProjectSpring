package cn.edu.ctgu.title_1105.h3_3;

import java.util.HashMap;

/**
 * @author NiuQun
 * @date 2021/11/5
 */
public class Solution {
    public static void main(String[] args) {
        String s = "aaaa";
        String s1 = "pwwkew";
        String s2 = "";
        String s3 = "abba";
        String s4 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring1(s4));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int max = 1;

        for (int i = 0; i < s.length(); i++) {
            int temp = 0;
            HashMap hashMap = new HashMap<Character, Integer>();
            for (int j = i; j < s.length(); j++) {
                if (hashMap.containsKey(s.charAt(j))) {
                    break;
                } else {
                    hashMap.put(s.charAt(j), j);
                    temp++;
                }
            }
            max = Math.max(max, temp);
        }
        return max;
    }

    public static int lengthOfLongestSubstring1(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        // HashMap用于存放快指针已经读取过字符
        HashMap<Character, Integer> hashMap = new HashMap<>();
        // 慢指针
        int slow = 0;
        // 快指针
        int fast = 0;
        // 不重复子串的最大长度
        int max = 1;
        while (fast < s.length()) {
            // 如果快指针指向的字符在之前已经出现过，就要把慢指针移动到最近一次出现的该字符的位置的下一位
            if (hashMap.containsKey(s.charAt(fast))) {
                // 例如abba，当fast=2， slow=2时，fast+1 = 3，那么此时判断之前出现过a,
                // 正确的做法是，只有当之前出现a的位置的索引 > 当前慢指针的索引，那么才将慢指针移动到
                // 最近一次出现的该字符的位置的下一位,否则不需要移动慢指针，不然会出现慢指针倒退情况
                // 比如，这里慢指针应当依旧是slow=2（即使fast=3时，发现之前已经出现过a,但是由于在2个a之间有其它重复的字母）
                int location = hashMap.get(s.charAt(fast));
                if (location >= slow) {
                    slow = location + 1;
                }
            }
            // 不论怎样，每次都保证fast指针向后移动一位,同时将快指针指向的字符保存值hashMap中，
            // 如果出现与之前相同的字符，则直接刷新value值即可，因为我们只需要知道离fast指针指向的字母左侧
            // 最近的那个相同的字符即可
            // 这个slow与fast之间的区域就是当下的一个不重复子串，当我们找到所有的不重复子串后，就可以知道哪个子串长度最长
            hashMap.put(s.charAt(fast), fast);
            // 每次判断当前的这个不重复子串是否最长
            max = Math.max(max, fast-slow+1);
            // fast++后可能导致fast指向s字符串的末尾的下一位,所以该语句应当放在最后一位
            fast++;
        }
        return max;
    }
}
