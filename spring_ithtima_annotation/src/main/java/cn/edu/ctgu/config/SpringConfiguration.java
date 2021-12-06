package cn.edu.ctgu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring注解驱动开发的配置类，相当于applicationContext.xml配置文件
 * @author NiuQun
 * @date 2021/10/14
 */

@Configuration
@ComponentScan
public class SpringConfiguration {
    public SpringConfiguration() {
        System.out.println("SpringConfiguration配置类的无参构造方法......");
    }
}
