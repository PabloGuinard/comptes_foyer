package com.perso.comptes_foyer.modele;

public class Personne {
    private String nom;
    private int doitRepas;
    private int duCourses;
    private int doitTotal;

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
    public int getDuCourses() {
        return duCourses;
    }
    public void setDuCourses(int duCourses) {
        this.duCourses = duCourses;
    }
    public int getDoitTotal() {
        return doitTotal;
    }
    public void setDoitTotal(int doitTotal) {
        this.doitTotal = doitTotal;
    }

    public void faireComptesPersonne(int nbRepas, int courses){
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
