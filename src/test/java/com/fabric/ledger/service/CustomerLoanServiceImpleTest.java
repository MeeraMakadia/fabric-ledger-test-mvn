package com.fabric.ledger.service;

import com.fabric.legder.module.CustomerLoan;
import com.fabric.legder.service.CustomerLoanService;
import com.fabric.legder.service.CustomerLoanServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CustomerLoanServiceImpleTest {

    CustomerLoanService customerLoanService = new CustomerLoanServiceImpl();

    @Test
    public void getBalanceTest() {
        customerLoanService.createCustomerLoan("IDIDI", "Dale",5000, 1, 6 );
        customerLoanService.addPayment("IDIDI", "Dale",1000, 5);
        customerLoanService.printBalance("IDIDI", "Dale",3);
        customerLoanService.printBalance("IDIDI", "Dale",6);
        customerLoanService.printBalance("IDIDI", "Dale",13);
        customerLoanService.printBalance("IDIDI2", "Dale2",13);
    }


    @Test
    public void addPaymentTest() {
        customerLoanService.createCustomerLoan("IDIDI", "Dale",5000, 1, 6 );
        customerLoanService.addPayment("IDIDI", "Dale",1000, 5);
        customerLoanService.addPayment("IDIDI", "Dale",200, 0);
        customerLoanService.addPayment("IDIDI", "Dale",300, 7);
        customerLoanService.addPayment("IDIDI1", "Dale1",300, 1);
        CustomerLoan customerLoan = customerLoanService.getCustomerLoan("IDIDI", "Dale");
        assertEquals(2, customerLoan.getPayments().size());
    }


    @Test
    public void createCustomerLoanTest() {
        customerLoanService.createCustomerLoan("IDIDI", "Dale",5000, 1, 6 );
        CustomerLoan customerLoan = customerLoanService.getCustomerLoan("IDIDI", "Dale");
        assertNotNull(customerLoan);
        assertEquals(0, customerLoan.getPayments().size());
        assertEquals(12, customerLoan.getTotalNoOfEmi());
        assertEquals(5300, (int) customerLoan.getAmountToRepay());
    }
}
