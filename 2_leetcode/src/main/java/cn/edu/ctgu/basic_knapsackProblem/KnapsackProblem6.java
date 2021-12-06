package cn.edu.ctgu.basic_knapsackProblem;

import java.util.Arrays;

/**
 *
 * @author NiuQun
 * @date 2021/11/5
 */
public class KnapsackProblem6 {
    public static void main(String[] args) {
        // 20*2 + 50*9 + 50*7 + 30*6 + 20
        // 40+450+350+180+20 = 40+800+200=1040
        // 每个物品的价值
        int[] val = {20, 50, 50, 30, 20};
        // 每个物品的重量
        int[] w = {80, 40, 30, 40, 20};

        // 每个物品的最大数量
        int[] s = {4, 9, 7, 6, 1};
        // 物品的个数
        int n = 5;
        // 背包的最大容量
        int m = 1000;

        //
        int[][] v = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            // 新增商品i
            for (int j = 0; j <= m; j++) {
                // 背包容量从0到m
                if (i==0 || j==0) {
                    v[i][j] = 0;
                } else {
                    // 如果背包的容量 >= 新增物品的重量，则尝试装入当前新增物品
                    // 由于物品i的数量最多是s[i-1],所以物品i不能无限制的装入背包
                    // 新增物品i的个数要 <= s[i-1]
                    // 由于多重背包问题无法像0-1背包和完全背包那样使用迭代，所以我们这里采用相对朴素的方式来解决
                    // 尝试装入[0, s[i-1]件商品i
                    if (j >= s[i-1]) {
                        for (int k = 0; k <= s[i-1]; k++) {
                            // 如果当前背包的容量 >= k件商品i的重量之和，则可以尝试装入[0, s[i-1]]件物品i
                            if (j >= k*w[i-1]) {
                                v[i][j] = Math.max(v[i][j], v[i-1][j-k*w[i-1]] + k*val[i-1]);
                            }
                        }
                    } else {
                        // 如果背包的容量 < 新增物品的重量，则不需要尝试装入当前新增物品
                        v[i][j] = v[i-1][j];
                    }

                }
            }

        }

        for (int[] temp : v) {
            System.out.println(Arrays.toString(temp));
        }
        System.out.println(v[n][m]);

        int i = n;
        int j = m;
        int count = 0;

        while (i > 0 && j > 0) {
            // 由于这里对商品个数有限制，所以不能不断的循环，需要一个额外的变量来统计背包中已经添加了多少个物品i
            if (v[i][j] > v[i-1][j] && j >= w[i-1] && count < s[i-1]) {
                System.out.printf("放入第%d个商品到背包中\n", i);
                count++;
                j = j - w[i-1];
            } else {
                i--;
                count = 0;
            }
        }

    }

}
