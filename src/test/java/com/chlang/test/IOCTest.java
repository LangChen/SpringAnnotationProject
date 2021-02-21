package com.chlang.test;

import com.chlang.bean.Person;
import com.chlang.config.MainConfig;
import com.chlang.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.Map;

public class IOCTest {

    @Test
    public void testImport(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        printBeans(applicationContext);

        Object bean2 = applicationContext.getBean("colorFactoryBean");
        Object bean3 = applicationContext.getBean("colorFactoryBean");
        System.out.println(bean2.getClass());
        System.out.println(bean2 == bean3);
        Object bean4 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean4.getClass());
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionName = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < definitionName.length; i++) {
            System.out.println(definitionName[i]);
        }
    }

    @Test
    public void test03(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        Environment environment = annotationConfigApplicationContext.getEnvironment();
        System.out.println(environment.getProperty("os.name"));
        String[] nameFotTypes = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for (int i = 0; i < nameFotTypes.length; i++) {
            System.out.println(nameFotTypes[i]);
        }
        Map<String,Person> personMap = annotationConfigApplicationContext.getBeansOfType(Person.class);
        System.out.println(personMap);
    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] definitionName = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (int i = 0; i < definitionName.length; i++) {
            System.out.println(definitionName[i]);
        }
        System.out.println("容器初始化完成");
//        Object p =  annotationConfigApplicationContext.getBean("person");
//        Object p2 =  annotationConfigApplicationContext.getBean("person");

//        System.out.println(p == p2);
    }

    @Test
    public void test01(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionName = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (int i = 0; i < definitionName.length; i++) {
            System.out.println(definitionName[i]);
        }
        Person p = (Person) annotationConfigApplicationContext.getBean("person");
        System.out.println("用户ID："+p.getId()+"，用户名："+p.getName());
    }

}
