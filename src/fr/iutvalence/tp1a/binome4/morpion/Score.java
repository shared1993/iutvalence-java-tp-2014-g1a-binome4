package fr.iutvalence.tp1a.binome4.morpion;

/**
 * @author Prinsac & Culty
 * @version 1.0
 */

public class Score
{
    /** Pseudo du joueur 1. */
	private final String joueur1;
	
    /** Pseudo du joueur 2. */
	private final String joueur2;
	
    /** Score du joueur 1. */
    private int scoreJ1;
    
    /** Score du joueur 2. */
    private int scoreJ2;
    
    /** Score Nul. */
    private int scoreNul;

    /** Constructeur de Score avec les 2 noms des joueurs. */
    public Score(String joueur1, String joueur2) {
    	this.joueur1 = joueur1;
    	this.joueur2 = joueur2;
        scoreJ1 = 0;
        scoreJ2 = 0;
        scoreNul = 0;
    }

    /** Incremente le score des joueurs. */
    public void gagne(String gagnant) {
        if (gagnant.equals(Morpion.pseudoJ1))scoreJ1++;
        if (gagnant.equals(Morpion.pseudoJ2))scoreJ2++;
    }

    /** Incremente le score de Nul. */
    public void nul() {
		scoreNul++;
	}
}
