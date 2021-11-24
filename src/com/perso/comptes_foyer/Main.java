package com.perso.comptes_foyer;

import com.perso.comptes_foyer.modele.Foyer;
import com.perso.comptes_foyer.modele.Personne;
import com.perso.comptes_foyer.vue.Interface;

public class Main {
    public static void main(String[] args){
        Personne un = new Personne("Pablo");
        un.faireComptesPersonne(32, 43.76);
        Personne deux = new Personne("Bonjour");
        deux.faireComptesPersonne(11, 0);
        Personne trois = new Personne("Salut");
        trois.faireComptesPersonne(17, 72.09);
        Personne quatre = new Personne("Zebi");
        quatre.faireComptesPersonne(15, 23.26);

        Foyer foyer = new Foyer();
        foyer.getListPersonne().add(un);
        foyer.getListPersonne().add(deux);
        foyer.getListPersonne().add(trois);
        foyer.getListPersonne().add(quatre);

        foyer.compteFoyer();

        Interface fenetre = new Interface(foyer);
        fenetre.setVisible(true);
    }
}
