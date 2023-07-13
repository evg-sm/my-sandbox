package com.example.sandbox.stepik;

import java.util.Arrays;

public class SimpleEnumeration {

    static int n; // длина последовательности
    static int m; // диапозон последовательности (от 1 до m)
    static Integer[] a;

    static void rec(int idx) {
        if (idx == n)
        {
            System.out.println(Arrays.asList(a));
            return;
        }
        for (int i = 1; i <= m; i++)
        {
            a[idx] = i;
            rec(idx + 1);
        }
    }

    public static void main(String[] args) {
        n = 2;
        m = 2;
        a = new Integer[n];
        rec(0);
    }
}
