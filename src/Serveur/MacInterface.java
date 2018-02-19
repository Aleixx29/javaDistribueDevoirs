package Serveur;

public interface MacInterface extends java.rmi.Remote {

    public String[] getmac(String assignement) throws java.rmi.RemoteException;

}
