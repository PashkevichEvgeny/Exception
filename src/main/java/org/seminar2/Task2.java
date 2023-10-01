package org.seminar2;

import java.util.Random;

public class Task2 {
    public static void divideNumber(){
        int[] intArray = new int[new Random().nextInt(16)];
    try {
        int d = 0;
        double catchedRes1 = (double) intArray[8] / d;
        System.out.println("catchedRes1 = " + catchedRes1);
    } catch (ArithmeticException | IndexOutOfBoundsException e) {
        System.out.println("Catching exception: " + e);
    }
    }

}
