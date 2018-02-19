package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame {

    JLabel nomVendeur;
    JLabel adresseVendeur;
    JTextField input;
    JButton search;
    JButton clear;
    JButton exit;

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
        clear = new JButton("Clear");
        exit = new JButton("Exit");

        Panel panel = new Panel();
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        Panel panel3 = new Panel();

        //Bouton Search
        search.addActionListener(new ActionListener() {
            @Override
            //On met un ActionListener sur notre bouton Search
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Bouton Clear
        clear.addActionListener(new ActionListener() {
            @Override
            //On met un ActionListener sur notre bouton Clear
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Bouton Exit
        exit.addActionListener(new ActionListener() {
            @Override
            //On met un ActionListener sur notre bouton Exit
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
