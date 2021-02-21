package com.chlang.condition;

import com.chlang.bean.Black;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry 注册类
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.chlang.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.chlang.bean.Blue");
        if(red && blue){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Black.class);
            registry.registerBeanDefinition("black",rootBeanDefinition);
        }
    }
}
