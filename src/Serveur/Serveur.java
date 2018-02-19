package Serveur;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Serveur implements MacInterface{
    private OUI OUI;
    Serveur(){
        this.OUI = new OUI();
    }
    //Method appelé à distance
    public OUI getOUI(String assignment) throws RemoteException {
        //réutilisation du code de l'exemple
        TestDataBase req = new TestDataBase();
        String test[] = new String[2];
        test = req.getVendorData(assignment);

        this.OUI.setAssignment(assignment);
        this.OUI.setOrganizationName(test[0]);
        this.OUI.setOrganizationAddress(test[1]);
        //on retourne l'objet OUI au client
        return this.OUI;
    }
    //Main programme du serveur
    public static void main (String args[]) {

        try {
            // Créer un objet instance de la classe Serveur
            Serveur obj = new Serveur();
            // Exporter l'objet pour lui permettre de recevoir des appels externes sur le port 1234 par exemple
            MacInterface stub = (MacInterface) UnicastRemoteObject.exportObject(obj, 1234);

            // Lier le stub de l'objet accessible à distance au registry
            // le port par défaut utilisé par le processus rmiregistery est le port 1099
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
