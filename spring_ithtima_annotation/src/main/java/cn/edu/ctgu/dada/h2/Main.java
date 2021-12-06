package cn.edu.ctgu.dada.h2;

import java.util.Scanner;

/**
 * @author NiuQun
 * @date 2021/10/17
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || (i+j==(n-1))) {
                    System.out.print("x");
                }else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

}
