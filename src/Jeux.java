/* TODO Javadoc */
/**
 * @author culty & prinsac
 */
public class Jeux {
	/* TODO Pourquoi "0" ? */
    private int[][] tableau = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}; // Tableau représentant la grille
    /* TODO Pourquoi pas une constante ? */
    private int     joueur1 = 1; // Numéro du joueur 1
    /* TODO Pourquoi pas une constante ? */
    private int     joueur2 = 2; // Numéro du joueur 2
    private boolean tour    = true; //tour=true: le joueur 1 joue, tour=false: le joueur 2 joue

    public void Jeux() {
    }

    public void poserPion() {
        /* TODO Pourquoi pas simplement tester "tour" plutôt que "tour == true" */
        if (tour == true) {
            /* TODO Vous réinitialisez le tableau à chaque coup ? */
            /* TODO Ce n'est pas du java. */
            tableau[][]={{0, 0, 0},{0, 0, 0},{0, 0, 0}} ;
            tour = !tour;
        }
        /* TODO Vide ? */
        else {

        }
    }
}
