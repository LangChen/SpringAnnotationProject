package com.chlang.dao;

import org.springframework.stereotype.Service;

@Service
public class BookDao {

    private String label = "label1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
