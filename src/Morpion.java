/* TODO Javadoc */
/* TODO Package. */

/**
 * @author culty & prinsac
 */
public class Morpion {
    /* TODO Constantes ? */
    private final int vide        = 0;
    private final int pionJoueur1 = 1;
    private final int pionJoueur2 = 2;

    public Morpion() {
    /* TODO CECI N'EST PAS DU JAVA. */
        private int[][] tableau = {{vide, vide, vide}, {vide, vide, vide}, {vide, vide, vide}};
        private boolean tour = true; /* tour=true: le joueur 1 joue, tour=false: le joueur 2 joue */
    }

    public void jouer() {
        // Afficher
        // Saisir
        // poserPion
        // Victoire ?
    }

    public void poserPion(int i, int j) throws horsTableau, caseOccupee {
        if ((i > 3) || (j > 3)) {
        /* TODO Mais < 1 (ou < 0) ce n'est pas un problème ? */
            throw new horsTableau(); /* Gestion de l'erreur si la case est hors tableau */
        }
    /* XXX Vous réutilisez le parametre ????? */
    /* TODO Je ne comprends pas cette partie. */
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                if (tableau[i][j] != vide) {
                    throw new caseOccupee(); /* Gestion de l'erreur si la case est occupée */
                }
                if (tour) { tableau[i][j] = pionJoueur1; }
                else { tableau[i][j] = pionJoueur2; }
            }
        }
        tour = !tour;
    }
}
