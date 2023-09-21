package com.example.sandbox;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static org.springframework.boot.context.properties.bind.Bindable.listOf;

public class AppendTest {

    BiFunction<String, String, String> stringAppend = (s1, s2) -> s1 + s2;

    @Test
    void test1() {
        String res = stringAppend.apply("s1", "s2");
        System.out.println(res);
    }

    @Test
    void test2() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        var res = integers.stream().map(i -> Integer.toString(i)).toList();

        System.out.println(res);
    }
}
