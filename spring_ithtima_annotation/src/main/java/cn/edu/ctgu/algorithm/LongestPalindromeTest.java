package cn.edu.ctgu.algorithm;

/**
 * @author NiuQun
 * @date 2021/10/17
 */
public class LongestPalindromeTest {
    public static void main(String[] args) {

    }
    public String longestPalindrome(String s) {
        String result = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > 0; j--) {
                // 检测i 与 j之间是否是回文字符串
                if (s.charAt(i) == s.charAt(j)) {
                    int m = i+1;
                    int n = j-1;
                    while (s.charAt(m) == s.charAt(n) && m <= n) {
                        m++;
                        n--;
                    }
                    // 说明m与n之间是一个回文字符串
                    if (m < n) {
                        String temp = s.substring(i, j+1);
                        if (result.length() < temp.length()) {
                            // 该回文字符串长度大于 之前保存的回文字符串长度
                            result = temp;
                        }

                    }
                }
            }
        }
        return  result;
    }
}
