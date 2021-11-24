package com.perso.comptes_foyer.vue;

import com.perso.comptes_foyer.modele.Foyer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interface extends Fenetre implements ActionListener {
    private final JLabel lbNbColloc = new JLabel(), lbRabFoyer = new JLabel(), lbTotalMange = new JLabel(),
            lbTotalAcheteFoyer = new JLabel(), lbNbRepasFoyer = new JLabel(), lbTotalRab = new JLabel(),
            lbColloc = new JLabel(), lbTotalAcheteColloc = new JLabel(), lbNbRepasColloc = new JLabel();
    private final JButton btGestionColloc = new JButton(), btRecapComptes = new JButton(), btFaireComptes = new JButton(),
            btValider = new JButton(), btTerminerComptes = new JButton(), btTerminerGestion = new JButton(),
            btAjouterColloc = new JButton();
    private final JTextField txtNbColloc = new JTextField(), txtRabFoyer = new JTextField(), txtTotalMange = new JTextField(),
            txtTotalAcheteFoyer = new JTextField(), txtNbRepasFoyer = new JTextField(), txtTotalRab = new JTextField(),
            txtNbRepasColloc = new JTextField(), txtTotalAcheteColloc = new JTextField();
    private final JComboBox boxColloc = new JComboBox();

    private Foyer foyer;
    private EnumPage page;


    public Interface(Foyer foyer){
        this.foyer = foyer;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialisation();
        btFaireComptes.addActionListener(this);
        btGestionColloc.addActionListener(this);
        btRecapComptes.addActionListener(this);
        btTerminerComptes.addActionListener(this);
        btValider.addActionListener(this);
        btAjouterColloc.addActionListener(this);
        this.setSize(1500, 800);
    }

    public void initialisation(){
        pano.setLayout(new GridBagLayout());
        pano.setBackground(couleurViolet);

        composantCreation();
        mainMenuCreation();

        mainMenuAffiche(true);

        this.setContentPane(pano);
        this.pack();
    }


    public void composantCreation(){
        //fenêtre MaineMenu
        setLabel(lbNbColloc, "NOMBRE COLLOC");
        setLabel(lbNbRepasFoyer, "NOMBRE REPAS");
        setLabel(lbRabFoyer, "RAB FOYER");
        setLabel(lbTotalAcheteFoyer, "TOTAL ACHETE");
        setLabel(lbTotalMange, "TOTAL MANGE");
        setLabel(lbTotalRab, "TOTAL RAB");
        setLabel(lbColloc, "COLLOC");
        setLabel(lbNbRepasColloc, "NOMBRE REPAS");
        setLabel(lbTotalAcheteColloc, "TOTAL ACHETE");
        setLabel(lbTitre, "GESTION DES COMPTES");
        lbTitre.setFont(new Font("Arial", Font.BOLD, 50));
        lbTitre.setPreferredSize(new Dimension(650, 100));

        setBouton(btFaireComptes, "FAIRE COMPTES");
        setBouton(btGestionColloc, "GESTION COLLOC");
        setBouton(btRecapComptes, "RECAP COMPTES");
        setBouton(btValider, "VALIDER");
        setBouton(btTerminerComptes, "TERMINER");

        setTextField(txtNbColloc, false, dimMainMenu, "");
        setTextField(txtNbRepasFoyer, false, dimMainMenu, "");
        setTextField(txtRabFoyer, false, dimMainMenu, "");
        setTextField(txtTotalRab, false, dimMainMenu, "");
        setTextField(txtTotalAcheteFoyer, false, dimMainMenu, "");
        setTextField(txtTotalMange, false, dimMainMenu, "");
        setTextField(txtNbRepasColloc, true, dimComptesColloc, "");
        setTextField(txtTotalAcheteColloc, true, dimComptesColloc, "");

        setComboBox(boxColloc, foyer, dimComptesColloc);
    }

    public void mainMenuCreation(){
        cont.fill = GridBagConstraints.CENTER;
        cont.insets = new Insets(10, 20, 10, 20);
        cont.gridx = 0;
        cont.gridy = 0;
        cont.gridwidth= 3;
        pano.add(lbTitre, cont);

        cont.insets = new Insets(80, 20, 10, 20);
        cont.gridy++;
        cont.gridwidth = 1;
        pano.add(lbNbColloc, cont);
        cont.gridx++;
        pano.add(lbRabFoyer, cont);
        cont.gridx++;
        pano.add(lbTotalAcheteFoyer, cont);

        cont.fill = GridBagConstraints.BOTH;
        cont.insets = new Insets(0, 20, 50, 20);
        cont.gridy++;
        pano.add(txtTotalAcheteFoyer, cont);
        cont.gridx--;
        pano.add(txtRabFoyer, cont);
        cont.gridx--;
        pano.add(txtNbColloc, cont);

        cont.fill = GridBagConstraints.CENTER;
        cont.insets = new Insets(50, 20, 10, 20);
        cont.gridy++;
        pano.add(lbNbRepasFoyer, cont);
        cont.gridx++;
        pano.add(lbTotalRab, cont);
        cont.gridx++;
        pano.add(lbTotalMange, cont);

        cont.fill = GridBagConstraints.BOTH;
        cont.insets = new Insets(0, 20, 50, 20);
        cont.gridy++;
        pano.add(txtNbRepasFoyer, cont);
        cont.gridx--;
        pano.add(txtTotalRab, cont);
        cont.gridx--;
        pano.add(txtTotalMange, cont);

        cont.fill = GridBagConstraints.BOTH;
        cont.insets = new Insets(100, 20, 10, 20);
        cont.gridy++;
        pano.add(btGestionColloc, cont);
        cont.gridx++;
        pano.add(btRecapComptes, cont);
        cont.gridx++;
        pano.add(btFaireComptes, cont);
        cont.gridx++;
    }

    public void comptesCollocCreation(){
        cont.fill = GridBagConstraints.CENTER;
        cont.insets = new Insets(10, 20, 10, 20);
        cont.gridx = 0;
        cont.gridy = 0;
        cont.gridwidth= 2;
        pano.add(lbTitre, cont);
        cont.gridwidth = 1;

        cont.insets = new Insets(80, 40, 10, 40);
        cont.gridx = 0;
        cont.gridy = 1;
        pano.add(lbColloc, cont);
        cont.gridx++;
        pano.add(lbNbRepasColloc, cont);

        cont.fill = GridBagConstraints.BOTH;
        cont.insets = new Insets(0, 40, 50, 40);
        cont.gridy++;
        pano.add(txtNbRepasColloc, cont);
        cont.gridx--;
        pano.add(boxColloc, cont);

        cont.fill = GridBagConstraints.CENTER;
        cont.insets = new Insets(50, 40, 10, 40);
        cont.gridy++;
        cont.gridx++;
        pano.add(lbTotalAcheteColloc, cont);

        cont.fill = GridBagConstraints.BOTH;
        cont.insets = new Insets(0, 40, 50, 40);
        cont.gridy++;
        pano.add(txtTotalAcheteColloc, cont);
        cont.gridx--;
        pano.add(btValider, cont);

        cont.fill = GridBagConstraints.BOTH;
        cont.insets = new Insets(100, 40, 10, 40);
        cont.gridy++;
        cont.gridx++;
        pano.add(btTerminerComptes, cont);
    }

    public void mainMenuAffiche(boolean estVisible){
        lbNbColloc.setVisible(estVisible);
        lbRabFoyer.setVisible(estVisible);
        lbTotalAcheteFoyer.setVisible(estVisible);
        lbNbRepasFoyer.setVisible(estVisible);
        lbTotalRab.setVisible(estVisible);
        lbTotalMange.setVisible(estVisible);
        txtNbColloc.setVisible(estVisible);
        txtRabFoyer.setVisible(estVisible);
        txtTotalAcheteFoyer.setVisible(estVisible);
        txtNbRepasFoyer.setVisible(estVisible);
        txtTotalRab.setVisible(estVisible);
        txtTotalMange.setVisible(estVisible);
        btGestionColloc.setVisible(estVisible);
        btRecapComptes.setVisible(estVisible);
        btFaireComptes.setVisible(estVisible);
    }
    
    public void comptesCollocAffiche(boolean estVisible){
        lbColloc.setVisible(estVisible);
        lbNbRepasColloc.setVisible(estVisible);
        lbTotalAcheteColloc.setVisible(estVisible);
        txtNbRepasColloc.setVisible(estVisible);
        txtTotalAcheteColloc.setVisible(estVisible);
        btValider.setVisible(estVisible);
        btTerminerComptes.setVisible(estVisible);
        boxColloc.setVisible(estVisible);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btFaireComptes) {
            mainMenuAffiche(false);
            comptesCollocCreation();
            comptesCollocAffiche(true);
        }else if(e.getSource() == btAjouterColloc) {
            mainMenuAffiche(false);
        }else if(e.getSource() == btRecapComptes) {
            mainMenuAffiche(false);
        }
        else if(e.getSource() == btTerminerComptes){
            comptesCollocAffiche(false);
            mainMenuCreation();
            mainMenuAffiche(true);
        }
        else if(e.getSource() == btGestionColloc){
            AjoutColloc ajoutColloc = new AjoutColloc();
            ajoutColloc.setVisible(true);
        }
    }
}
