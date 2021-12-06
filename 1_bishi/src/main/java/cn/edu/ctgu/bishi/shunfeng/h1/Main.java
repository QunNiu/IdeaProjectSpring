package cn.edu.ctgu.bishi.shunfeng.h1;

import java.util.Scanner;

/**
 * @author NiuQun
 * @date 2021/10/24
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // t表示有t组数据
        int t = scanner.nextInt();

        int[][] arr = new int[t][];
        for (int i = 0; i < t; i++) {
            arr[i] = new int[3];
            for (int j = 0; j < 3; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[] result = new int[t];
        for (int i = 0; i < t; i++) {
            int n = arr[i][0];
            int m = arr[i][1];
            // 瓷砖边长
            int a = arr[i][2];
            result[i] = (n/a + 1) * (m/a + 1);
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
