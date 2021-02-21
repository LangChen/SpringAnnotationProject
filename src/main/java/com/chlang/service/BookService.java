package com.chlang.service;

import com.chlang.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class BookService {

//    @Qualifier("bookDao2")
//    @Autowired(required = false)
    @Autowired
    private BookDao bookDao;

    public void print(){
        System.out.println(bookDao);
    }

}
