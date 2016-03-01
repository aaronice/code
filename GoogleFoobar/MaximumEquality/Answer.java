package com.google.challenges;

public class Answer {
    public static int answer(int[] x) {

        // Your code goes here.
        if (x == null || x.length == 0) {
            return 0;
        }

        int cars = x.length;
        int rabbits = 0;
        for (int i = 0; i < cars; i++) {
            rabbits += x[i];
        }

        if (rabbits % cars == 0) {
            return cars;
        } else {
            return cars - 1;
        }
    }
}
