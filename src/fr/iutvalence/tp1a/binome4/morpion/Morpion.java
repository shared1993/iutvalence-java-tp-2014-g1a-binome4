package fr.iutvalence.tp1a.binome4.morpion;

import java.util.Scanner;

/**
 * TODO.
 * 
 * @author Prinsac & Culty
 * @version 1.0
 */
public class Morpion {
    
    public final static String pseudoJ1 = "Joueur 1";
    /** TODO. */
    public final static String pseudoJ2 = "Joueur 2";
    
    /** Valeur des cases par défaut. */
    public static final int VIDE = 0;
    
    /** Valeur des cases du joueur 1. */
    public static final int PIONJOUEUR1 = 1;
    
    /** Valeur des cases du joueur 2. */
    public static final int PIONJOUEUR2 = 2;
    
    /** Déclaration du tableau du jeu. */
    public final int[][] tableau;
    
    /** Si vrai tour du joueur 1, si faux tour du joueur 2. */
    public static boolean tour;

    /* TODO Pourquoi des attributs ? */
    private int numLigne;
    private int numColonne;

    /** Compteur du nombre de tour. */
    private int nbTour = 0;

    /** Initialisation du tableau et du tour. */
    public Morpion() {
	tableau = new int[3][3];
	tour = true;
    }

    /** TODO. */
    public void jouer() {
	System.out.println(this);
	while (!victoire() && (nbTour < 9)) {
	    /*
	     * TODO Votre récupération des lignes et des colonnes est
	     * discutable.
	     */
	    do {
		saisir();
	    } while (!caseLibre(Saisir.numLigne, Saisir.numColonne));
	    poserPion(numLigne, numColonne);
	    System.out.println(this);
	    victoire();
	}
	if (victoire() && tour) {
	    System.out.printf("*************** %s (O) GAGNE ***************%n",
		    pseudoJ2);
	    Score.gagne(pseudoJ2);
	}
	if (victoire() && !tour) {
	    System.out.printf("*************** %s (X) GAGNE ***************%n",
		    pseudoJ1);
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

    /** Retourne vrai si la case est libre, et faux si la case est occupée. */
    private boolean caseLibre(int ligne, int colonne) {
	if (tableau[ligne][colonne] == Morpion.VIDE) {
	    return true;
	}
	System.out.println("Case déjà occupée !");
	return false;
    }

    /** Pose le pion, change le joueur, et incremente le compteur de tour. */
    private void poserPion(int ligne, int colonne) {
	tableau[ligne][colonne] = tour ? PIONJOUEUR1 : PIONJOUEUR2;
	tour = !tour;
	nbTour++;
    }

    /* TODO Le fonctionnement du passage de la saisie est *très* discutable ! */
    /** TODO. */
    

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

    /*
     * TODO Peut être beaucoup plus efficace avec un enum pour les pions, et un
     * StringBuilder à la place de la String.
     */
    @Override
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
