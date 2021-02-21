package com.chlang.test;

import com.chlang.config.MainConfigOfAutowired;
import com.chlang.dao.BookDao;
import com.chlang.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

    @Test
    public void test01(){
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);
        bookService.print();
        BookDao bookDao = applicationContext.getBean(BookDao.class);
        System.out.println(bookDao);
        applicationContext.close();
    }

}
