package cn.edu.ctgu.test.controller;

import cn.edu.ctgu.config.MyConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author NiuQun
 * @date 2021/10/18
 */
public class UserControllerTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);
        MyConfig myConfig = app.getBean(MyConfig.class);
        System.out.println(myConfig);
    }



}



