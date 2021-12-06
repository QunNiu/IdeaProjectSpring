package cn.edu.ctgu.basic_knapsackProblem;

/**
 * 完全背包：和本条数据相比较， 0-1背包是和上一条数据相比较
 * 使用一位数组简化空间复杂度
 * @author NiuQun
 * @date 2021/11/4
 */
public class KnapsackProblem4 {
    public static void main(String[] args) {
        // 每个物品的价值
        int[] val = {1, 3, 5, 9};
        // 每个物品的重量
        int[] w = {2, 3, 4, 7};
        // 物品的个数
        int n = 4;
        // 背包的最大容量
        int m = 10;

        int[] v = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            // 新增若干个物品i
            // 完全背包需要顺序推导，用到的是增加了物品i时的新数据
            for (int j = 1; j <= m; j++) {
                // 如果背包装得下至少1个物品i，就可以不断尝试装入多个物品i
                if (j >= w[i-1]) {
                    v[j] = Math.max(v[j], v[j-w[i-1]] + val[i-1]);
                }
            }
        }
        /*
        // 可以简化为：
        for (int i = 1; i <= n; i++) {
            // 新增若干个物品i
            // 完全背包需要顺序推导，用到的是增加了物品i时的新数据
            for (int j = w[i-1]; j <= m; j++) {
                // 如果背包装得下至少1个物品i，就可以不断尝试装入多个物品i
                v[j] = Math.max(v[j], v[j-w[i-1]] + val[i-1]);
            }
        }
         */
        System.out.println(v[m]);

    }
}
