package com.example.sandbox.leetcode.arrays;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int num : nums) {
            uniques.add(num);
        }

        return uniques.size() < nums.length;
    }

    // better for memory and runtime
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (uniques.contains(nums[i])) {
                return true;
            }
            uniques.add(nums[i]);
        }
        return false;
    }

    @Test
    void test_01() {
        int[] nums = {1, 2, 3, 1};
        assertTrue(containsDuplicate(nums));
    }

    @Test
    void test_02() {
        int[] nums = {1, 2, 3, 4};
        assertFalse(containsDuplicate(nums));
    }

    @Test
    void test_03() {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        assertTrue(containsDuplicate(nums));
    }
}
