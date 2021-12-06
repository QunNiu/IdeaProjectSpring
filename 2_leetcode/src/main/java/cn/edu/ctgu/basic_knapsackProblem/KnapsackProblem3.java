package cn.edu.ctgu.basic_knapsackProblem;

/**
 * 完全背包：和本条数据相比较， 0-1背包是和上一条数据相比较
 * @author NiuQun
 * @date 2021/11/4
 */
public class KnapsackProblem3 {
    public static void main(String[] args) {
        // 每个物品的价值
        int[] val = {1, 3, 5, 9};
        // 每个物品的重量
        int[] w = {2, 3, 4, 7};
        // 物品的个数
        int n = 4;
        // 背包的最大容量
        int m = 30;

        int[][] v = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            // 新增若干个物品i
            for (int j = 0; j <= m; j++) {
                // 背包容量为j
                if (i == 0 || j == 0) {
                    v[i][j] = 0;
                } else {
                    // 当背包的容量 >= 当前物品的质量时，可以尝试放入1个物品i
                    if (j >= w[i-1]) {
                        v[i][j] = Math.max(v[i-1][j], v[i][j-w[i-1]] + val[i-1]);
                    } else {
                        // 当背包的容量 < 当前物品的质量时，无法放入当前物品，情况和i-1时一致
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }
        System.out.println(v[n][m]);
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            // 这里的j >= w[i-1]是多余的，因为假设此时背包的剩余容量j<w[i-1]，那么此时背包中是不可能装入新增的物品i的，
            // 那么背包中装入物品的情况一定和v[i-1][j]相同，即此时v[i][j] == v[i-1][j]
            // 即跳出v[i][j] > v[i-1][j]状态 和 跳出j >= w[i-1]状态的时刻是一致的
            if (v[i][j] > v[i-1][j] && j >= w[i-1]) {
                System.out.printf("放入第%d个商品到背包中\n", i);
                j = j - w[i-1];
            } else {
                i--;
            }
        }

    }
}
