package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorRMITest {
    @BeforeAll
    public static void setUp() throws Exception {
        CalculatorServer.main(null);
        System.out.println("Calculator RMI server started.");
    }

    @Test
    public void testRMISum() throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        Calculator calculator = (Calculator) registry.lookup("Calculator");
        assertEquals(12, calculator.sum(5, 7));
        assertEquals(30, calculator.sum(10, 20));
        assertEquals(0, calculator.sum(0, 0));
    }

    @Test
    public void testRMISubtract() throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        Calculator calculator = (Calculator) registry.lookup("Calculator");
        assertEquals(2, calculator.subtract(9, 7));
        assertEquals(-10, calculator.subtract(10, 20));
        assertEquals(0, calculator.subtract(0, 0));
    }

    @Test
    public void testRMIMultiply() throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        Calculator calculator = (Calculator) registry.lookup("Calculator");
        assertEquals(35, calculator.multiply(5, 7));
        assertEquals(200, calculator.multiply(10, 20));
        assertEquals(0, calculator.multiply(0, 5));
    }

    @Test
    public void testRMIDivide() throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        Calculator calculator = (Calculator) registry.lookup("Calculator");
        assertEquals(3, calculator.divide(21, 7));
        assertEquals(0.5, calculator.divide(10, 20), 0.0001);
        assertEquals(0, calculator.divide(0, 5));
    }

    @Test
    public void testRMIDivideByZero() throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        Calculator calculator = (Calculator) registry.lookup("Calculator");
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}