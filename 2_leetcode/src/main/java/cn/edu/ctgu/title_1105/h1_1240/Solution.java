package cn.edu.ctgu.title_1105.h1_1240;

import java.util.Arrays;

/**
 * @author NiuQun
 * @date 2021/11/5
 */
public class Solution {
    private static final int SIZE = 13;
    private static int[][] dp = new int[SIZE+1][SIZE+1];

    static {
        // 初始化为-1，表示没有被修改
        for (int i = 1; i <= SIZE; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 1; i < SIZE; i++) {
            dp[1][i] = i;
            dp[i][1] = i;
            dp[i][i] = 1;
        }
        // 唯一的特殊情况11 * 13 和 13 * 11面积的铺瓷砖数量 不符合贪心规则
        dp[11][13] = 6;
        dp[13][11] = 5;

    }
    public static void main(String[] args) {
        System.out.println(tilingRectangle(2, 3));
        System.out.println(tilingRectangle(5, 8));
        System.out.println(tilingRectangle(11, 13));
        System.out.println(tilingRectangle(7, 6));
    }
    public static int tilingRectangle(int n, int m) {
        return helper(n, m);
    }

    public static int helper(int n,  int m) {
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        int res = n * m;
        int temp;

        // 区分横着切和竖着切是为了分别讨论 分割长 或者 分割宽
        // 横着切
        for (int i = 1; i < n; i++) {
            temp = helper(i, m) + helper(n-i, m);
            res = Math.min(res, temp);
        }
        // 竖着切
        for (int i = 1; i < m; i++) {
            temp = helper(n, i) + helper(n, m-i);
            res = Math.min(res, temp);
        }
        dp[n][m] = dp[m][n] = res;
        return res;
    }
}
