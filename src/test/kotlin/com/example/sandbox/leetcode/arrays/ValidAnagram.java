package com.example.sandbox.leetcode.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

public class ValidAnagram {

    // better for memory and runtime
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for (int n : store) if (n != 0) return false;

        return true;
    }

    // easier bit O(log(n))
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        return s.chars().sorted().boxed().toList().equals(t.chars().sorted().boxed().toList());
    }

    @Test
    void test_01() {
        assertTrue(isAnagram("anagram", "nagaram"));
    }

    @Test
    void test_02() {
        assertFalse(isAnagram("rat", "car"));
    }

    @Test
    void test_03() {
        assertTrue(isAnagram("anna", "nana"));
    }
}
