package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_A_YEAR = 12;
        final byte PERCENT = 100;

        // Taking Inputs
        Scanner scan = new Scanner(System.in);
        System.out.print("Principal: ");
        long principle = scan.nextLong();
        System.out.print("Annual Interest Rate: ");
        float interestRate = scan.nextFloat();
        System.out.print("Period(Years): ");
        int period = scan.nextInt();

        float monthlyInterestRate = interestRate/PERCENT/MONTHS_IN_A_YEAR;
        int numberOfPayments = period*MONTHS_IN_A_YEAR;

        float powerTerm = (float) Math.pow(1+monthlyInterestRate, numberOfPayments);
        double mortgage = (principle*monthlyInterestRate*powerTerm)/(powerTerm-1);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: "+formattedMortgage);
    }
}
