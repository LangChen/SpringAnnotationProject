package com.chlang.test;

import com.chlang.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest_PropertyValue {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test01(){
        printBeans(applicationContext);
        System.out.println("容器创建完成...");
        Object person = applicationContext.getBean("person");
        System.out.println(person);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.id");
        System.out.println(property);
        applicationContext.close();
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionName = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < definitionName.length; i++) {
            System.out.println(definitionName[i]);
        }
    }

}
