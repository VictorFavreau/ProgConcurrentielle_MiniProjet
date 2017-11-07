package fr.iut_nantes.programmation_concurrentielle.miniprojet.exercice1;

import fr.iut_nantes.programmation_concurrentielle.miniprojet.exercice1.model.Moniteur;
import fr.iut_nantes.programmation_concurrentielle.miniprojet.exercice1.model.Philosophe;

public class Main {

    public static int nbPhilosophes = 5;
    public static Philosophe[] table;
    public static Moniteur moniteur;

    public static void main(String[] args) {

        final String[] noms = {"Platon", "Socrate", "Aristote", "Diogène", "Sénèque"};

        table = new Philosophe[5];
        moniteur = new Moniteur();

        /**
         * On initialise les Thread (Philosophes)
         */
        for (char cpt = 0; cpt < table.length; ++cpt) {
            table[cpt] = new Philosophe(cpt, noms[cpt]);
            table[cpt].start();
        }
    }

}
