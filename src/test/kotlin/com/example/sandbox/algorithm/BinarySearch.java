package com.example.sandbox.algorithm;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearch {

    @Test
    void search() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        assertEquals(binarySearch(list, 0, list.size() - 1, 3), 2);
        assertEquals(binarySearch(list, 0, list.size() - 1, 13), 12);
        assertEquals(binarySearch(list, 0, list.size() - 1, 55), -1);
        assertEquals(binarySearch(list, 0, list.size() - 1, 0), -1);
    }

    private int binarySearch(List<Integer> list, int low, int high, int x) {
        if (high > low) {
            int mid = (low + high) / 2;
            if (list.get(mid) == x) {
                return mid;
            } else if (list.get(mid) > x) {
                return binarySearch(list, low, mid - 1, x);
            } else {
                return binarySearch(list, mid + 1, high, x);
            }
        } else {
            return -1;
        }
    }
}
