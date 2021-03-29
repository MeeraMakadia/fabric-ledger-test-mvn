package com.fabric.legder.service;

import com.fabric.legder.module.CustomerLoan;
import com.fabric.legder.module.LumpsumPayment;
import com.fabric.legder.repo.CustomerLoanRepo;

public class CustomerLoanServiceImpl implements CustomerLoanService {

    private CustomerLoanRepo customerLoanRepo = new CustomerLoanRepo();

    public void createCustomerLoan(String bankName, String customerName, double principleAmount, double years, double rateOfInt) {
        CustomerLoan customerLoan = new CustomerLoan(bankName, customerName, principleAmount, rateOfInt, years);
        customerLoanRepo.createCustomerLoan(customerLoan);
    }

    public void addPayment(String bankName, String customerName, double lumpsumAmount, int emiNo) {
        LumpsumPayment payment = new LumpsumPayment(bankName, lumpsumAmount, emiNo);
        customerLoanRepo.addPayment(customerName, bankName, payment);
    }

    public void printBalance(String bankName, String customerName, int emiNo) {
        CustomerLoan customerLoan = customerLoanRepo.getCustomerLoan(customerName, bankName);
        if (customerLoan != null) {
            customerLoan.printBalance(emiNo);
        }
    }

    public CustomerLoan getCustomerLoan(String bankName, String customerName) {
        return customerLoanRepo.getCustomerLoan(customerName, bankName);
    }
}
