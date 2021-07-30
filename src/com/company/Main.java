package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Taking Inputs
        Scanner scan = new Scanner(System.in);

        // Principal amount
        int principal;
        while (true){
            System.out.print("Principal ($1K - $1M): ");
            principal = scan.nextInt();
            if (principal >= 1_000 && principal <= 1_000_000) {
                break;
            }
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        //Annual interest rate
        float annualinterestRate;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualinterestRate = scan.nextFloat();
            if (annualinterestRate > 0 && annualinterestRate <= 30) {
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }

        // Period
        int period;
        while (true){
            System.out.print("Period(Years): ");
            period = scan.nextInt();
            if (period >= 1 && period <= 30) {
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }

        double mortgage = calculateMortgage(principal,annualinterestRate,period);

        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: "+formattedMortgage);
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
