package fr.iut_nantes.programmation_concurrentielle.miniprojet.exercice2.model;

import fr.iut_nantes.programmation_concurrentielle.miniprojet.exercice2.Main;

public class Philosophe extends Thread{

    private int _id;
    private String _nom;

    public Philosophe( int id, String n )
    {
        _id = id;
        _nom = n;
    }

    public void run()
    {
        while( true )
        {
            penser();

            manger();
        }
    }

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
