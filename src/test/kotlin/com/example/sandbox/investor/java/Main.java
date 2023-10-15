package com.example.sandbox.investor.java;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InvestorService investorService = new InvestorServiceImpl();
        List<Investor> list = investorService.getList(12L, 3L);
        System.out.println(list.size());
        System.out.println(list);
    }
}
