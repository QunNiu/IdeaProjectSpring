package cn.edu.ctgu.basic_knapsackProblem;

import java.util.Arrays;

/**
 * 多重背包：朴素算法
 * @author NiuQun
 * @date 2021/11/4
 */
public class KnapsackProblem5 {
    public static void main(String[] args) {
        // 每个物品的价值
        int[] val = {20, 50, 50, 30, 20};
        // 每个物品的重量
        int[] w = {80, 40, 30, 40, 20};

        int[] s = {4, 9, 7, 6, 1};
        // 物品的个数
        int n = 5;
        // 背包的最大容量
        int m = 1000;

        //
        int[] v = new int[m+1];

        for (int i = 1; i <= n; i++) {
            // 当背包的容量 >= 物品i的重量时，才考虑放入某些个物品i
            for (int j = m; j >=  w[i-1]; j--) {
                // 尝试放入多个物品i, 但是要保证物品i的个数不超过s[i-1]个，并且物品i的个数不能超过j/w[i-1]
                for (int k = 0; k <= s[i-1] && k <= j/w[i-1]; k++) {
                    v[j] = Math.max(v[j], v[j-k*w[i-1]] + k*val[i-1]);
                }
            }
            System.out.println(Arrays.toString(v));

        }
        System.out.println(v[m]);
    }
}
