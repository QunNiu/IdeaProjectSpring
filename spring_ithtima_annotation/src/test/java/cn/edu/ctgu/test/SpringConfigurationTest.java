package cn.edu.ctgu.test;

import cn.edu.ctgu.config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * 测试 @Configuration注解
 * @author NiuQun
 * @date 2021/10/14
 */

public class SpringConfigurationTest {
    public static void main(String[] args) {
        // 1.创建容器：传入的参数是扫描包的字符串，会扫描该包下的bean
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext("cn.edu.ctgu.config");

        //AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        SpringConfiguration springConfiguration = app.getBean(SpringConfiguration.class);

        // 如果一个类使用了@Configuration注解，那么该类就是一个配置类
        // 我们可以通过设置@Configuration注解的value值来 设置该配置类的beanName
        // 如果不设置，默认将该配置类的 类名首字母小以后 设置为 beanName
        SpringConfiguration springConfiguration1 = (SpringConfiguration) app.getBean("springConfiguration");
        System.out.println(springConfiguration);
        System.out.println(springConfiguration1);
        // 所以这里的输出结果为true
        System.out.println(springConfiguration == springConfiguration1);
    }

}
