package fr.iut_nantes.exercice1.model;

import fr.iut_nantes.exercice1.Main;

/**
 * @author Anais BESSON, Victor FAVREAU - LP MiAR Alternance
 */

public class Moniteur {

    /**
     * Constante utilisée pour definir la valeur d'une baguette libre
     */
    private static final int libre = -1;

    /**
     * baguette est "libre" si aucun philosophe ne la tient, l'id du philosophe qui la tient sinon
     */
    private int[] baguette;

    /**
     * tabMange est true si le philosophe i mange, false sinon
     */
    private boolean[] tabMange;

    public Moniteur() {
        baguette = new int[Main.nbPhilosophes];
        for (int i = 0; i < Main.nbPhilosophes; i++) {
            baguette[i] = libre;
        }

        tabMange = new boolean[Main.nbPhilosophes];
        for (int i = 0; i < Main.nbPhilosophes; i++) {
            tabMange[i] = false;
        }
    }

    /**
     * Le philosophe prends ses baguettes
     * @param i: identifiant du philosophe
     * @throws InterruptedException
     */
    public synchronized void mange(int i) throws InterruptedException
    {
        Philosophe philo = Main.table[i];

        /**
         * Tant que la baguette à gauche du philosophe n'est pas libre et que la baguette à droite n'est pas libre, on attend...
         */
        while(baguette[i] != libre || baguette[(i+1)%Main.nbPhilosophes] != libre)
        {
            wait();
        }

        System.out.println("Le philosophe " + philo.get_nom() + " prends les baguettes " + i + " et " + ((i+1)%5));
        tabMange[i] = true;
        baguette[i] = baguette[(i+1)%5] = i;

    }

    /**
     * Le philosophe pose ses baguettes
     * @param i: identifiant du philosophe
     * @throws InterruptedException
     */
    public synchronized void pose(int i) throws InterruptedException
    {
        Philosophe philo = Main.table[i];

        tabMange[i] = false;
        baguette[i] = baguette[(i+1)%5] = libre;

        System.out.println("Le philosophe " + philo.get_nom() + " libere les baguettes " + i + " et " + ((i+1)%5));

        notifyAll();
    }

}
