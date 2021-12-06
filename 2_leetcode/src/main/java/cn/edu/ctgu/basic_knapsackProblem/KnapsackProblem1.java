package cn.edu.ctgu.basic_knapsackProblem;

/**
 * 0-1背包：动态规划问题，使用一位数组简化空间复杂度
 * 时间复杂度：O(n*m)
 * 空间复杂度：O(m)
 * n为物品个数，m为背包容量
 * @author NiuQun
 * @date 2021/11/4
 */
public class KnapsackProblem1 {
    public static void main(String[] args) {
        // 数组w存储每个物品的重量
        int[] w = {1, 4, 3};

        // 数组val存储每个物品对应的价值
        int[] val = {1500, 3000, 2000};

        // n表示物品的个数
        int n = val.length;

        // m表示背包的容量
        int m = 4;

        // v[i]代表背包容量为j时且新增物品i时，背包中物品的最大总价值
        int[] v = new int[m+1];

        for (int i = 1; i <= n; i++) {
            // 新增物品i时, 讨论背包容量为m~1时的情况
            for (int j = m; j > 0; j--) {
                // 如果背包容量 > 新增物品的重量,则代表新增物品i可以尝试放入背包
                if (j >= w[i-1]) {
                    // 数组v中原本保存的是新增物品i-1且背包容量为0~m时背包中物品总价值最大值
                    // 由于之前使用二维数组，在更改v[i][j]时，我们实际上用到的用于比较的数据是v[i-1][0] ~ v[i-1][j],
                    // 对于v[i-1][j+1] ~ v[i-1][m]中的数据并没有用到，所以这里可以采用一位数组减小空间复杂度
                    // w[i-1]代表物品i的重量，val[i-1]代表物品i的价值
                    v[j] = Math.max(v[j], v[j-w[i-1]] + val[i-1]);
                }
                // 如果背包容量 < 新增物品的重量,则代表新增物品i可以无法放入背包，情况与新增物品i-1时相同
                // 此时v[j] = v[j];
            }
        }
        /*
        // 上述for循环可以稍微优化一下
        for (int i = 1; i <= n; i++) {
            // 背包容量小于等于新增物品i质量时，情况和新增物品i-1时情况一致，不需要再修改数组
            for (int j = m; j >= w[i-1]; j--) {
                v[j] = Math.max(v[j], v[j-w[i-1]] + val[i-1]);
            }
        }
         */
        System.out.println(v[m]);
    }
}
