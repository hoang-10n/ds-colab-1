package com.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator calculator = (Calculator) registry.lookup("Calculator");
            System.out.println("Sum: " + calculator.sum(5, 3));
            System.out.println("Subtract: " + calculator.subtract(5, 3));
            System.out.println("Multiply: " + calculator.multiply(5, 3));
            System.out.println("Divide: " + calculator.divide(5, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
