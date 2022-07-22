package com.example.javalib;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class MyClass {

    public static void main(String[] args) {
        boolean A = true;
        boolean B = false;
        System.out.println(Boolean.compare(true, !A));
        System.out.println(Boolean.compare(true, B));
    }
}