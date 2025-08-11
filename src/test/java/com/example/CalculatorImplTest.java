package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.util.List;

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

    @Test
    public void testPushElement() throws RemoteException {
        CalculatorImpl calculator = new CalculatorImpl();
        calculator.pushElement(5);
        List<Integer> elements = calculator.getElements();
        assertTrue(elements.contains(5));
    }

    @Test
    public void testPopElement() throws RemoteException {
        CalculatorImpl calculator = new CalculatorImpl();
        calculator.pushElement(10);
        calculator.pushElement(20);
        int a = calculator.popElement();
        List<Integer> elements = calculator.getElements();
        assertFalse(elements.contains(10));
        assertTrue(elements.contains(20));
        assertTrue(a == 10);
    }

    @Test
    public void testClearElements() throws RemoteException {
        CalculatorImpl calculator = new CalculatorImpl();
        calculator.pushElement(5);
        calculator.pushElement(10);
        List<Integer> elements = calculator.getElements();
        assertTrue(elements.contains(5));
        assertTrue(elements.contains(10));
        calculator.clearElements();
        elements = calculator.getElements();
        assertTrue(elements.isEmpty());

    }
}
