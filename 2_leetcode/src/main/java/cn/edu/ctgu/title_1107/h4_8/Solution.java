package cn.edu.ctgu.title_1107.h4_8;

/**
 * @author NiuQun
 * @date 2021/11/7
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(myAtoi(" "));
    }

    public static int myAtoi(String s) {
        int i = 0;
        int flag = 1;
        int result = 0;

        // 忽略字符串左侧的空格
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i >= s.length()) {
            return 0;
        }
        //
        if (s.charAt(i) == '-') {
            flag = -1;
        }
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            // 将当下的这个数字字符转换成数字
            int digit = s.charAt(i) - '0';
            if (result == Integer.MAX_VALUE/10 && digit>(Integer.MAX_VALUE%10) || result > Integer.MAX_VALUE/10) {
                if (flag > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            result = result*10 + digit;
            i++;
        }
        return  result;
    }
}
