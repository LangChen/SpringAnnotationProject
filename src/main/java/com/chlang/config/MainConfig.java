package com.chlang.config;

import com.chlang.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

@Configuration
//@ComponentScan(value="com.chlang")
//@ComponentScan(value="com.chlang",includeFilters = {
//        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class})
//},useDefaultFilters = false)
@ComponentScans({
        @ComponentScan(value="com.chlang",includeFilters = {
//            @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class}),
            @ComponentScan.Filter(type= FilterType.CUSTOM,classes = {MytypeFilter.class})
        },useDefaultFilters = false)
})
public class MainConfig {

    @Bean
    public Person person(){
        return new Person(1,"lisan");
    }

}
