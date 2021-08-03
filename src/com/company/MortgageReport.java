package com.company;

import java.text.NumberFormat;

public class MortgageReport {

    private Loan loanCalculator;

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
        for(int paymentsMade = 1; paymentsMade <= loanCalculator.getNumberOfPayments(); paymentsMade++){
            double balance = loanCalculator.calculateBalance(paymentsMade);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
