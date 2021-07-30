package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Taking Inputs
        int principal = (int) readNumber("Principal", 1_000, 1_000_000);
        float annualInterestDate = (float) readNumber("Annual Interest Rate", 1, 30 );
        int period = (int) readNumber("Period", 1, 30);

        double mortgage = calculateMortgage(principal,annualInterestDate,period);

        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: "+formattedMortgage);
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scan = new Scanner(System.in);
        double value;
        while (true){
            System.out.print(prompt + ": ");
            value = scan.nextDouble();
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Enter a value between " + min + " and " + max);
        }
    }

    public static double calculateMortgage(int principal, float annualInterestRate, int period){
        //declaring constants
        final byte MONTHS_IN_A_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterestRate = annualInterestRate/PERCENT/MONTHS_IN_A_YEAR;
        int numberOfPayments = period*MONTHS_IN_A_YEAR;

        double mortgage = principal*(monthlyInterestRate*Math.pow(1+monthlyInterestRate,numberOfPayments))/(Math.pow(1+monthlyInterestRate,numberOfPayments)-1);
        return mortgage;

    }
}
