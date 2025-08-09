package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorImplTest {

    @Test
    public void testSum() throws Exception {
        CalculatorImpl calculator = new CalculatorImpl();
        assertEquals(12, calculator.sum(5, 7));
        assertEquals(30, calculator.sum(10, 20));
        assertEquals(0, calculator.sum(0, 0));
    }

    @Test
    public void testSubtract() throws Exception {
        CalculatorImpl calculator = new CalculatorImpl();
        assertEquals(2, calculator.subtract(9, 7));
        assertEquals(-10, calculator.subtract(10, 20));
        assertEquals(0, calculator.subtract(0, 0));
    }

    @Test
    public void testMultiply() throws Exception {
        CalculatorImpl calculator = new CalculatorImpl();
        assertEquals(35, calculator.multiply(5, 7));
        assertEquals(200, calculator.multiply(10, 20));
        assertEquals(0, calculator.multiply(0, 5));
    }

    @Test
    public void testDivide() throws Exception {
        CalculatorImpl calculator = new CalculatorImpl();
        assertEquals(3, calculator.divide(21, 7));
        assertEquals(0.5, calculator.divide(10, 20), 0.0001);
        assertEquals(0, calculator.divide(0, 5));
    }

    @Test
    public void testDivideByZero() throws Exception {
        CalculatorImpl calculator = new CalculatorImpl();
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}
