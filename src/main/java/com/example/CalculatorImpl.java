package com.example;
// File: SumServiceImpl.java
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements CalculatorService {
    
    public CalculatorImpl() throws RemoteException {
        super();
        //TODO Auto-generated constructor stub
    }

    @Override
    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }
}
