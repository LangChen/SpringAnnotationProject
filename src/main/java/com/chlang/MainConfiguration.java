package com.chlang;

import com.chlang.bean.Person;
import com.chlang.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfiguration {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class);

        String[] definitionName = annotationConfigApplicationContext.getBeanDefinitionNames();

        for (int i = 0; i < definitionName.length; i++) {
            System.out.println(definitionName[i]);
        }

        Person p = (Person) annotationConfigApplicationContext.getBean("person");

    }

}
