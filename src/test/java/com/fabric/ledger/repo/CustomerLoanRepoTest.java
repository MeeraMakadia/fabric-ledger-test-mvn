package com.fabric.ledger.repo;

import com.fabric.legder.module.CustomerLoan;
import com.fabric.legder.module.LumpsumPayment;
import com.fabric.legder.repo.CustomerLoanRepo;
import org.junit.Test;

import static org.junit.Assert.*;


public class CustomerLoanRepoTest {

    private CustomerLoanRepo customerLoanRepo = new CustomerLoanRepo();

    @Test
    public void createCustomerLoanTest() {
        customerLoanRepo.createCustomerLoan( new CustomerLoan("bankName", "custName", 1000, 2, 1));
    }

    @Test  (expected = NullPointerException.class)
    public void createCustomerLoanTestNull() {
        customerLoanRepo.createCustomerLoan(null);
    }

    @Test
    public void getCustomerLoanTest() {
        customerLoanRepo.createCustomerLoan( new CustomerLoan("bankName", "custName", 1000, 2, 1));
        assertNotNull(customerLoanRepo.getCustomerLoan("custName", "bankName"));
        assertNull(customerLoanRepo.getCustomerLoan("custName1", "bankName"));
    }

    @Test
    public void addPaymentTest() {
        customerLoanRepo.createCustomerLoan( new CustomerLoan("bankName", "custName", 1000, 2, 1));
        customerLoanRepo.addPayment("custName", "bankName", new LumpsumPayment("bankName", 500, 4));
        CustomerLoan customerLoan = customerLoanRepo.getCustomerLoan("custName", "bankName");
        assertNotNull(customerLoan);
        assertEquals(1, customerLoan.getPayments().size());
    }

    @Test
    public void addPaymentTestNull() {
        customerLoanRepo.createCustomerLoan( new CustomerLoan("bankName", "custName", 1000, 2, 1));
        customerLoanRepo.addPayment("custName1", "bankName1", new LumpsumPayment("bankName1", 500, 4));
        CustomerLoan customerLoan = customerLoanRepo.getCustomerLoan("custName", "bankName");
        assertNotNull(customerLoan);
        assertEquals(0, customerLoan.getPayments().size());
    }
}
