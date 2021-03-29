package com.fabric.legder.module;


public class LumpsumPayment {

    private String bankName;
    private double paymentAmount;
    private int emiNo;

    public LumpsumPayment(String bankName, double paymentAmount, int emiNo) {
        this.bankName = bankName;
        this.paymentAmount = paymentAmount;
        this.emiNo = emiNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getEmiNo() {
        return emiNo;
    }

    public void setEmiNo(int emiNo) {
        this.emiNo = emiNo;
    }
}
