import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Get registry from localhost
            Registry registry = LocateRegistry.getRegistry("localhost");

            // Lookup the remote object
            Calculator stub = (Calculator) registry.lookup("Calculator");

            // Call remote method
            int result = stub.add(10, 20);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
