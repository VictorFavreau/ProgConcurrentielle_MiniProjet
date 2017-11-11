package fr.iut_nantes.exercice2_haut_niveau.model;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Anais BESSON, Victor FAVREAU - LP MiAR Alternance
 */
public class File_HN<E> extends AbstractFileBloquanteBornee<E> {

    /**
     * Verrou
     */
    final Lock lock = new ReentrantLock();
    /**
     * Condition: la file n'est pas vide
     */
    final Condition notFull  = lock.newCondition();
    /**
     * Condition: la file n'est pas pleine
     */
    final Condition notEmpty = lock.newCondition();

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

    public File_HN(int n)
    {
        super(n);
    }

    /**
     * Deposer un objet dans la file
     * @param e Objet à déposer
     * @throws InterruptedException
     */
    @Override
    public void deposer(E e) throws InterruptedException
    {
        lock.lock();
        try {
            /**
             * Si la file est pleine, la condition notFull n'est pas respectée, on attend
             */
            while (count == items.length)
                notFull.await();
            items[putptr] = e;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Prendre un objet dans la file
     * @return l'objet pris
     * @throws InterruptedException
     */
    @Override
    public E prendre() throws InterruptedException
    {
        lock.lock();
        try {
            /**
             * Si la file est vide, la condition notEmpty n'est pas respectée, on attend
             */
            while (count == 0)
                notEmpty.await();
            E x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
