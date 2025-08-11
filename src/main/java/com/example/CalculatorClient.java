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

            calculator.pushElement(1);
            calculator.pushElement(2);
            calculator.pushElement(3);

            System.out.println("Calculator after pushing elements: " + calculator.getElements());

            int a = calculator.popElement();

            System.out.println("Calculate after popping one element: " + calculator.getElements());
            System.out.println("The remove element is: " + a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
