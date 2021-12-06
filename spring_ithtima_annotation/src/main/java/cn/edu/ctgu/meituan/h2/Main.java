package cn.edu.ctgu.meituan.h2;


/**
 * @author NiuQun
 * @date 2021/10/17
 */
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author NiuQun
 * @date 2021/10/17
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 3) {
            System.out.println(2);
            System.out.println(2 + " " + 3 + " " + 1);
            System.out.println(3 + " " + 1 + " " + 2);
        } else if (n == 4) {
            System.out.println(9);
            System.out.println(2 + " " + 1 + " " + 4 + " "+ 3);
            System.out.println(2 + " " + 3 + " " + 4 + " "+ 1);
            System.out.println(2 + " " + 4 + " " + 1 + " "+ 3);
            System.out.println(3 + " " + 1 + " " + 4 + " "+ 2);
            System.out.println(3 + " " + 4 + " " + 1 + " "+ 2);
            System.out.println(3 + " " + 4 + " " + 2 + " "+ 1);
            System.out.println(4 + " " + 1 + " " + 2 + " "+ 3);
            System.out.println(4 + " " + 3 + " " + 1 + " "+ 2);
            System.out.println(4 + " " + 3 + " " + 2 + " "+ 1);
        }
    }
}
