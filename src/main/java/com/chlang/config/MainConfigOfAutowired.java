package com.chlang.config;

import com.chlang.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 1)@Autowired:自动注入
 *    1.优先按照类型去容器中找对应的组件
 *    2.如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中找
 *    3.@Qualifier 指定需要装配的组件的ID而不是使用属性名
 *    4.@Primary 指定多个组件的首选
 *    5.@Autowired(required=false)
 * 2)Spring还支持使用@Resource（jsr250）和Inject（jsr330）【java规范注解】
 *    @Resource:
 *      默认按照组件名称装配，不支持@Primary和@Autowired(required=false)
 *    @Inject：
 *      导入javax.inject的包，和@Autowired一样但不支持(required=false)
 *    AutowiredAnnotationBeanPostProcessor:解析完成自动装配功能
 *
 * 3）@Autowired:构造器，参数，方法，属性；
 *    1.标注在方法位置，@Bean+方法参数，默认不写Autowired，自动从容器获取
 *    2.标注在构造器上，如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略。参数位置的组件还是可以自动从容器中获取
 *
 * 4）自定义组件想要使用spring底层的一些组件（ApplicationContext, BeanFactory,xxx）
 *     自定义组件实现xxxAware:在创建对象的时候，会调用接口规定的方法注入相关组件；Aware
 *     xxxAware：功能使用xxxProcessor
 *
 */

@ComponentScan({"com.chlang.service","com.chlang.dao","com.chlang.controller"})
@Configuration
public class MainConfigOfAutowired {

//    @Primary
    @Bean
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }


}
