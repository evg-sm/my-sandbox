package com.example.sandbox.investor;

import org.junit.jupiter.api.Test;

public class InvestorTest {

    @Test
    void test() {
        InvestorService service = new InvestorService();

        System.out.println(service.getList());
    }
}
