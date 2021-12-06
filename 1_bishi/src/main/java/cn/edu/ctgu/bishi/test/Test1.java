package cn.edu.ctgu.bishi.test;

/**
 * @author NiuQun
 * @date 2021/10/22
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(test(1));
    }

    public static int test(int i) {
        try {
            i = i/1;
            System.out.println("try");
            i++;
            return i;
        } catch (Exception e) {
            System.out.println("catch");
            i++;
            return i;
        } finally {
            System.out.println("finally");
            i++;
            return i;
        }

    }





}