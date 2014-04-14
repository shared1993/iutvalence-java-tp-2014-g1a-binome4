package fr.iutvalence.tp1a.binome4.morpion;

/**
 * @author Prinsac & Culty
 * @version 1.0
 */

public class Score {
    /** Joueur 1. */
    private final Joueur joueur1;

    /** Joueur 2. */
    private final Joueur joueur2;

    /** Score du joueur 1. */
    private int scoreJ1;

    /** Score du joueur 2. */
    private int scoreJ2;

    /** Score Nul. */
    private int scoreNul;

    /** Constructeur de Score avec les 2 noms des joueurs. */
    public Score(Joueur joueur1, Joueur joueur2) {
	this.joueur1 = joueur1;
	this.joueur2 = joueur2;
	scoreJ1 = 0;
	scoreJ2 = 0;
	scoreNul = 0;
    }

    /** Incremente le score des joueurs. */
    public void gagne(String joueur) {
	if (joueur.equals(joueur1.nom()))
	    scoreJ1++;
	if (joueur.equals(joueur2.nom()))
	    scoreJ2++;
    }
    
    /** Incremente le score des joueurs. */
    public void nul(){
    	scoreNul++;
    }

    /** Donne le score de Nul. */
    public int getNul() {
    	return scoreNul;
    }
    
    /** Donne le score des joueurs. */
    public int getScore(String joueur) {
	if (joueur.equals(joueur1.nom()))
	    return scoreJ1;
	if (joueur.equals(joueur2.nom()))
	    return scoreJ2;
	return -1;
    }
}
