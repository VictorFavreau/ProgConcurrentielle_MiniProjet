package fr.iut_nantes.exercice2_haut_niveau.model;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class File_HN<E> extends AbstractFileBloquanteBornee<E> {

    final Lock lock = new ReentrantLock();
    final Condition notFull  = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final E[] items = (E[]) new Object[100];
    int putptr, takeptr, count;

    public File_HN(int n)
    {
        super(n);
    }

    @Override
    public void deposer(E e) throws InterruptedException
    {
        lock.lock();
        try {
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

    @Override
    public E prendre() throws InterruptedException
    {
        lock.lock();
        try {
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
