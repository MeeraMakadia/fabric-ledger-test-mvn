package com.fabric.legder.module;

import com.fabric.legder.util.CalculatorUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class CustomerLoan {
    private String customerName;
    private String bankName;
    private double principalAmount;
    private double rateOfInterest;
    private double years;
    private int totalNoOfEmi;
    private double emiAmount;
    private double amountToRepay;
    List<LumpsumPayment> payments = new ArrayList<LumpsumPayment>();

    public CustomerLoan(String bankName, String customerName, double principalAmount, double rateOfInterest, double years) {
        this.customerName = customerName;
        this.bankName = bankName;
        this.principalAmount = principalAmount;
        this.rateOfInterest = rateOfInterest;
        this.years = years;
        totalNoOfEmi = (int) Math.ceil(years * 12);
        emiAmount = CalculatorUtils.calculateEmiAmount(principalAmount, rateOfInterest, years);
        amountToRepay = CalculatorUtils.calculateAmountToRepay(principalAmount, rateOfInterest, years);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public double getYears() {
        return years;
    }

    public void setYears(double years) {
        this.years = years;
    }

    public int getTotalNoOfEmi() {
        return totalNoOfEmi;
    }

    public void setTotalNoOfEmi(int noOfEmi) {
        this.totalNoOfEmi = noOfEmi;
    }

    public List<LumpsumPayment> getPayments() {
        return payments.stream().sorted(Comparator.comparingInt(LumpsumPayment:: getEmiNo)).collect(Collectors.toList());
    }

    public void addPayment(LumpsumPayment payment) {
        if (payment.getEmiNo() > 0 && this.totalNoOfEmi > payment.getEmiNo()) {
            this.payments.add(payment);
        }
    }

    public void setPayments(List<LumpsumPayment> payments) {
        this.payments = payments;
    }

    public double getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(double emiAmount) {
        this.emiAmount = emiAmount;
    }

    public double getAmountToRepay() {
        return amountToRepay;
    }

    public void setAmountToRepay(double amountToRepay) {
        this.amountToRepay = amountToRepay;
    }

    public void printBalance(int emiNo) {
        //first check no of emi
        if (emiNo >= this.totalNoOfEmi) {
            System.out.println(this.bankName + " " + this.customerName + " " + (int) this.amountToRepay + " " + 0);
        } else {
            if (this.payments.size() == 0) {
                System.out.println(this.bankName + " " + this.customerName + " " + (int) (this.emiAmount * emiNo) + " " + (int) (this.totalNoOfEmi - emiNo));
            } else {
                double emiPaid = this.emiAmount * emiNo;
                double paymentPaid = 0;
                for (LumpsumPayment lumpsumPayment : this.getPayments()) {
                    if (emiNo >= lumpsumPayment.getEmiNo()) {
                        paymentPaid = paymentPaid + lumpsumPayment.getPaymentAmount();
                    }
                }
                //find possible emi
                int noOfPossibleEmi = (int) Math.ceil((this.amountToRepay - paymentPaid)/this.emiAmount);

                if ((noOfPossibleEmi - emiNo) <= 0) {
                    System.out.println(this.bankName + " " + this.customerName + " " + (int) this.amountToRepay + " " + 0);
                } else {
                    System.out.println(this.bankName + " " + this.customerName + " " + (int) (paymentPaid + emiPaid) + " " + (noOfPossibleEmi - emiNo));
                }
            }
        }

    }
}
