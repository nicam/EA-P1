//---------------------------------------------------------------
// File: SampleClient.java
//---------------------------------------------------------------
import java.rmi.*;
import java.rmi.server.*;

public class SampleClient {

    public static void connectAndCall() {
        try {
            //get the remote object from the registry
            String url = "//localhost/SAMPLE-SERVER";
            SampleServer remoteObject = (SampleServer) Naming.lookup(url);
            System.out.println("Got remote object");
          //narrow the object down to a specific one
            //System.out.println("Location: " + System.getProperty("LOCATION"));
            // make the invocation

            System.out.println(" 1 + 2 = " + remoteObject.sum(1, 2));
            System.out.println(" SampleData = " + remoteObject.getData().getValue());
        } catch (RemoteException exc) {
            System.out.println("Error in lookup: " + exc.toString());
        } catch (java.net.MalformedURLException exc) {
            System.out.println("Malformed URL: " + exc.toString());
        } catch (java.rmi.NotBoundException exc) {
            System.out.println("NotBound: " + exc.toString());
        }

    }

    public static void main(String[] args) {
        // set the security manager for the client
        System.setSecurityManager(new RMISecurityManager());
        System.out.println("Security Manager loaded");

        connectAndCall();

    }
}
