package cn.edu.ctgu.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author NiuQun
 * @date 2021/10/14
 */
public class SpringComponentScanTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext("cn.edu.ctgu.config");

    }
}
