/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author nicam
 */
public interface CoffeeInterface extends Remote {

    void addCapsules(int amount) throws RemoteException;

    void addConsumer(String name) throws RemoteException;

    void drinkCoffee() throws RemoteException;

    int getCapsules() throws RemoteException;

    List getConsumers() throws RemoteException;

    int getSaldo() throws RemoteException;

    void payCoffee(String name) throws Exception, RemoteException;

    void reset() throws RemoteException;
    
}
