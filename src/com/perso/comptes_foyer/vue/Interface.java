package com.perso.comptes_foyer.vue;

import com.perso.comptes_foyer.modele.Foyer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends Fenetre implements ActionListener {
    private final JLabel lbNbColloc = new JLabel(), lbRabMois = new JLabel(), lbTotalMange = new JLabel(),
            lbTotalAcheteFoyer = new JLabel(), lbNbRepasFoyer = new JLabel(), lbTotalRab = new JLabel(),
            lbColloc = new JLabel(), lbTotalAcheteColloc = new JLabel(), lbNbRepasColloc = new JLabel(), lbTotalDuRecap = new JLabel(),
            lbNbRepasRecap = new JLabel(), lbTotalAcheteRecap = new JLabel();
    private final JButton btAjoutColloc = new JButton(), btRecapComptes = new JButton(), btFaireComptes = new JButton(),
            btValider = new JButton(), btTerminerComptes = new JButton(), btTerminerRecap = new JButton(),
            btSupprColloc = new JButton(), btSelectionnerColloc = new JButton(), btSelectionnerRecap = new JButton();
    private final JTextField txtNbColloc = new JTextField(), txtRabMois = new JTextField(), txtTotalMange = new JTextField(),
            txtTotalAcheteFoyer = new JTextField(), txtNbRepasFoyer = new JTextField(), txtTotalRab = new JTextField(),
            txtNbRepasColloc = new JTextField(), txtTotalAcheteColloc = new JTextField(), txtTotalDuRecap = new JTextField(),
            txtNbRepasRecap = new JTextField(), txtTotalAcheteRecap = new JTextField();
    private final JComboBox boxColloc = new JComboBox();
    private final JTextArea areaDuDoit = new JTextArea();

    private int collocSelectionne = 0;


    public Interface(Foyer foyer){
        super(foyer);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialisation();
        btFaireComptes.addActionListener(this);
        btAjoutColloc.addActionListener(this);
        btRecapComptes.addActionListener(this);
        btTerminerComptes.addActionListener(this);
        btValider.addActionListener(this);
        btSupprColloc.addActionListener(this);
        btTerminerRecap.addActionListener(this);
        btSelectionnerColloc.addActionListener(this);
        btSelectionnerRecap.addActionListener(this);
        this.setSize(1500, 800);
    }

    public void initialisation(){
        pano.setLayout(new GridBagLayout());
        pano.setBackground(couleurViolet);

        composantCreation();
        mainMenuCreation();
        mainMenuRemplissage();

        mainMenuAffiche(true);

        this.setContentPane(pano);
        this.pack();
    }


    public void composantCreation(){
        setLabel(lbNbColloc, "NOMBRE COLLOC");
        setLabel(lbNbRepasFoyer, "NOMBRE REPAS");
        setLabel(lbRabMois, "RAB MOIS");
        setLabel(lbTotalAcheteFoyer, "TOTAL ACHETE");
        setLabel(lbTotalMange, "TOTAL MANGE");
        setLabel(lbTotalRab, "TOTAL RAB");
        setLabel(lbColloc, "COLLOC");
        setLabel(lbNbRepasColloc, "NOMBRE REPAS");
        setLabel(lbTotalAcheteColloc, "TOTAL ACHETE");
        setLabel(lbTotalDuRecap, "TOTAL DÛ");
        setLabel(lbTitre, "GESTION DES COMPTES");
        setLabel(lbNbRepasRecap, "NOMBRE REPAS");
        setLabel(lbTotalAcheteRecap, "TOTAL ACHETE");
        lbTitre.setFont(new Font("Arial", Font.BOLD, 50));
        lbTitre.setPreferredSize(new Dimension(650, 100));

        setBouton(btFaireComptes, "FAIRE COMPTES");
        setBouton(btAjoutColloc, "AJOUT COLLOC");
        setBouton(btRecapComptes, "RECAP COMPTES");
        setBouton(btValider, "VALIDER");
        setBouton(btTerminerComptes, "TERMINER");
        setBouton(btSupprColloc, "SUPPRIMER");
        setBouton(btTerminerRecap, "TERMINER");
        setBouton(btSelectionnerColloc, "SELECTIONNER");
        setBouton(btSelectionnerRecap, "SELECTIONNER");

        setTextField(txtNbColloc, false, dimMainMenu);
        setTextField(txtNbRepasFoyer, false, dimMainMenu);
        setTextField(txtRabMois, false, dimMainMenu);
        setTextField(txtTotalRab, false, dimMainMenu);
        setTextField(txtTotalAcheteFoyer, false, dimMainMenu);
        setTextField(txtTotalMange, false, dimMainMenu);
        setTextField(txtNbRepasColloc, true, dimComptesColloc);
        setTextField(txtTotalAcheteColloc, true, dimComptesColloc);
        setTextField(txtTotalDuRecap, false, dimRecap);
        setTextField(txtNbRepasRecap, false, dimRecap);
        setTextField(txtTotalAcheteRecap, false, dimRecap);

        setTextArea(areaDuDoit);
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
        pano.add(lbRabMois, cont);
        cont.gridx++;
        pano.add(lbTotalAcheteFoyer, cont);

        cont.fill = GridBagConstraints.BOTH;
        cont.insets = new Insets(0, 20, 50, 20);
        cont.gridy++;
        pano.add(txtTotalAcheteFoyer, cont);
        cont.gridx--;
        pano.add(txtRabMois, cont);
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
        pano.add(txtTotalMange, cont);
        cont.gridx--;
        pano.add(txtTotalRab, cont);
        cont.gridx--;
        pano.add(txtNbRepasFoyer, cont);

        cont.insets = new Insets(100, 20, 10, 20);
        cont.gridy++;
        pano.add(btAjoutColloc, cont);
        cont.gridx++;
        pano.add(btRecapComptes, cont);
        cont.gridx++;
        pano.add(btFaireComptes, cont);
        cont.gridx++;
    }

    public void recapComptesCreation(){
        setComboBox(boxColloc, foyer, dimComptesColloc);

        cont.fill = GridBagConstraints.CENTER;
        cont.insets = new Insets(10, 20, 10, 20);
        cont.gridx = 0;
        cont.gridy = 0;
        cont.gridwidth= 3;
        pano.add(lbTitre, cont);
        cont.gridwidth = 1;

        cont.insets = new Insets(10, 20, 10, 20);
        cont.gridx++;
        cont.gridy++;
        pano.add(lbColloc, cont);
        cont.gridy++;
        cont.fill = GridBagConstraints.BOTH;
        cont.insets = new Insets(0, 40, 50, 40);
        pano.add(boxColloc, cont);
        cont.gridx++;
        pano.add(btSelectionnerRecap, cont);

        cont.fill = GridBagConstraints.CENTER;
        cont.insets = new Insets(80, 40, 10, 40);
        cont.gridx = 0;
        cont.gridy++;
        pano.add(lbNbRepasRecap, cont);
        cont.gridx++;
        pano.add(lbTotalAcheteRecap, cont);
        cont.gridx++;
        pano.add(lbTotalDuRecap, cont);

        cont.fill = GridBagConstraints.BOTH;
        cont.insets = new Insets(0, 40, 50, 40);
        cont.gridy++;
        pano.add(txtTotalDuRecap, cont);
        cont.gridx--;
        pano.add(txtTotalAcheteRecap, cont);
        cont.gridx--;
        pano.add(txtNbRepasRecap, cont);

        cont.gridx = 0;
        cont.gridy++;
        cont.gridwidth = 3;
        pano.add(areaDuDoit, cont);
        cont.gridwidth = 1;

        cont.insets = new Insets(50, 40, 10, 40);
        cont.gridy++;
        cont.gridx = 2;
        pano.add(btTerminerRecap, cont);
    }

    public void comptesCollocCreation(){
        setComboBox(boxColloc, foyer, dimComptesColloc);

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

        cont.insets = new Insets(50, 40, 10, 40);
        cont.gridy++;
        pano.add(btSupprColloc, cont);
        cont.fill = GridBagConstraints.CENTER;
        cont.gridx++;
        pano.add(lbTotalAcheteColloc, cont);

        cont.fill = GridBagConstraints.BOTH;
        cont.insets = new Insets(0, 40, 50, 40);
        cont.gridy++;
        pano.add(txtTotalAcheteColloc, cont);
        cont.gridx--;
        pano.add(btSelectionnerColloc, cont);

        cont.fill = GridBagConstraints.BOTH;
        cont.insets = new Insets(100, 40, 10, 40);
        cont.gridy++;
        pano.add(btValider, cont);
        cont.gridx++;
        pano.add(btTerminerComptes, cont);
    }

    public void mainMenuAffiche(boolean estVisible){
        lbTotalAcheteFoyer.setVisible(estVisible);
        lbNbRepasFoyer.setVisible(estVisible);
        lbNbColloc.setVisible(estVisible);
        lbTotalRab.setVisible(estVisible);
        lbRabMois.setVisible(estVisible);
        lbTotalMange.setVisible(estVisible);
        txtNbColloc.setVisible(estVisible);
        txtRabMois.setVisible(estVisible);
        txtTotalAcheteFoyer.setVisible(estVisible);
        txtNbRepasFoyer.setVisible(estVisible);
        txtTotalRab.setVisible(estVisible);
        txtTotalMange.setVisible(estVisible);
        btAjoutColloc.setVisible(estVisible);
        btRecapComptes.setVisible(estVisible);
        btFaireComptes.setVisible(estVisible);
    }

    public void recapComptesAffiche(boolean estVisible){
        lbColloc.setVisible(estVisible);
        boxColloc.setVisible(estVisible);
        lbNbRepasRecap.setVisible(estVisible);
        lbTotalAcheteRecap.setVisible(estVisible);
        lbTotalDuRecap.setVisible(estVisible);
        txtNbRepasRecap.setVisible(estVisible);
        txtTotalAcheteRecap.setVisible(estVisible);
        areaDuDoit.setVisible(estVisible);
        txtTotalDuRecap.setVisible(estVisible);
        btTerminerRecap.setVisible(estVisible);
        btSelectionnerRecap.setVisible(estVisible);
    }
    
    public void comptesCollocAffiche(boolean estVisible){
        btSupprColloc.setVisible(estVisible);
        lbColloc.setVisible(estVisible);
        lbNbRepasColloc.setVisible(estVisible);
        lbTotalAcheteColloc.setVisible(estVisible);
        txtNbRepasColloc.setVisible(estVisible);
        txtTotalAcheteColloc.setVisible(estVisible);
        btValider.setVisible(estVisible);
        btTerminerComptes.setVisible(estVisible);
        boxColloc.setVisible(estVisible);
        btSelectionnerColloc.setVisible(estVisible);
    }

    public void mainMenuRemplissage(){
        txtNbColloc.setText(String.valueOf(foyer.getListPersonne().size()));
        txtRabMois.setText(String.valueOf((int)foyer.getRabMois()));
        txtTotalAcheteFoyer.setText(String.valueOf((int)foyer.getTotalAchete()));
        txtNbRepasFoyer.setText(String.valueOf((int)foyer.getTotalMange()/3));
        txtTotalRab.setText(String.valueOf((int)foyer.getRabTotal()));
        txtTotalMange.setText(String.valueOf((int)foyer.getTotalMange()));
    }

    public void comptesCollocRemplissage(){
        txtNbRepasColloc.setText(String.valueOf(foyer.getListPersonne().get(collocSelectionne).getDoitRepas()/3));
        txtTotalAcheteColloc.setText(String.valueOf(foyer.getListPersonne().get(collocSelectionne).getDuCourses()));
    }

    public void recapComptesRemplissage(){
        txtNbRepasRecap.setText(String.valueOf(foyer.getListPersonne().get(collocSelectionne).getDoitRepas()/3));
        txtTotalAcheteRecap.setText(String.valueOf(foyer.getListPersonne().get(collocSelectionne).getDuCourses()));
        txtTotalDuRecap.setText(String.valueOf(foyer.getListPersonne().get(collocSelectionne).getDoitTotal()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btFaireComptes) {
            mainMenuAffiche(false);
            comptesCollocCreation();
            comptesCollocRemplissage();
            comptesCollocAffiche(true);
        }else if(e.getSource() == btAjoutColloc) {
            AjoutColloc ajoutColloc = new AjoutColloc(foyer);
            ajoutColloc.setVisible(true);
        }else if(e.getSource() == btRecapComptes) {
            mainMenuAffiche(false);
            recapComptesCreation();
            recapComptesRemplissage();
            recapComptesAffiche(true);
        }
        else if(e.getSource() == btTerminerComptes){
            comptesCollocAffiche(false);
            mainMenuCreation();
            mainMenuRemplissage();
            mainMenuAffiche(true);
        }
        else if(e.getSource() == btTerminerRecap){
            recapComptesAffiche(false);
            mainMenuCreation();
            mainMenuRemplissage();
            mainMenuAffiche(true);
        }
        else if(e.getSource() == btSelectionnerColloc){
            collocSelectionne = boxColloc.getSelectedIndex();
            comptesCollocRemplissage();
        }
        else if(e.getSource() == btSupprColloc){
            foyer.getListPersonne().remove(collocSelectionne);
            boxColloc.removeItemAt(collocSelectionne);
            collocSelectionne = 0;
            comptesCollocRemplissage();
        }
        else if(e.getSource() == btValider){
            foyer.getListPersonne().get(collocSelectionne).setDoitRepas(Integer.valueOf(txtNbRepasColloc.getText())*3);
            foyer.getListPersonne().get(collocSelectionne).setDuCourses(Integer.valueOf(txtTotalAcheteColloc.getText()));
            foyer.compteFoyer();
        }
        else if(e.getSource() == btSelectionnerRecap){
            collocSelectionne = boxColloc.getSelectedIndex();
            recapComptesRemplissage();
        }
    }
}
