package com.example;
// File: SumService.java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorService extends Remote {
    int sum(int a, int b) throws RemoteException;
}
