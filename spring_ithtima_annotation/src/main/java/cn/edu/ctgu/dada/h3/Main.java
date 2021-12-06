package cn.edu.ctgu.dada.h3;

import java.util.Scanner;
public class Main {

    public static int maxCoins(int[] array) {
       int count = 0;
       int length = array.length;
       return 0;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] arrayStr = str.split(",");
            int[] array = new int[arrayStr.length];
            for (int i = 0; i < arrayStr.length; i++) {
                array[i] = Integer.parseInt(arrayStr[i].trim());
            }
            System.out.println(maxCoins(array));
        }
        
    }
}