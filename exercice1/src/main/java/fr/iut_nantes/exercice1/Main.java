package fr.iut_nantes.exercice1;

import fr.iut_nantes.exercice1.model.Moniteur;
import fr.iut_nantes.exercice1.model.Philosophe;

/**
 * @author Anais BESSON, Victor FAVREAU - LP MiAR Alternance
 */
public class Main {

    /**
     * nbPhilosophes: nombre de Philosophes autour de la table
     * table: tableau de Philosophes représentant la table
     * moniteur: moniteur de l'application
     */
    public static int nbPhilosophes = 5;
    public static Philosophe[] table;
    public static Moniteur moniteur;

    public static void main(String[] args) {

        final String[] noms = {"Platon", "Socrate", "Aristote", "Diogene", "Seneque"};

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
