package cn.edu.ctgu.meituan.h1;


import java.util.Scanner;

/**
 * @author NiuQun
 * @date 2021/10/17
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n表示盒子的种类数,n为int足够
        int n = scanner.nextInt();
        // 第2个盒子中有a[0]个第b[0]种盒子
        // 第n个盒子中有a[n-2]个第b[n-2]种盒子
        // 题目明确说明 a[i] < 10 0000
        int[] a = new int[n - 1];
        int[] b = new int[n - 1];

        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = scanner.nextInt();
        }

        // 第n种盒子中有result[n]个糖果
        long[] result = new long[n+1];

        result[0] = 1000000;
        //第1种盒子定义为其内只放有1颗糖果的盒子。
        result[1] = 1000000;

        for (int i = 2; i < result.length; i++) {
            // 第i (i>1) 种盒子里放了 a[i] 个 b[i] （1≤b[i]<i） 种类的盒子
            result[i] = (long)a[i-2] * result[b[i-2]];
        }

        // 答案对1,000,000,007取模。
        for (int i = 1; i < result.length; i++) {
            if (result[i] < 1000000007) {
                System.out.print(result[i] + " ");
            } else {
                System.out.print(result[i] % 1000000007 + " ");
            }
        }
    }
}
