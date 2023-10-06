package com.example.sandbox.neetcode.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NumberInThreeArrays {

    private int findNumber(Integer[] a1, Integer[] a2, Integer[] a3) {
        for (Integer integer : a1) {
            if (Arrays.asList(a2).contains(integer) && Arrays.asList(a3).contains(integer)) {
                return integer;
            }
        }
        return -1;
    }

    @Test
    void test_01() {
        Integer[] a1 = {1, 2, 4, 5};
        Integer[] a2 = {3, 3, 4};
        Integer[] a3 = {2, 3, 4, 5, 6};
        System.out.println(findNumber(a1, a2, a3));
    }

    private int findNumber1(int[] a1, int[] a2, int[] a3) {
        for (int i : a1) {

            if (Arrays.binarySearch(a2, i) != -1 && Arrays.binarySearch(a3, i) != -1) {
                return i;
            }
        }
        return -1;
    }

    @Test
    void test_02() {
        int[] a1 = {1, 2, 4, 5};
        int[] a2 = {3, 3, 4};
        int[] a3 = {2, 3, 4, 5, 6};
        System.out.println(findNumber1(a1, a2, a3));
    }


    class User {
        private int age;
        private String name;

        public void check(int id) {
            int methodPrimitive = 1;
        }
    }
}


