package com.fabric.ledger.util;

import com.fabric.legder.util.CalculatorUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CalculatorUtilsTest {

    @Test
    public void calculateEmiAmountTest() {
        assertEquals(32, (int) CalculatorUtils.calculateEmiAmount(1000, 4, 3));
    }

    @Test
    public void calculateAmountToRepayTest() {
        assertEquals(1120, (int) CalculatorUtils.calculateAmountToRepay(1000, 4, 3));
    }

    @Test
    public void calculateInterestTest() {
        assertEquals(120, (int) CalculatorUtils.calculateInterest(1000, 4, 3));
    }

}
