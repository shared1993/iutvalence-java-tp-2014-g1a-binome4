package fr.iutvalence.tp1a.binome4.morpion;

import java.util.Scanner;
import static fr.iutvalence.tp1a.binome4.morpion.Pion.*;

/**
 * @author Prinsac & Culty
 * @version 1.0
 */
public class Morpion {
	/** Déclaration du tableau du jeu. */
	private final Pion[][] tableau;
	private final Joueur[] joueurs;
	private final Score score;
	private int tour;
	/** Compteur du nombre de tour. */
	private int nbTour = 0;

	/** Initialisation du tableau et du tour. 
	 * @param gestionnaireScore 
	 * @param joueur2 
	 * @param joueur1 */
	public Morpion(Joueur joueur1, Joueur joueur2, Score gestionnaireScore) {
		this.joueurs = new Joueur[]{joueur1,joueur2};
		score=gestionnaireScore;
	    	tableau = new Pion[3][3];
		tour = 0;
	}

	/** G�re une partie. */
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
		if (victoire()) {
			System.out.printf("*************** %s (O) GAGNE ***************%n", joueurs[tour]);
			Score.gagne(joueurs[tour]);
		}
		System.out.printf("%s = %d%n", pseudoJ1, Score.getScore(joueurs[tour]));
		System.out.printf("%s = %d%n", pseudoJ2, Score.scoreJ2);
		System.out.printf("Nul = %d%n", Score.scoreNul);
	}

	/** Retourne vrai si la case est libre, et faux si la case est occupée. */
	private boolean caseLibre(int ligne, int colonne) {
		if (tableau[ligne][colonne] == VIDE) {
			return true;
		}
		System.out.println("Case d�j� occup�e !");
		return false;
	}

	/** Pose le pion, change le joueur, et incremente le compteur de tour. */
	private void poserPion(int ligne, int colonne) {
		tableau[ligne][colonne] = tour ? JOUEUR1 : JOUEUR2;
		tour = (tour+1)%2;
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
				else if (this.tableau[numeroDeLigne][numeroDeColonne] == JOUEUR1)
					morpionAsciiArt += "X ";
				else
					morpionAsciiArt += "O ";
			}
			morpionAsciiArt += "|\n";
		}
		morpionAsciiArt += "------------- \n";
		return morpionAsciiArt;
	}
}
