package cn.edu.ctgu.basic_knapsackProblem;

/**
 * 完全背包:朴素算法
 * @author NiuQun
 * @date 2021/11/4
 */
public class KnapsackProblem2 {
    public static void main(String[] args) {
        // 每个物品的价值
        int[] val = {1, 3, 5, 9};
        // 每个物品的重量
        int[] w = {2, 3, 4, 7};
        // 物品的个数
        int n = 4;
        // 背包的最大容量
        int m = 10;

        int[] v = new int[m+1];

        // 按照0-1背包的思路来解决
        for (int i = 1; i <= n; i++) {
            // 每次增加[0, j/w[i-1]个物品i可选
            for (int j = m; j >= w[i-1]; j--) {
                for (int k = 0; k <= j / w[i - 1]; k++) {
                    v[j] = Math.max(v[j], k*val[i-1] + v[j-k*w[i-1]]);
                }
            }
        }
        System.out.println(v[m]);
    }
}
