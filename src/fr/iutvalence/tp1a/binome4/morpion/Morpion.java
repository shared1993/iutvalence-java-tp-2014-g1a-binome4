package fr.iutvalence.tp1a.binome4.morpion;

/**
 * @author Prinsac & Culty
 * @version 1.0
 */

import java.util.Scanner;
public class Morpion {

	/** Pseudo joueur 1. */
	public final static String pseudoJ1 = "Joueur 1";

	/** Pseudo joueur 2. */
	public final static String pseudoJ2 = "Joueur 2";

	/** Valeur des cases par d√©faut. */
	public static final int VIDE = 0;

	/** Valeur des cases du joueur 1. */
	public static final int PIONJOUEUR1 = 1;

	/** Valeur des cases du joueur 2. */
	public static final int PIONJOUEUR2 = 2;

	/** D√©claration du tableau du jeu. */
	public final int[][] tableau;

	/** Si vrai tour du joueur 1, si faux tour du joueur 2. */
	public static boolean tour;

	/** Compteur du nombre de tour. */
	private int nbTour = 0;

	/** Initialisation du tableau et du tour. */
	public Morpion() {
		tableau = new int[3][3];
		tour = true;
	}

	/** GËre une partie. */
	public void jouer() {
		System.out.println(this);
		while (!victoire() && (nbTour < 9)) {
			int[] saisie;
			do {
				saisie = Saisir.saisir();
			} while (!caseLibre(saisie[0], saisie[1]));
			
			poserPion(saisie[0], saisie[1]);
			System.out.println(this);
			victoire();
		}
		if (victoire() && tour) {
			System.out.printf("*************** %s (O) GAGNE ***************%n", pseudoJ2);
			Score.gagne(pseudoJ2);
		}
		if (victoire() && !tour) {
			System.out.printf("*************** %s (X) GAGNE ***************%n", pseudoJ1);
			Score.gagne(pseudoJ1);
		}
		if (!victoire()) {
			System.out.println("*************** MATCH NUL ! ***************");
			Score.nul();
		}
		System.out.printf("%s = %d%n", pseudoJ1, Score.scoreJ1);
		System.out.printf("%s = %d%n", pseudoJ2, Score.scoreJ2);
		System.out.printf("Nul = %d%n", Score.scoreNul);
	}

	/** Retourne vrai si la case est libre, et faux si la case est occup√©e. */
	private boolean caseLibre(int ligne, int colonne) {
		if (tableau[ligne][colonne] == Morpion.VIDE) {
			return true;
		}
		System.out.println("Case dÈj‡† occupÈe !");
		return false;
	}

	/** Pose le pion, change le joueur, et incremente le compteur de tour. */
	private void poserPion(int ligne, int colonne) {
		tableau[ligne][colonne] = tour ? PIONJOUEUR1 : PIONJOUEUR2;
		tour = !tour;
		nbTour++;
	}

	/** Retourne vrai si il y a une victoire, faux sinon. */
	private boolean victoire() {
		return (((tableau[0][0] == tableau[0][1]) && (tableau[0][0] == tableau[0][2])) && (tableau[0][0] != VIDE))
				|| (((tableau[1][0] == tableau[1][1]) && (tableau[1][0] == tableau[1][2])) && (tableau[1][0] != VIDE))
				|| (((tableau[2][0] == tableau[2][1]) && (tableau[2][0] == tableau[2][2])) && (tableau[2][0] != VIDE))
				|| (((tableau[0][0] == tableau[1][0]) && (tableau[0][0] == tableau[2][0])) && (tableau[0][0] != VIDE))
				|| (((tableau[0][1] == tableau[1][1]) && (tableau[0][1] == tableau[2][1])) && (tableau[0][1] != VIDE))
				|| (((tableau[0][2] == tableau[1][2]) && (tableau[0][2] == tableau[2][2])) && (tableau[0][2] != VIDE))
				|| (((tableau[0][0] == tableau[1][1]) && (tableau[0][0] == tableau[2][2])) && (tableau[0][0] != VIDE))
				|| (((tableau[0][2] == tableau[1][1]) && (tableau[0][2] == tableau[2][0])) && (tableau[0][2] != VIDE));
	}

	/** Affichage graphique en Ascii-Art. */
	public String toString() {
		String morpionAsciiArt = "";
		for (int numeroDeLigne = 0; numeroDeLigne < 3; numeroDeLigne++) {
			morpionAsciiArt += "------------- \n";
			for (int numeroDeColonne = 0; numeroDeColonne < 3; numeroDeColonne++) {
				morpionAsciiArt += "| ";
				if (this.tableau[numeroDeLigne][numeroDeColonne] == VIDE)
					morpionAsciiArt += "  ";
				else if (this.tableau[numeroDeLigne][numeroDeColonne] == PIONJOUEUR1)
					morpionAsciiArt += "X ";
				else
					morpionAsciiArt += "O ";
			}
			morpionAsciiArt += "|";
			morpionAsciiArt += "\n";
		}
		morpionAsciiArt += "------------- \n";
		return morpionAsciiArt;
	}
}
