package cn.edu.ctgu.bishi.xiecheng.h1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author NiuQun
 * @date 2021/10/21
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] temp = input.toCharArray();
        System.out.println(Arrays.toString(temp));
        System.out.println("============================");


        while (true) {
            int count = 1;
            int i = 0;
            // 每一次遍历我们都会将第一个重复部分字符串变成互相不同的字符
            for (i = 0; i <= temp.length-2; i++) {
                if (temp[i] == temp[i+1]) {
                    count++;
                }
                if (count != 1 && temp[i] != temp[i+1]) {
                    break;
                }
            }
            // 1.当数组遍历完了，但是count依旧等于1，结束此次遍历
            // 2.当发现了一个重复部分，将重复部分遍历完后，结束此次遍历

            // 如果将数组遍历了一遍，发现count=1，那么说明没有重复的部分，此时的数组已经是符合要求的了
            // 那么此后就不需要再遍历了
            if (count == 1) {
                break;
            }

            // 重复部分的左右索引 int rightIndex = i;

            int leftIndex = i - count + 1;

            // 如果重复部分长度为奇数个,那么只需要将更改重复部分的偶数个
            int tempIndex = leftIndex;
            if (count % 2 != 0) {
                for (int j = 0; j < count ; j++) {
                    if (j % 2 != 0) {
                        // 大写变小写，小写变大写
                        if (Character.isUpperCase(temp[tempIndex+j])) {
                            temp[tempIndex+j] = Character.toLowerCase(temp[tempIndex+j]);
                        } else {
                            temp[tempIndex+j] = Character.toUpperCase(temp[tempIndex+j]);
                        }
                    }
                }
            } else { // 如果重复部分长度为偶数个,需要判断重复部分，左侧和右侧是否有和重复部分有相反的字母
                // 如果左边有，则需要改偶数位的(包含了左边有，和两边都有)
                if (leftIndex != 0 && Math.abs(temp[leftIndex]-temp[leftIndex-1])==32) {
                    for (int j = 0; j < count ; j++) {
                        if (j % 2 != 0) {
                            // 大写变小写，小写变大写
                            if (Character.isUpperCase(temp[leftIndex+j])) {
                                temp[leftIndex+j] = Character.toLowerCase(temp[leftIndex+j]);
                            } else {
                                temp[leftIndex+j] = Character.toUpperCase(temp[leftIndex+j]);
                            }
                        }
                    }
                    // 如果右边有，则需要改奇数位的（包含了右边有，和两边都没有）
                } else {
                    for (int j = 0; j < count ; j++) {
                        if (j % 2 == 0) {
                            // 大写变小写，小写变大写
                            if (Character.isUpperCase(temp[leftIndex+j])) {
                                temp[leftIndex+j] = Character.toLowerCase(temp[leftIndex+j]);
                            } else {
                                temp[leftIndex+j] = Character.toUpperCase(temp[leftIndex+j]);
                            }
                        }
                    }
                }
                // 如果两边都有或者都没有，则改奇数位和偶数位效果相同
            }
        }
        System.out.println(Arrays.toString(temp));
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != temp[i]) {
                result++;
            }
        }
        System.out.println(result);
    }

}
// AaaaA
// BaaaC

// AaaaaB
// aaaaA
// AaaaaA
// aaaa




