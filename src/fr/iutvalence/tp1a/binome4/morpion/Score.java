package fr.iutvalence.tp1a.binome4.morpion;

/* TODO Fonctionnement absolument pas objet ! À revoir. */
/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Score
{
    /** TODO. */
	public static int scoreJ1;
    /** TODO. */
    public static int scoreJ2;
    /** TODO. */
    public static int scoreNul;

    public Score() {
        scoreJ1 = 0;
        scoreJ2 = 0;
        scoreNul = 0;
    }

    /* TODO Fonctionnement extrêmement discutable */
    /** TODO. */
    public static void gagne(String gagnant) {
        if (gagnant == Pseudo.pseudoJ1) scoreJ1++;
        if (gagnant == Pseudo.pseudoJ2) scoreJ2++;
    }

    /** TODO. */
    public static void nul() {
		scoreNul++;
	}
}
