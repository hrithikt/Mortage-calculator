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

    public Loan(int principal, float annualInterestRate, int period) {
        this.principal = principal;
        this.monthlyInterestRate = annualInterestRate /PERCENT/MONTHS_IN_A_YEAR;
        this.numberOfPayments = (period *MONTHS_IN_A_YEAR);
    }

    public int getNumberOfPayments(){
        return numberOfPayments;
    }

    public double calculateMortgage(){
        return principal*(monthlyInterestRate*Math.pow(1+monthlyInterestRate,numberOfPayments))/(Math.pow(1+monthlyInterestRate,numberOfPayments)-1);
    }

    public double calculateBalance(int paymentsMade){
        return principal*(Math.pow(1+monthlyInterestRate,numberOfPayments)-Math.pow(1+monthlyInterestRate,paymentsMade))/(Math.pow(1+monthlyInterestRate,numberOfPayments)-1);
    }
}



