package fr.iut_nantes.programmation_concurrentielle.miniprojet.exercice1;

import fr.iut_nantes.programmation_concurrentielle.miniprojet.exercice1.model.Baguette;
import fr.iut_nantes.programmation_concurrentielle.miniprojet.exercice1.model.Philosophe;

public class Main {

    public static void main(String[] args) {

        final String[] noms = {"Platon", "Socrate", "Aristote", "Diogène", "Sénèque"};
        final Baguette[] baguettes = {new Baguette(), new Baguette(), new Baguette(), new Baguette(), new Baguette()};
        Philosophe[] table;

        table = new Philosophe[5];
        for (char cpt = 0; cpt < table.length; ++cpt) {
            table[cpt] = new Philosophe(noms[cpt], baguettes[cpt], baguettes[(cpt + 1) % table.length]);
            new Thread(table[cpt]).start();
        }
    }
    
}
