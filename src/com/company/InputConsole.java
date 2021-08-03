package com.company;

import java.util.Scanner;

public class InputConsole {
    private static Scanner scan = new Scanner(System.in);

    //Overloading readNumber method
    public static double readNumber(String prompt){
        System.out.println(prompt + ": ");
        return scan.nextDouble();
    }

    public static double readNumber(String prompt, int minimum, int maximum){
        double value;
        while (true) {
            System.out.print(prompt + ": ");
            value = scan.nextDouble();
            if (value >= minimum && value <= maximum) {
                return value;
            }
            System.out.println("Enter a value between " + minimum + " and " + maximum);
        }
    }
}