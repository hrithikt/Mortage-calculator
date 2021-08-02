package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Loan {
    //declaring constants
    final byte MONTHS_IN_A_YEAR = 12;
    final byte PERCENT = 100;

    static private int principal;
    static private float monthlyInterestRate;
    static private int numberOfPayments;

    public Loan() {
        principal = (int) readNumber("Principal", 1_000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate", 1, 30);
        float period = (int) readNumber("Period", 1, 30);
        monthlyInterestRate = annualInterestRate /PERCENT/MONTHS_IN_A_YEAR;
        numberOfPayments = (int) (period *MONTHS_IN_A_YEAR);
    }

    private double readNumber(String prompt, int minimum, int maximum) {
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

    public void printMortgage(){
        double mortgage = calculateMortgage();
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + formattedMortgage);
    }

    private static double calculateMortgage(){
        return principal*(monthlyInterestRate*Math.pow(1+monthlyInterestRate,numberOfPayments))/(Math.pow(1+monthlyInterestRate,numberOfPayments)-1);
    }

    public void printPaymentSchedule(){
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for(int paymentsMade = 1; paymentsMade <= numberOfPayments; paymentsMade++){
            double balance = calculateBalance(paymentsMade);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
    private static double calculateBalance(int paymentsMade){
        return principal*(Math.pow(1+monthlyInterestRate,numberOfPayments)-Math.pow(1+monthlyInterestRate,paymentsMade))/(Math.pow(1+monthlyInterestRate,numberOfPayments)-1);
    }
}



