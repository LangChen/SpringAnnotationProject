package com.chlang.config;

import com.chlang.bean.Color;
import com.chlang.bean.ColorFactoryBean;
import com.chlang.bean.Person;
import com.chlang.bean.Red;
import com.chlang.condition.LinuxCondition;
import com.chlang.condition.MyImportBeanDefinitionRegistrar;
import com.chlang.condition.MyImportSelector;
import com.chlang.condition.WindowCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@Import({Color.class, Red.class,
        MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    @Lazy
    public Person person(){
        System.out.println("CREATE....");
        return new Person(2,"zhansan");
    }

    @Conditional({WindowCondition.class})
    @Bean("Bill Gate")
    public Person person2(){
        return new Person(3,"Bill Gate");
    }

    @Conditional({LinuxCondition.class})
    @Bean("Linus")
    public Person person3() {
        return new Person(4,"Linus");
    }

    /**
     * 给容器中注册组件：
     * 1）、包扫描+组件标识注解（@Controller、@Service...）
     * 2)、@Bean[导入的第三方包里面的组件]
     * 3）、@Import[快速给容器中导入一个组件]
     *    1)、@Import(要导入到容器中的组件)
     *    2)、ImportSelector:返回需要导入的组件的全类名数组
     *    3）、ImportBeanDefinitionRegistrar:手动注册bean到容器中
     * 4）使用Spring提供的FactoryBean（工厂Bean）
     *    1)默认获取到的是工厂bean调用的getObject创建的对象
     *    2）要获取工厂Bean本身，我们需要给id前面加一个&
     * @return
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
