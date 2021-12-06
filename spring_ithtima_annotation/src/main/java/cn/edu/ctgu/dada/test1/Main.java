package cn.edu.ctgu.dada.test1;

/**
 * @author NiuQun
 * @date 2021/10/17
 */
public class Main {
    public static void main(String[] args) {
        String str = "111";
        int i = Integer.parseInt(str);
        int i1 = Integer.valueOf(str).intValue();

        // 合理字符串 -> Integer
        Integer integer = new Integer(str);
        Integer integer1 = new Integer(3);
        //new Integer(String str)--> parseInt(String str);
        // valueOf(String str)  --> parseInt(String str)

        // 合理字符串 -> Integer
        Integer integerA = Integer.valueOf(str);
        // int -> Integer
        Integer integerB = Integer.valueOf(3);

        // 合理字符串-> int
        int a = Integer.parseInt(str);
        // Integer -> int
        int b = integerB.intValue();


    }
}

class A {
    @Override
    public String toString() {
        return super.toString();
    }
}
