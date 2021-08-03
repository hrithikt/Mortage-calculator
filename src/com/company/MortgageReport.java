package com.company;

import java.text.NumberFormat;

public class MortgageReport {

    private final Loan loanCalculator;

    public MortgageReport(Loan loanCalculator){
        this.loanCalculator = loanCalculator;
    }

    public void printMortgage(){
        double mortgage = loanCalculator.calculateMortgage();
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + formattedMortgage);
    }

    public void printPaymentSchedule(){
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        double[] paymentSchedule = loanCalculator.getPaymentSchedule();
        for (double v : paymentSchedule) {
            System.out.println(NumberFormat.getCurrencyInstance().format(v));
        }
    }
}
