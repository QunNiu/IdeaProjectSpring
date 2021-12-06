package cn.edu.ctgu.title_1022.h6;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 合并两个有序数组
 * 输入：
 * 1 2 3 4 5
 * 2 3 4 5 6
 *
 * 输出：
 * 1 2 2 3 3 4 4 5 5 6
 * @author NiuQun
 * @date 2021/10/22
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str1 = scanner.nextLine().split(" ");
        String[] str2 = scanner.nextLine().split(" ");
        int[] arr1 = new int[str1.length];
        int[] arr2 = new int[str2.length];

        for (int i = 0; i < str1.length; i++) {
            arr1[i] = Integer.parseInt(str1[i]);
        }
        for (int i = 0; i < str2.length; i++) {
            arr2[i] = Integer.parseInt(str2[i]);
        }

        // 至此获取了两个需要合并的有序数组arr1和arr2
        int[] result = new int[arr1.length + arr2.length];
        int m = 0;
        int n = 0;
        int k = 0;
        while (m < arr1.length && n < arr2.length) {
            if (arr1[m] <= arr2[n]) {
                result[k] = arr1[m];
                m++;
            } else {
                result[k] = arr2[n];
                n++;
            }
            k++;
        }

        // 数组arr1排完了, 数组arr2还有剩余
         while (n < arr2.length) {
            result[k] = arr2[n];
            n++;
            k++;
        }

       // 数组arr2排完了, 数组arr1还有剩余
        while (m < arr1.length) {
            result[k] = arr1[m];
            m++;
            k++;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
