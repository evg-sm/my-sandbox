package com.example.sandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MyService {
    private final int mySomeBean;

    @Autowired
    public MyService(int mySomeBean) {
        this.mySomeBean = mySomeBean;
    }

    @PostConstruct
    public void postC(){
        System.out.println("mySomeBean = " + mySomeBean);
    }
}
