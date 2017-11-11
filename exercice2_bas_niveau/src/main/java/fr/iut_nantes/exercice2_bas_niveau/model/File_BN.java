package fr.iut_nantes.exercice2_bas_niveau.model;

/**
 * @author Anais BESSON, Victor FAVREAU - LP MiAR Alternance
 */
public class File_BN<E> extends AbstractFileBloquanteBornee<E> {

    /**
     * Tableau d'items
     */
    final E[] items = (E[]) new Object[100];
    /**
     * putptr: indice de l'objet à poser
     * takeptr: indice de l'objet à prendre
     * count: Compteurs d'objets présents dans la File
     */
    int putptr, takeptr, count;

    public File_BN(int n) {
        super(n);
    }

    /**
     * Deposer un objet dans la file
     * @param e Objet à déposer
     * @throws InterruptedException
     */
    @Override
    public synchronized void deposer(E e) throws InterruptedException {

        /**
         * Si la file est pleine, on attend.
         */
        while (count == items.length)
            wait();
        items[putptr] = e;
        if (++putptr == items.length) putptr = 0;
        ++count;
        notifyAll();
    }

    /**
     * Prendre un objet dans la file
     * @return l'objet pris
     * @throws InterruptedException
     */
    @Override
    public synchronized E prendre() throws InterruptedException {

        /**
         * Si la file est vide, on attend.
         */
        while (count == 0)
            wait();
        E x = items[takeptr];
        if (++takeptr == items.length) takeptr = 0;
        --count;
        notifyAll();
        return x;

    }
}

