package Client;

import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {

    JLabel nomVendeur;
    JLabel adresseVendeur;
    JTextField input;
    JButton search;
    JButton deleteData;
    JButton exitApp;

    public Client() {
        //On fait appel au constructeur JFrame
        super();

        //On créer notre fenêtre
        this.setTitle("DataDevoir");
        this.setSize(650,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nomVendeur = new JLabel("Vendor name :");
        adresseVendeur = new JLabel("Vendor address :");
        input = new JTextField(10);
        search = new JButton("Search");
        deleteData = new JButton("Clear");
        exitApp = new JButton("Exit");

        Panel panel = new Panel();
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        Panel panel3 = new Panel();

        //Bouton Search
    }
}
