package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Loan {
    //declaring constants
    final byte MONTHS_IN_A_YEAR = 12;
    final byte PERCENT = 100;

    private int principal;
    private float monthlyInterestRate;
    private int numberOfPayments;

    public Loan() {
        principal = (int) InputConsole.readNumber("Principal", 1_000, 1_000_000);
        float annualInterestRate = (float) InputConsole.readNumber("Annual Interest Rate", 1, 30);
        int period = (int) InputConsole.readNumber("Period", 1, 30);

        monthlyInterestRate = annualInterestRate /PERCENT/MONTHS_IN_A_YEAR;
        numberOfPayments = (period *MONTHS_IN_A_YEAR);
    }

    public void printMortgage(){
        double mortgage = calculateMortgage();
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + formattedMortgage);
    }

    private double calculateMortgage(){
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
    private double calculateBalance(int paymentsMade){
        return principal*(Math.pow(1+monthlyInterestRate,numberOfPayments)-Math.pow(1+monthlyInterestRate,paymentsMade))/(Math.pow(1+monthlyInterestRate,numberOfPayments)-1);
    }
}



