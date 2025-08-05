import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.example.CalculatorImpl;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // Create and export remote object
            CalculatorImpl obj = new CalculatorImpl();
            Calculator stub = (Calculator) UnicastRemoteObject.exportObject(obj, 0);

            // Get registry or create one
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object's stub in the registry
            registry.rebind("Calculator", stub);

            System.out.println("CalculatorServer ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
