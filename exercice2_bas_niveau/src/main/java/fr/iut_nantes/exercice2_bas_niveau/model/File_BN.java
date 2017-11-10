package fr.iut_nantes.exercice2_bas_niveau.model;

public class File_BN<E> extends AbstractFileBloquanteBornee<E> {

    final E[] items = (E[]) new Object[100];
    int putptr, takeptr, count;

    public File_BN(int n) {
        super(n);
    }

    @Override
    public synchronized void deposer(E e) throws InterruptedException {

        while (count == items.length)
            wait();
        items[putptr] = e;
        if (++putptr == items.length) putptr = 0;
        ++count;
        notifyAll();
    }

    @Override
    public synchronized E prendre() throws InterruptedException {

            while (count == 0)
                wait();
            E x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notifyAll();
            return x;

    }
}

