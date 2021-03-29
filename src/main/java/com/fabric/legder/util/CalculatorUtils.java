package com.fabric.legder.util;


public class CalculatorUtils {

    public static double calculateEmiAmount(double principalAmount, double rateOfInt, double years) {
        double interest = calculateInterest(principalAmount, rateOfInt, years);
        double a = principalAmount + interest;
        return Math.ceil(a / (years * 12));
    }

    public static double calculateAmountToRepay(double principalAmount, double rateOfInt, double years) {
        double interest = calculateInterest(principalAmount, rateOfInt, years);
        return principalAmount + interest;
    }

    public static double calculateInterest(double principalAmount, double rateOfInt, double years) {
        return (principalAmount * rateOfInt * years) / 100;
    }
}
