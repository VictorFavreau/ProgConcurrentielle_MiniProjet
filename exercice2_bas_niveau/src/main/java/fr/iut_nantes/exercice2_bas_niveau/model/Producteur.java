package fr.iut_nantes.exercice2_bas_niveau.model;

public class Producteur implements Runnable{

    private AbstractFileBloquanteBornee<String> file;
    private String id;

    public Producteur(AbstractFileBloquanteBornee<String> f, String i) {
        file = f;
        id = i;
    }

    public void run() {
        try
        {
            for(int i=0; i<50; i++) {
                Thread.sleep((int)(Math.random()*1000));
                file.deposer(id+i);
                System.out.println("deposer : " + id + i);
            }
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
