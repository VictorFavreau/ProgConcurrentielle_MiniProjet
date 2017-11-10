package fr.iut_nantes.exercice2_haut_niveau.model;

public class Consommateur implements Runnable{

    private AbstractFileBloquanteBornee<String> file;
    private String id;

    public Consommateur(AbstractFileBloquanteBornee<String> f, String i) {
        file = f;
        id = i;
    }

    public void run() {
        String elem;
        try
        {
            for(int i=0; i<50; i++) {
                Thread.sleep((int)(Math.random()*1000));
                elem = file.prendre();
                System.out.println(id + "prendre : " + elem);
            }
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
