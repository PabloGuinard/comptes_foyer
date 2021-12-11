package com.perso.comptes_foyer.vue;

import com.perso.comptes_foyer.modele.Foyer;
import com.perso.comptes_foyer.modele.Personne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjoutColloc extends Fenetre implements ActionListener {
    private final JTextField txtNouveauColloc = new JTextField();
    private final JButton btAnnuler = new JButton(), btValiderNouveau = new JButton();

    public AjoutColloc(Foyer foyer) {
        super(foyer);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialisation();
        btAnnuler.addActionListener(this);
        btValiderNouveau.addActionListener(this);
        this.setSize(800, 500);
    }

    public void initialisation(){
        pano.setLayout(new GridBagLayout());
        pano.setBackground(couleurGris);

        composantCreation();
        fenetreCreation();

        this.setContentPane(pano);
        this.pack();
    }

    public void composantCreation(){
        setTextField(txtNouveauColloc, true, dimMainMenu);
        txtNouveauColloc.setPreferredSize(new Dimension(400, 70));
        setBouton(btAnnuler, "ANNULER");
        setBouton(btValiderNouveau, "VALIDER");
        setLabel(lbTitre, "GESTION DES COMPTES");

        lbTitre.setFont(new Font("Arial", Font.BOLD, 40));

        btAnnuler.setBackground(couleurViolet);
        btValiderNouveau.setBackground(couleurViolet);
        lbTitre.setForeground(couleurViolet);

        btAnnuler.setPreferredSize(new Dimension(220, 50));
    }

    public void fenetreCreation(){
        cont.fill = GridBagConstraints.CENTER;
        cont.insets = new Insets(10, 20, 10, 20);
        cont.gridx = 0;
        cont.gridy = 0;
        cont.gridwidth= 2;
        pano.add(lbTitre, cont);


        cont.gridy++;
        cont.fill = GridBagConstraints.BOTH;
        cont.insets = new Insets(80, 20, 10, 20);
        pano.add(txtNouveauColloc, cont);
        cont.gridwidth = 1;

        cont.gridy++;
        cont.insets = new Insets(100, 20, 10, 20);
        pano.add(btAnnuler, cont);
        cont.gridx++;
        pano.add(btValiderNouveau, cont);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btValiderNouveau){
            foyer.getListPersonne().add(new Personne(txtNouveauColloc.getText()));
            //setBouton(listeBoutonsSupprColloc.get(listeBoutonsSupprColloc.size()-1), "X");
            for(int cpt = 0; cpt < foyer.getListPersonne().size(); cpt ++){
                System.out.println(foyer.getListPersonne().get(cpt).getNom());
            }
        }
        this.setVisible(false);
    }
}
