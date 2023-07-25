package com.example.sandbox;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    @Test
    void fizzBuzz() {
        List<String> list = new ArrayList<>(100);

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }

        System.out.println(list);
    }
}
