package com.fabric.legder.service;

import com.fabric.legder.module.CustomerLoan;


public interface CustomerLoanService {

    void createCustomerLoan(String bankName, String customerName, double principleAmount, double years, double rateOfInt);

    void addPayment(String bankName, String customerName, double lumpsumAmount, int emiNo);

    void printBalance(String bankName, String customerName, int emiNo);

    CustomerLoan getCustomerLoan(String bankName, String customerName);

}
