package com.example.lib;

import java.util.Arrays;
import java.util.Comparator;

public class MyClass {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 10; i < 100; i++) {
            sum += i;
        }
        System.out.println(sum);
        String[] strs = new String[]{};
        Arrays.sort(strs, (x, y) -> (x+y).compareTo(y+x));
    }

}