package cn.edu.ctgu.basic_knapsackProblem;

import java.util.ArrayList;

/**
 * 多重背包：朴素算法-二进制优化
 * @author NiuQun
 * @date 2021/11/4
 */
public class KnapsackProblem7 {
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
        ArrayList<Integer> valList = new ArrayList<>();
        ArrayList<Integer> wList = new ArrayList<>();
        // 主要思想是将s[i-1]个第i种物品拆分成多种物品
        // num用于统计最终拆分成了多少个物品
        int num = 0;
        for (int i = 1; i <= n; i++) {
            // 拆分第i种物品
            int tempS = s[i-1];
            for (int j = 1; j <= tempS; j = j<<1) {
                // 注意这里新构建的商品的价值和重量都要等倍数增加,千万不要写错了
                valList.add(val[i-1]*j);
                wList.add(w[i-1]*j);
                num++;
                // 每次拆分出来1个新的种类后，就需要在原来的数目上减去相应的物品数目
                tempS = tempS - j;
            }
            // 如果经过拆分后还有剩余,则把余下的商品数作为一个新的种类
            if (tempS != 0) {
                valList.add(val[i-1]*tempS);
                wList.add(w[i-1]* tempS);
                num++;
            }
        }
        //System.out.println(valList);
        //System.out.println(wList);

        // 至此，得到新的商品数目为num，即valList.size()或者wList.size
        // 其中valList中保存每种新商品的价值，wList中保存每种新商品的重量
        // 后边就可以使用0-1背包的解决方式来解决多重背包的问题
        // 其中商品数为num，背包容量依旧为m，
        for (int i = 1; i <= num; i++) {
            // 当背包的容量 >= 物品i的重量时，才考虑放入某些个物品i
            for (int j = m; j >=  wList.get(i-1); j--) {
                // 尝试放入新构建的物品i
                v[j] = Math.max(v[j], v[j-wList.get(i-1)] + valList.get(i-1));

            }
            //System.out.println(Arrays.toString(v));
        }
        System.out.println(v[m]);
    }
}
