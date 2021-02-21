package com.chlang.config;

import com.chlang.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(value="com.chlang")
public class MyConfig {

    @Bean
    public Person person(){
        return new Person(1,"lisan");
    }

}
