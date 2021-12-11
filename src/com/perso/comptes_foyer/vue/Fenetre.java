package com.perso.comptes_foyer.vue;

import com.perso.comptes_foyer.modele.Foyer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Fenetre extends JFrame{
    protected Color couleurViolet = new Color(185, 135, 225);
    protected Color couleurGris = new Color(75, 92, 107);
    protected Color couleurBlanc = new Color(238, 238, 238);
    protected Insets insetsInterieur = new Insets(10, 20, 10, 20);
    protected Font font = new Font("Arial", Font.PLAIN, 30);
    protected final Dimension dimMainMenu = new Dimension(400,50);
    protected final Dimension dimComptesColloc = new Dimension(600,50);
    protected final Dimension dimRecap = new Dimension(400,50);
    protected final JLabel lbTitre = new JLabel();

    protected Foyer foyer;

    protected final JPanel pano = new JPanel();
    protected final GridBagConstraints cont = new GridBagConstraints();

    public Fenetre(Foyer foyer) {
        this.foyer = foyer;
    }

    public void setLabel(JLabel label, String texte){
        label.setText(texte);
        label.setFont(font);
        label.setForeground(couleurGris);
    }

    public void setBouton(JButton bouton, String texte){
        bouton.setText(texte);
        bouton.setFont(font);
        bouton.setBackground(couleurGris);
        bouton.setForeground(couleurBlanc);
    }

    public void setTextField(JTextField textArea, boolean isEditable, Dimension dimension){
        textArea.setFont(font);
        textArea.setEditable(isEditable);
        textArea.setForeground(couleurGris);
        textArea.setMargin(insetsInterieur);
        textArea.setMinimumSize(dimension);
        textArea.setPreferredSize(dimension);
        textArea.setBackground(couleurBlanc);
    }

    public void setTextArea(JTextArea textArea){
        textArea.setFont(font);
        textArea.setEditable(false);
        textArea.setForeground(couleurGris);
        textArea.setMargin(insetsInterieur);
        textArea.setBackground(couleurBlanc);
    }

    public void setComboBox(JComboBox box, Foyer foyer, Dimension dimension){
        box.setFont(font);
        box.setForeground(couleurGris);
        box.setPreferredSize(dimension);
        box.removeAllItems();
        for (int cpt = 0; cpt < foyer.getListPersonne().size(); cpt++){
            box.addItem(foyer.getListPersonne().get(cpt).getNom());
        }
        box.setSelectedIndex(0);
    }
}
