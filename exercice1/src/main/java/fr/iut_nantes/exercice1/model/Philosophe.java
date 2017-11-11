package fr.iut_nantes.exercice1.model;

import fr.iut_nantes.exercice1.Main;

/**
 * @author Anais BESSON, Victor FAVREAU - LP MiAR Alternance
 */
public class Philosophe extends Thread{

    private int _id;
    private String _nom;

    /**
     * Constructeur de la classe Philosophe
     * @param id : Id du philosophe
     * @param n : Nom du philosophe
     */
    public Philosophe( int id, String n )
    {
        _id = id;
        _nom = n;
    }

    public void run()
    {
        /**
         * Dans notre implémentation les philosophes ne font que penser puis manger.
         */
        while( true )
        {
            penser();

            manger();
        }
    }

    /**
     * pour manger, le philosophe fait appel à la méthode mange() du moniteur. C'est le moniteur qui gère la file d'attente.
     * Un Thread.sleep est ajouté pour éviter qu'un philosophe pose et reprenne ses baguettes aussitot, laissant ainsi les autres en attente.
     */
    final void manger()
    {
        try
        {
            Main.moniteur.mange(_id);
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Pour penser, le philosophe doit tout d'abord poser ses baguettes puis attendre.
     */
    final void penser()
    {
        try
        {
            Main.moniteur.pose(_id);
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public String get_nom() {
        return _nom;
    }

}
