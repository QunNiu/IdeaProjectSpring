package cn.edu.ctgu.dada.test;

import java.util.ArrayList;

/**
 * @author NiuQun
 * @date 2021/10/17
 */
public class Main {
    public static void main(String[] args) {
        new B();
    }

}

class A {
    public A() {
        System.out.println("A Constructor before");
        test();
        System.out.println("A Constructor after");
    }

    public void test() {
        System.out.println("A test before");
        System.out.println("AAAAA");
        System.out.println("A test after");
    }
}

class B extends A{

    public B() {
        System.out.println("B Constructor before");
        System.out.println("B Constructor after");
    }

    @Override
    public void test() {
        System.out.println("B test before");
        System.out.println("BBBB");
        System.out.println("B test after");
    }
}

