package com.fabric.legder.repo;

import com.fabric.legder.module.CustomerLoan;
import com.fabric.legder.module.LumpsumPayment;

import java.util.HashMap;
import java.util.Map;


public class CustomerLoanRepo {

    private Map<String, CustomerLoan> customerLoanMap = new HashMap<String, CustomerLoan>();

    public void createCustomerLoan(CustomerLoan customerLoan) {
        customerLoanMap.put(customerLoan.getCustomerName() + customerLoan.getBankName(), customerLoan);
    }

    public CustomerLoan getCustomerLoan(String customerName, String bankName) {
        return customerLoanMap.get(customerName + bankName);
    }

    public void addPayment(String customerName, String bankName, LumpsumPayment payment) {
        CustomerLoan customerLoan = customerLoanMap.get(customerName + bankName);
        if (customerLoan != null) {
            customerLoan.addPayment(payment);
        }
    }
}
