package com.perso.comptes_foyer.modele;

import java.util.ArrayList;

public class Foyer {
    private ArrayList<Personne> listPersonne;
    private double totalAchete;
    private double totalMange;
    private double rabTotal;
    private double rabMois;

    public Foyer() {
        this.listPersonne = new ArrayList<>();
        this.rabTotal = 0;
    }

    public double getTotalAchete() {
        return totalAchete;
    }
    public void setTotalAchete(double totalAchete) {
        this.totalAchete = totalAchete;
    }
    public double getTotalMange() {
        return totalMange;
    }
    public void setTotalMange(double totalMange) {
        this.totalMange = totalMange;
    }
    public double getRabTotal() {
        return rabTotal;
    }
    public void setRabTotal(double rabTotal) {
        this.rabTotal = rabTotal;
    }
    public double getRabMois() {
        return rabMois;
    }
    public void setRabMois(double rabMois) {
        this.rabMois = rabMois;
    }
    public ArrayList<Personne> getListPersonne() {
        return listPersonne;
    }
    public void setListPersonne(ArrayList<Personne> listPersonne) {
        this.listPersonne = listPersonne;
    }

    public void compteFoyer(){
        setTotalMange(0);
        setTotalAchete(0);
        setRabMois(0);
        for (int cpt = 0; cpt < getListPersonne().size(); cpt++){
            setTotalMange(getTotalMange() + getListPersonne().get(cpt).getDoitRepas());
            setTotalAchete(getTotalAchete() + getListPersonne().get(cpt).getDuCourses());
        }
        setRabMois(getTotalAchete() - getTotalMange());
        setRabTotal(getRabTotal() + getRabMois());
    }

    public void affiche(){
        System.out.println("Total acheté : " +getTotalAchete() + "€\nTotal mangé : " + getTotalMange() +
                "€\nRab du mois" + getRabMois() + "€\nRab total : " + getRabTotal() + "€\n");
        for (int cpt = 0; cpt < getListPersonne().size(); cpt++){
            getListPersonne().get(cpt).affiche();
        }
    }
}
