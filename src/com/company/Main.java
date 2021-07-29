package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_A_YEAR = 12;
        final byte PERCENT = 100;

        // Taking Inputs
        Scanner scan = new Scanner(System.in);

        // Principal amount
        long principal;
        while (true){
            System.out.print("Principal ($1K - $1M): ");
            principal = scan.nextLong();
            if (!(principal >= 1_000 && principal <= 1_000_000)) {
                System.out.println("Enter a number between 1,000 and 1,000,000.");
                continue;
            }
            break;
        }

        //Annual interest rate
        float interestRate;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            interestRate = scan.nextFloat();
            if (!(interestRate > 0 && interestRate <= 30)) {
                System.out.println("Enter a value greater than 0 and less than or equal to 30.");
                continue;
            }
            break;
        }

        // Period
        int period;
        while (true){
            System.out.print("Period(Years): ");
            period = scan.nextInt();
            if (!(period >= 1 && period <= 30)) {
                System.out.println("Enter a value between 1 and 30.");
                continue;
            }
            break;
        }

        float monthlyInterestRate = interestRate/PERCENT/MONTHS_IN_A_YEAR;
        int numberOfPayments = period*MONTHS_IN_A_YEAR;

        float powerTerm = (float) Math.pow(1+monthlyInterestRate, numberOfPayments);
        double mortgage = (principal*monthlyInterestRate*powerTerm)/(powerTerm-1);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: "+formattedMortgage);
    }
}
