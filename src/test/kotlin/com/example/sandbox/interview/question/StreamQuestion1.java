package com.example.sandbox.interview.question;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class StreamQuestion1 {

    @Test
    void test1() {
        // Что выведет консоль ? - изначальный список
        // Почему ? - потому что результат работы stream никак не обрабатывется, у stream нет терминальной операции
        // peek будет печатать? - нет не будет
        List<String> animals = List.of("parrot", "cat", "snake");
        animals.stream()
                .sorted()
                .peek(item -> System.out.println(item))
                .map(String::length);
        System.out.println(animals);
    }

    @Test
    void test2FixedStream() {
        List<String> animals = List.of("parrot", "cat", "snake");
        List<Integer> collected = animals.stream()
                .sorted()
                .peek(item -> System.out.println(item))
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("animals = " + animals);
        System.out.println("collected = " + collected);
    }

    @Test
    void test3() {
        List<String> animals = List.of("parrot", "cat", "snake");
        List<Integer> collected = animals.stream()
                .peek(item -> System.out.println(item))
                .map(String::length)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("animals = " + animals);
        System.out.println("collected = " + collected);
        System.out.println("animals.stream().sorted() = " + animals.stream().sorted().collect(Collectors.toList()));
    }
}
