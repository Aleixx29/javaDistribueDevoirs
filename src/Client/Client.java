package Client;

import Serveur.MacInterface;
import Serveur.OUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client extends JFrame {

    JLabel introduction;
    JLabel nomVendeur;
    JLabel adresseVendeur;
    JLabel inputText;
    JTextField input;
    JButton search;
    JButton clear;
    JButton exit;
    JTextArea resultat1;
    JTextArea resultat2;

    public Client() {
        //On fait appel au constructeur JFrame
        super();

        //On créer notre fenêtre
        this.setTitle("DataDevoir");
        this.setSize(850,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        introduction = new JLabel("Bienvenue dans OUI Lookup Tool, entrez un identifiant et cliquez sur search pour obetnir son nom et son adresse.");
        nomVendeur = new JLabel("Vendor name :");
        adresseVendeur = new JLabel("Vendor address :");
        inputText = new JLabel("Input");
        input = new JTextField(10);
        search = new JButton("Search");
        clear = new JButton("Clear");
        exit = new JButton("Exit");
        resultat1 = new JTextArea();
        resultat2 = new JTextArea();

        Panel panel = new Panel();
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        Panel panel3 = new Panel();
        Panel panel4 = new Panel();

        //Bouton Search
        search.addActionListener(new ActionListener() {
            @Override
            //On met un ActionListener sur notre bouton Search
            public void actionPerformed(ActionEvent e) {
                //On réinit nos champs réusltats
                reset();
                try {
                    //On check le champ input
                    if (input.getText().length() > 0 && verifText(input.getText())){
                        Registry registry = LocateRegistry.getRegistry("127.0.0.1");

                        // Obtenir une r�f�rence de l'objet distant
                        MacInterface stub = (MacInterface) registry.lookup("MacInterface");

                        // Utiliser les m�thodes de l'objet distant
                        OUI OUI = stub.getOUI(input.getText());
                        resultat1.setText(OUI.getOrganizationName());
                        resultat2.setText(OUI.getOrganizationAddress());
                    }else{
                        //Message d'erreur si erreur sur le champ
                        erreur();
                    }
                }catch(Exception ex){
                    System.err.println("Client exception: " + ex.toString());
                    ex.printStackTrace();
                }
            }
        });

        ihm(panel, panel1, panel2, panel3, panel4);


        //Bouton Clear
        clear.addActionListener(new ActionListener() {
            @Override
            //On met un ActionListener sur notre bouton Clear
            public void actionPerformed(ActionEvent e) {
                //On clear les champs resultats
                reset();
            }
        });

        //Bouton Exit
        exit.addActionListener(new ActionListener() {
            @Override
            //On met un ActionListener sur notre bouton Exit
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void ihm(Panel panel, Panel panel1, Panel panel2, Panel panel3, Panel panel4) {
        panel1.add(introduction);
        panel2.add(nomVendeur);
        panel2.add(resultat1);
        panel2.add(adresseVendeur);
        panel2.add(resultat2);
        panel3.add(inputText);
        panel3.add(input);
        panel3.add(search);
        panel3.add(clear);
        panel3.add(exit);
        panel.setLayout(new BorderLayout());
        panel.add(panel1,BorderLayout.NORTH);
        panel.add(panel2,BorderLayout.CENTER);
        panel.add(panel3,BorderLayout.SOUTH);
        this.setContentPane(panel);
        this.setVisible(true);
    }

    private void erreur() {
        resultat1.setForeground(Color.RED);
        resultat1.setText("Il y a une erreur dans la saisie. L'identifiant doit contenir 6 caractères et des majuscules. (exemple : 0050BA) ");
        resultat2.setForeground(Color.RED);
        resultat2.setText("Il y a une erreur dans la saisie. L'identifiant doit contenir 6 caractères et des majuscules. (exemple : 0050BA) ");
    }

    private void reset() {
        resultat1.setText("");
        resultat1.setForeground(Color.BLACK);
        resultat2.setText("");
        resultat2.setForeground(Color.BLACK);
    }

    public boolean verifText (String string){
        //On cherche tous les caractères autre
        if (string.matches("/[0-9A-F]{6}/"))
            return false;
        return true;
    }

    public static void main (String args[]) {
        // On lance notre fenêtre
        Client client = new Client();
    }
}
