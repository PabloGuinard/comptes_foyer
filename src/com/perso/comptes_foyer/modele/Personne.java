package com.perso.comptes_foyer.modele;

public class Personne {
    private String nom;
    private int doitRepas;
    private double duCourses;
    private double doitTotal;

    public Personne(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getDoitRepas() {
        return doitRepas;
    }
    public void setDoitRepas(int doitRepas) {
        this.doitRepas = doitRepas;
    }
    public double getDuCourses() {
        return duCourses;
    }
    public void setDuCourses(double duCourses) {
        this.duCourses = duCourses;
    }
    public double getDoitTotal() {
        return doitTotal;
    }
    public void setDoitTotal(double doitTotal) {
        this.doitTotal = doitTotal;
    }

    public void faireComptesPersonne(int nbRepas, double courses){
        int tmp = nbRepas * 3;
        setDoitRepas(tmp);
        setDuCourses(courses);
        setDoitTotal(getDuCourses() - getDoitRepas());
    }

    public void affiche(){
        System.out.println("Nom : " + getNom() + "\nA mangé pour : " + getDoitRepas() + "€\nA acheté pour : " +
                        getDuCourses() + "€\nDoit au total : " + getDoitTotal() + "€\n");
    }
}
