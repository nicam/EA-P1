//-----------------------------------------------------------
// File: SampleServerImpl.java
//-----------------------------------------------------------

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class SampleServerImpl extends UnicastRemoteObject
                             implements SampleServer
{
  SampleServerImpl() throws RemoteException
  {
     super();
  }

  public int sum(int a,int b) throws RemoteException
  {
  	 System.out.println("sum "+a+" "+b);
     return a + b;
  }
  
  public SampleData getData() throws RemoteException {
  	SampleData d  = new SampleData();
  	d.setValue("Hello World");
  	return d;
  }
  
  
  
  public static void startServer(UnicastRemoteObject Server) {
     //set the security manager
    try
      {
        System.setSecurityManager(new RMISecurityManager());

        //put the local instance in the registry
        Naming.rebind("COFFEE-SERVER" , Server);

        System.out.println("Server waiting.....");
      }
    catch (java.net.MalformedURLException me)
      {
         System.out.println("Malformed URL: " + me.toString());
      }

    catch (RemoteException re)
      {
         System.out.println("Remote exception: " + re.toString());
      } 	 
  }

  public static void main(String args[]) throws Exception
  {
  	//create a local instance of the object
    SampleServerImpl Server = new SampleServerImpl();
		startServer(Server);
  }
}


