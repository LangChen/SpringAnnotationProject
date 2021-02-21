package com.chlang.config;

import com.chlang.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 1)指定初始化和销毁方法：
 *     通过@Bean指定init-method和destroy-method;
 * 2)通过让Bean实现InitializingBean、DisposableBean
 * 3)可以使用JSR250：
 *      @PostConstruct
 *      @PreDestory
 * 4)BeanPostProcessor: bean的后置处理器；
 *    在bean初始化前后进行一些处理工作：
 *      postProcessBeforeInitialization:在初始化方法之前
 *      初始化方法
 *      postProcessAfterInitialization:在初始化方法之后
 *
 */
@ComponentScan("com.chlang.bean")
@Configuration
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }

}
