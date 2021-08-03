package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principal = (int)InputConsole.readNumber("Principal", 1_000, 1_000_000);
        float annualInterestRate = (float)InputConsole.readNumber("Annual Interest Rate", 1, 30);
        byte period = (byte)InputConsole.readNumber("Period (Years)", 1, 30);

        var loan1 = new Loan(principal, annualInterestRate, period);
        var report1 = new MortgageReport(loan1);
        report1.printMortgage();
        report1.printPaymentSchedule();
    }
}
