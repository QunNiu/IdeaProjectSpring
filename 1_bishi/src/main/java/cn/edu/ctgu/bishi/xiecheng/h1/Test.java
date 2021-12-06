package cn.edu.ctgu.bishi.xiecheng.h1;

import java.util.Scanner;

/**
 * @author NiuQun
 * @date 2021/10/21
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] temp = input.toCharArray();

        int count = 1;
        int i;
        for (i = 0; i <= temp.length-2; i++) {
            if (temp[i] == temp[i+1]) {
                count++;
            }
            if (count != 1 && temp[i] != temp[i+1]) {
                break;
            }
        }
        System.out.println(count);
        System.out.println(i);
    }
}
