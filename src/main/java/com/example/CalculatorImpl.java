package com.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    private final List<Integer> elements;

    public CalculatorImpl() throws RemoteException {
        super();
        elements = new ArrayList<Integer>();
    }

    @Override
    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public double divide(int a, int b) throws RemoteException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (double) a / b;
    }

    @Override
    public int pushElement(int a) throws RemoteException {
        elements.add(a);
        return a;
    }

    @Override
    public int popElement() throws RemoteException {
        int a = elements.remove(0);
        return a;
    }

    @Override
    public List<Integer> getElements() throws RemoteException {
        return elements;
    }

    @Override
    public void clearElements() throws RemoteException {
        elements.clear();
    }
}
