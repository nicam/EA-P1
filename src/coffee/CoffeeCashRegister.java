package coffee;

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class CoffeeCashRegister extends UnicastRemoteObject implements CoffeeInterface {

    private static List consumers = new LinkedList(Arrays.asList("Peter"));
    private static int capsules = 100;
    private static int saldo = 0;

    CoffeeCashRegister() throws RemoteException {
        super();
    }

    public void addConsumer(String name) {
        consumers.add(name);
    }

    public void reset() {
        consumers = new LinkedList(Arrays.asList("Peter"));
        capsules = 100;
        saldo = 0;
    }

    public List getConsumers() {
        return consumers;
    }

    public int getCapsules() {
        return capsules;
    }

    public int getSaldo() {
        return saldo;
    }

    public void addCapsules(int amount) {
        System.out.println("Add Capsules");
        capsules += amount;
        saldo -= amount;
    }

    public void payCoffee(String name) throws Exception {
        if (consumers.contains(name)) {
            saldo += 1;
        } else {
            throw new Exception("unknown consumer");
        }
    }

    public void drinkCoffee() {
        capsules -= 1;
    }

    public static void startServer(UnicastRemoteObject Server) {
        //set the security manager
        try {
            System.setSecurityManager(new RMISecurityManager());

            //put the local instance in the registry
            Naming.rebind("COFFEE-SERVER", Server);

            System.out.println("Server waiting.....");
        } catch (java.net.MalformedURLException me) {
            System.out.println("Malformed URL: " + me.toString());
        } catch (RemoteException re) {
            System.out.println("Remote exception: " + re.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Coffee Server starting");
        
        CoffeeCashRegister Server = new CoffeeCashRegister();
        startServer(Server);
    }
    

}
