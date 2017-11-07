package fr.iut_nantes.programmation_concurrentielle.miniprojet.exercice1.model;

public class Baguette {

    private boolean _prise = false;

    final synchronized void prendre()
    {
        try
        {
            while( _prise )
            {
                wait();
            }
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
            System.exit( -1 );
        }
        _prise = true;
    }

    final synchronized void relacher()
    {
        _prise = false;
        notifyAll();
    }

}
