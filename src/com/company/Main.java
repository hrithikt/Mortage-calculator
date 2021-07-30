package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //declaring constants
        final byte MONTHS_IN_A_YEAR = 12;
        final byte PERCENT = 100;

        // Taking Inputs
        int principal = (int) readNumber("Principal", 1_000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate", 1, 30 );
        int period = (int) readNumber("Period", 1, 30);

        float monthlyInterestRate = annualInterestRate/PERCENT/MONTHS_IN_A_YEAR;
        int numberOfPayments = period*MONTHS_IN_A_YEAR;

        printMortgage(principal, monthlyInterestRate, numberOfPayments);
        printPaymentSchedule(principal, monthlyInterestRate,numberOfPayments);
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

    public static void printMortgage(int principal, float monthlyInterestRate, int numberofPayments){
        double mortgage = calculateMortgage(principal, monthlyInterestRate, numberofPayments);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + formattedMortgage);
    }
    public static double calculateMortgage(int principal, float monthlyInterestRate, int numberOfPayments){
        double mortgage = principal*(monthlyInterestRate*Math.pow(1+monthlyInterestRate,numberOfPayments))/(Math.pow(1+monthlyInterestRate,numberOfPayments)-1);
        return mortgage;
    }

    public static void printPaymentSchedule(int principal, float monthlyInterestRate, int numberOfPayments){
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for(int paymentsMade = 1; paymentsMade <= numberOfPayments; paymentsMade++){
            double balance = calculateBalance(principal, monthlyInterestRate, numberOfPayments, paymentsMade);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
    public static double calculateBalance(int principal, float monthlyInterestRate, int numberOfPayments, int paymentsMade){
        double balance = principal*(Math.pow(1+monthlyInterestRate,numberOfPayments)-Math.pow(1+monthlyInterestRate,paymentsMade))/(Math.pow(1+monthlyInterestRate,numberOfPayments)-1);
        return balance;
    }
}
