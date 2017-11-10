package fr.iut_nantes.exercice2_bas_niveau;

import java.lang.Thread;
import fr.iut_nantes.exercice2_bas_niveau.model.AbstractFileBloquanteBornee;
import fr.iut_nantes.exercice2_bas_niveau.model.File_BN;
import fr.iut_nantes.exercice2_bas_niveau.model.Producteur;
import fr.iut_nantes.exercice2_bas_niveau.model.Consommateur;


public class Main {

    public static void main(String args[]) {
        AbstractFileBloquanteBornee<String> f = new File_BN<String>(5);

        new Thread(new Producteur(f, "P1")).start();
        new Thread(new Producteur(f, "P2")).start();
        new Thread(new Producteur(f, "P3")).start();
        new Thread(new Producteur(f, "P4")).start();
        new Thread(new Producteur(f, "P5")).start();
        new Thread(new Producteur(f, "P6")).start();

        new Thread(new Consommateur(f, "C1")).start();
        new Thread(new Consommateur(f, "C2")).start();
        new Thread(new Consommateur(f, "C3")).start();
        new Thread(new Consommateur(f, "C4")).start();
    }
}
