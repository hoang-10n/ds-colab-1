package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAdd() throws Exception {
        CalculatorImpl calculator = new CalculatorImpl();
        assertEquals(12, calculator.sum(5, 7));
        assertEquals(30, calculator.sum(10, 20));
        assertEquals(0, calculator.sum(0, 0));

    }
}
