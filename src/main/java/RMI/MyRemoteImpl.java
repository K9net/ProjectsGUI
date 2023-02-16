package RMI;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    protected MyRemoteImpl() throws RemoteException {
    }

    @Override
    public String sayHello(){
        return "Hello";
    }

    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            MyRemote service = new MyRemoteImpl();
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 10555);
            registry.bind("ServerRemote", service);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
