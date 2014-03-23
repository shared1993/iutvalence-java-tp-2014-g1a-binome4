package fr.iutvalence.tp1a.binome4.morpion;

import java.util.Scanner;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Morpion
{
    /** TODO. */
	public static final int VIDE = 0;
    /* TODO Les constantes ont des noms en majuscules. */
    /** TODO. */
    public static final int pionJoueur1 = 1;
    /* TODO Les constantes ont des noms en majuscules. */
    /** TODO. */
    public static final int pionJoueur2 = 2;
    /** TODO. */
    public final int[][] tableau;
    /** TODO. */
    private      boolean tour;
    /* TODO Pourquoi des attributs ? */
    private      int     numLigne;
    private      int     numColonne;
    /** TODO. */
    private int nbTour = 0;

    /** TODO. */
    public Morpion() {
        tableau = new int[3][3];
        tour = true;
    }

    /** TODO. */
    public void jouer() {
        System.out.println(this);
        while (!victoire() && (nbTour < 9)) {
            /* TODO Votre récupération des lignes et des colonnes est discutable. */
            do {
                saisir();
            }
            while (!caseLibre(numLigne, numColonne));
            poserPion(numLigne, numColonne);
            System.out.println(this);
            victoire();
        }
        if (victoire() && tour) {
            /* TODO J'ai simplifié votre affichage de la victoire pour préparer l'internationalisation. */
            System.out.printf("*************** %s (O) GAGNE ***************%n", Pseudo.pseudoJ2);
            Score.gagne(Pseudo.pseudoJ2);
        }
        if (victoire() && !tour) {
            /* TODO J'ai simplifié votre affichage de la victoire pour préparer l'internationalisation. */
            System.out.printf("*************** %s (X) GAGNE ***************%n", Pseudo.pseudoJ1);
			Score.gagne(Pseudo.pseudoJ1);
		}
		if(!victoire())
		{
			System.out.println("*************** MATCH NUL ! ***************");
			Score.nul();
		}
        System.out.printf("%s = %d%n", Pseudo.pseudoJ1, Score.scoreJ1);
        System.out.printf("%s = %d%n", Pseudo.pseudoJ2, Score.scoreJ2);
        System.out.printf("Nul = %d%n", Score.scoreNul);
	}

    /* TODO Pourquoi public ? */
    /** TODO. */
    public boolean caseLibre(int ligne, int colonne)
	{
        if (tableau[ligne][colonne] == Morpion.VIDE) {
            return true;
        }
 	    System.out.println("Case déjà occupée !");
		return false;
    }

    /* TODO Pourquoi public ? */
    /** TODO. */
    public void poserPion(int ligne, int colonne)
	{
		tableau[ligne][colonne] = tour ? pionJoueur1 : pionJoueur2;
		tour = !tour;
		nbTour++;
	}

    /* TODO Pourquoi public ? */
    /* TODO Le fonctionnement du passage de la saisie est *très* discutable ! */
    /** TODO. */
	public void saisir()
	{
		if(tour) {
            /* TODO J'ai simplifié votre affichage de la victoire pour préparer l'internationalisation. */
            System.out.printf("C'est à \"%s\" de jouer (X) :%n", Pseudo.pseudoJ1);
        }
        else {
            /* TODO J'ai simplifié votre affichage de la victoire pour préparer l'internationalisation. */
            System.out.printf("C'est à \"%s\" de jouer (O) :%n", Pseudo.pseudoJ2);
        }
        numLigne = 4;
        Scanner reader = new Scanner(System.in);
        while ((numLigne < 0) || (numLigne > 2))
		{
			System.out.println("Entrez le numéro de ligne :");
			/* TODO Pourquoi ne pas récupérer directement un entier ? */
            String ligneS = reader.nextLine();
			numLigne = Integer.parseInt(ligneS) - 1;
			if((numLigne < 0) || (numLigne > 2))
			{
				System.out.println("Hors tableau !");
			}
		}
		numColonne = 4;
		while ((numColonne < 0) || (numColonne > 2))
		{
			System.out.println("Entrez le numéro de colonne :");
			String colonneS = reader.nextLine();
			numColonne = Integer.parseInt(colonneS) - 1;
			if((numColonne < 0) || (numColonne > 2))
			{
				System.out.println("Hors tableau !");
			}
		}
	}

    /* TODO Pourquoi public ? */
    /** TODO. */
	public boolean victoire()
	{
		return (((tableau[0][0] == tableau[0][1]) && (tableau[0][0] == tableau[0][2])) && (tableau[0][0] != VIDE))
				|| (((tableau[1][0] == tableau[1][1]) && (tableau[1][0] == tableau[1][2])) && (tableau[1][0] != VIDE))
				|| (((tableau[2][0] == tableau[2][1]) && (tableau[2][0] == tableau[2][2])) && (tableau[2][0] != VIDE))
				|| (((tableau[0][0] == tableau[1][0]) && (tableau[0][0] == tableau[2][0])) && (tableau[0][0] != VIDE))
				|| (((tableau[0][1] == tableau[1][1]) && (tableau[0][1] == tableau[2][1])) && (tableau[0][1] != VIDE))
				|| (((tableau[0][2] == tableau[1][2]) && (tableau[0][2] == tableau[2][2])) && (tableau[0][2] != VIDE))
				|| (((tableau[0][0] == tableau[1][1]) && (tableau[0][0] == tableau[2][2])) && (tableau[0][0] != VIDE))
				|| (((tableau[0][2] == tableau[1][1]) && (tableau[0][2] == tableau[2][0])) && (tableau[0][2] != VIDE));
	}

    /* TODO Peut être beaucoup plus efficace avec un enum pour les pions, et un StringBuilder à la place de la String. */
    @Override
	public String toString()
	{
		String morpionAsciiArt = "";
		for(int numeroDeLigne = 0; numeroDeLigne < 3; numeroDeLigne++)
		{
			morpionAsciiArt += "------------- \n";
			for(int numeroDeColonne = 0; numeroDeColonne < 3; numeroDeColonne++)
			{
				morpionAsciiArt += "| ";
				if(this.tableau[numeroDeLigne][numeroDeColonne] == VIDE)
					morpionAsciiArt += "  ";
				else if(this.tableau[numeroDeLigne][numeroDeColonne] == pionJoueur1)
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
