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
}