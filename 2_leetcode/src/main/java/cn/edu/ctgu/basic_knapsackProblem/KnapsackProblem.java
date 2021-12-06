package cn.edu.ctgu.basic_knapsackProblem;

import java.util.Arrays;

/**
 * 0-1背包：动态规划问题
 * 时间复杂度：O(n*m)： 遍历数组v
 * 空间复杂度：O(n*m)： 数组int[][] v = new int[n+1][m+1]
 * n为物品个数，m为背包容量
 * @author NiuQun
 * @date 2021/11/3
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        // 数组w存储每个物品的重量
        int[] w = {1, 4, 3};

        // 数组val存储每个物品对应的价值
        int[] val = {1500, 3000, 2000};

        // n表示物品的个数
        int n = val.length;

        // m表示背包的容量
        int m = 4;

        // 数组v存储当可以放入第i个物品且背包容量为j时，背包中可以放入的物品的最大价值
        // 其中i代表第i个物品，j代表第i个物品的重量，同时i为行索引，j为列索引
        int[][] v = new int[n+1][m+1];
        int[][] path = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    v[i][j] = 0;
                } else {
                    // 如果新增物品的重量 > 背包容量，则放入情况和没有新增该物品时一样
                    if (w[i-1] > j) {
                        v[i][j] = v[i-1][j];

                    } else {
                        // 如果新增物品的重量 <= 背包容量
                        // v[i][j] = Math.max(v[i-1][j], v[i-1][j-w[i-1]] + val[i-1]);
                        // 这里如果我们想要知道每次增加物品i时，是否需要将物品i放入背包中，我们需要将上述语句改成if-else语句

                        // 如果将新增物品放入背包后，背包中物品总价值小于等于不放入物品i时的总价值
                        if (v[i-1][j] > v[i-1][j-w[i-1]] + val[i-1]) {
                            // 则说明新增物品i不应当放入背包，使得背包中商品总价值最大
                            v[i][j] = v[i-1][j];
                        } else {
                            // 如果将新增物品放入背包后，背包中物品总价值大于不放入物品i时的总价值
                            // 则说明新增物品i应当放入背包，使得背包中商品总价值最大
                            v[i][j] = v[i-1][j-w[i-1]] + val[i-1];
                            path[i][j] = 1;
                        }
                    }
                }
            }
        }
        for (int[] value : v) {
            System.out.println(Arrays.toString(value));
        }
        System.out.println("简单打印path数组会得到所有的冗余情况：");
        for (int[] temp : path) {
            System.out.println(Arrays.toString(temp));
        }
        System.out.println("但是实际上只需要最后的放入情况，我们应当倒序遍历数组path：");
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包中\n", i);
                // 同时背包容量需要减去当前物品的重量，因为这里需要和之前我们向path数组中存放1时做相反的操作
                // 背包的剩余容量为当前容量减去物品i的容量
                j = j - w[i - 1];
            }
            i--;
        }
        System.out.println("当然我们也可以通过直接倒序遍历数组v来获取哪些物品放入了背包：");

        i = n;
        j = m;
        while (i > 0 && j > 0) {
            // 当新增物品i时背包中物品总价值>新增物品i-1时背包中物品总价值
            // 说明将新增物品i放入了背包使得背包中物品总价值最大
            if (v[i][j] > v[i-1][j]) {
                System.out.printf("第%d个商品放入到背包中\n", i);
                // 背包的剩余容量为当前容量减去物品i的容量
                j = j - w[i-1];
            }
            i--;
        }
    }
}
