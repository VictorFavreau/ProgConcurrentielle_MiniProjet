package fr.iut_nantes.exercice2_bas_niveau.model;

/**
 * @author Anais BESSON, Victor FAVREAU - LP MiAR Alternance
 */
public class Producteur implements Runnable {

    private AbstractFileBloquanteBornee<String> file;
    private String id;

    /**
     * Constructeur de la classe
     *
     * @param f: File d'objets
     * @param i: Identifiant de l'Objet à ajouter
     */
    public Producteur(AbstractFileBloquanteBornee<String> f, String i) {
        file = f;
        id = i;
    }

    public void run() {
        try {
            /**
             * Le Producteur dépose 50 Objets dans la File, dans notre cas des String
             */
            for (int i = 0; i < 50; i++) {
                Thread.sleep((int) (Math.random() * 1000));
                file.deposer(id + i);
                System.out.println("deposer : " + id + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
