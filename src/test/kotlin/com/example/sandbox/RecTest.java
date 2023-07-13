package com.example.sandbox;

import org.junit.jupiter.api.Test;

public class RecTest {

    @Test
    void test_01() {
        recFunCorrect(10);
    }

    private void recFunCorrect(int i) {
        if (i <= 0) return;
        System.out.println("i=" + i);
        i--;
        recFunCorrect(i);
    }

    @Test
    void test_02() {
        recFunUncorrected(10);
    }

    private void recFunUncorrected(int i) {
//        if (i <= 0) return;
        System.out.println("i=" + i);
        i--;
        recFunUncorrected(i);
    }

    @Test
    void test_03() {
        int fact = fact(13455432);
        System.out.println(fact);
    }

    public int fact(int num) {
        return ((num > 1) ? num * fact(num - 1) : 1);
    }
}
