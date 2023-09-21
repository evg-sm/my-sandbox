package com.example.sandbox.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BubbleSortTest {

    @Test
    void bubbleSort() {
        int[] arrayForSort = {12, 6, 4, 1, 15, 10};
        bubbleSort(arrayForSort);
        System.out.println(Arrays.toString(arrayForSort));
    }

    public static void bubbleSort(int[] sortArr){
        for (int i = 0; i < sortArr.length - 1; i++) {
            for(int j = 0; j < sortArr.length - i - 1; j++) {
                if(sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
        }
    }
}
