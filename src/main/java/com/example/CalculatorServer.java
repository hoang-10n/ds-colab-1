package com.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            CalculatorImpl obj = new CalculatorImpl();

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind("Calculator", obj);

            System.out.println("CalculatorServer ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
