package cn.edu.ctgu.title_1107.h3_7;

/**
 * @author NiuQun
 * @date 2021/11/7
 */
public class Solution {
    public int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            if(reverse < Integer.MIN_VALUE/10 || reverse > Integer.MAX_VALUE/10) {
                return 0;
            }
            reverse = reverse * 10 + x % 10;
            x = x /10;

        }
        return reverse;
    }

    public int reverse1(int x) {
        int reverse = 0;
        while (x != 0) {
            int temp = reverse * 10 + x % 10;
            if (temp/10 != reverse) {
                return 0;
            }
            reverse = temp;
            x = x/10;
        }
        return reverse;
    }

}
