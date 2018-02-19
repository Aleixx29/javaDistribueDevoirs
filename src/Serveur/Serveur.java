package Serveur;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Serveur implements MacInterface{
    private mac mac;
    Serveur(){
        this.mac = new mac();
    }
    public String[] getmac(String assignment) throws RemoteException {
        TestDataBase req = new TestDataBase();
        String test[] = new String[2];
        test = req.getVendorData(assignment);

        this.mac.setAssignment(assignment);
        this.mac.setOrganizationName(test[0]);
        this.mac.setOrganizationAddress(test[1]);

        return test;
    }
    public static void main (String args[]) {

        try {
            // Cr�er un objet instance de la classe ServeurHello
            Serveur obj = new Serveur();
            // Exporter l'objet pour lui permettre de recevoir des appels externes sur le port 1234 par exemple
            MacInterface stub = (MacInterface) UnicastRemoteObject.exportObject(obj, 1234);

            // Lier le stub de l'objet accessible � distance au registry
            // le port par d�faut utilis� par le processus rmiregistery est le port 1099
            //Registry registry = LocateRegistry.getRegistry();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("MacInterface", stub);

            System.err.println("DataServer waiting ...");
        }
        catch (Exception e) {
            System.err.println("DataServer exception: " + e.toString());
            e.printStackTrace();
        }


    }
}
