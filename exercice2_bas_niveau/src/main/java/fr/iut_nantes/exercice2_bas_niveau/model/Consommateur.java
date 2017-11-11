package fr.iut_nantes.exercice2_bas_niveau.model;

/**
 * @author Anais BESSON, Victor FAVREAU - LP MiAR Alternance
 */
public class Consommateur implements Runnable {

    private AbstractFileBloquanteBornee<String> file;
    private String id;

    /**
     * Constructeur de la classe
     *
     * @param f: File d'objets
     * @param i: Identifiant de l'Objet à ajouter
     */
    public Consommateur(AbstractFileBloquanteBornee<String> f, String i) {
        file = f;
        id = i;
    }

    public void run() {
        String elem;
        try {

            /**
             * Le consommateur prend 50 objects dans la file
             */
            for (int i = 0; i < 50; i++) {
                Thread.sleep((int) (Math.random() * 1000));
                elem = file.prendre();
                System.out.println(id + "prendre : " + elem);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
