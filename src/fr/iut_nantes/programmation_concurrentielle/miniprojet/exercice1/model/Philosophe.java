package fr.iut_nantes.programmation_concurrentielle.miniprojet.exercice1.model;

public class Philosophe implements Runnable{

    private String _nom;
    private Baguette _bGauche, _bDroite;

    public Philosophe( String n, Baguette g, Baguette d )
    {
        _nom = n;
        _bGauche = g;
        _bDroite = d;
    }

    public void run()
    {
        while( true )
        {
            penser();
            _bGauche.prendre();
            _bDroite.prendre();
            manger();
            _bDroite.relacher();
            _bGauche.relacher();
        }
    }

    final void manger()
    {
        System.out.println( _nom + " mange." );
    }

    final void penser()
    {
        System.out.println( _nom + " pense." );
    }
}
