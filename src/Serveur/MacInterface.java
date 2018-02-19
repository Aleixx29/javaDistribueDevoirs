package Serveur;

public interface MacInterface extends java.rmi.Remote {

    public OUI getOUI(String assignement) throws java.rmi.RemoteException;

}
