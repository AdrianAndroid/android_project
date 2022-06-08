package com.example.lib;

public class MyClass {

    public static void main(String[] args) {
        double d = 100.675D;
        double d2 = 100.444;
        float f = 11.11f;
        float f2 = 11.66f;
        System.out.println("--ceil--");
        System.out.println(d + " -> " + Math.ceil(d));
        System.out.println(d2 + " -> " + Math.ceil(d2));
        System.out.println(f + " -> " + Math.ceil(f));
        System.out.println(f2 + " -> " + Math.ceil(f2));

        System.out.println("--floor--");
        System.out.println(d + " -> " + Math.floor(d));
        System.out.println(d2 + " -> " + Math.floor(d2));
        System.out.println(f + " -> " + Math.floor(f));
        System.out.println(f2 + " -> " + Math.floor(f2));

        System.out.println("--round--");
        System.out.println(d + " -> " + Math.round(d));
        System.out.println(d2 + " -> " + Math.round(d2));
        System.out.println(f + " -> " + Math.round(f));
        System.out.println(f2 + " -> " + Math.round(f2));
    }

}


