package com.company;

import java.util.Scanner;

public class InputConsole {
    public static double readNumber(String prompt, int minimum, int maximum){
        Scanner scan = new Scanner(System.in);
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