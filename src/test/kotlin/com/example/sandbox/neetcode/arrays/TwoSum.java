package com.example.sandbox.neetcode.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }

            map.put(num, i);
        }

        return new int[]{};
    }

    @Test
    void test_01() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        assertArrayEquals(twoSum(nums, target), new int[]{0, 1});
    }

    @Test
    void test_02() {
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        assertArrayEquals(twoSum(nums, target), new int[]{1, 2});
    }

    @Test
    void test_03() {
        int[] nums = {3, 3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        assertArrayEquals(twoSum(nums, target), new int[]{0, 1});
    }
}
