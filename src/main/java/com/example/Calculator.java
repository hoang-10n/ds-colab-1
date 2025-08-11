package com.example;

import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    int sum(int a, int b) throws RemoteException;

    int subtract(int a, int b) throws RemoteException;

    int multiply(int a, int b) throws RemoteException;

    double divide(int a, int b) throws RemoteException;

    int pushElement(int a) throws RemoteException;

    int popElement() throws RemoteException;

    List<Integer> getElements() throws RemoteException;

    void clearElements() throws RemoteException;
}
