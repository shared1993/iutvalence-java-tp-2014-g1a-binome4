package fr.iutvalence.tp1a.binome4.morpion;
import java.util.Scanner;
/**
 * @author culty & prinsac
 */

public class Morpion
{
	public static final int VIDE = 0;
	public static final int pionJoueur1 = 1;
	public static final int pionJoueur2 = 2;
	public final int[][] tableau;
	private boolean tour;
	private int numLigne;
	private int numColonne;
	private int nbTour = 0;

	public Morpion()
	{
		tableau = new int[3][3];
		tour = true;
	}

	public void jouer(){
		System.out.println(toString());
		while ((!victoire()) && (nbTour < 9))
		{
			saisir();
			poserPion(numLigne, numColonne);
			System.out.println(toString());
			victoire();
		}
		if((victoire()) && (tour))
		{
			System.out.println("*************** " + Pseudo.pseudoJ2 + " (O) GAGNE ***************");
			Score.gagne(Pseudo.pseudoJ2);
		}
		if((victoire()) && (!tour))
		{
			System.out.println("*************** " + Pseudo.pseudoJ1 + " (X) GAGNE ***************");
			Score.gagne(Pseudo.pseudoJ1);
		}
		if(!victoire())
		{
			System.out.println("*************** MATCH NUL ! ***************");
			Score.nul();
		}
		System.out.println(Pseudo.pseudoJ1 + " = " + Score.scoreJ1);
		System.out.println(Pseudo.pseudoJ2 + " = " + Score.scoreJ2);
		System.out.println("Nul = " + Score.scoreNul);
	}

	public void poserPion(int ligne, int colonne)
	{
		if(tableau[ligne][colonne] != VIDE)
		{
			System.out.println("Case déjà occupée !");
			jouer(); /** A modifier pour redemander au joueur une nouvelle case disponible ! */
		}
		else
		{
			tableau[ligne][colonne] = tour ? pionJoueur1 : pionJoueur2;
			tour = !tour;
			nbTour++;
		}
	}

	public void saisir()
	{
		if(tour)
			System.out.println("C'est à \"" + Pseudo.pseudoJ1 + "\" de jouer (X) :");
		else
			System.out.println("C'est à \"" + Pseudo.pseudoJ2 + "\" de jouer (O) :");
		numLigne = 4;
		while ((numLigne < 0) || (numLigne > 2))
		{
			Scanner ligne = new Scanner(System.in);
			System.out.println("Entrez le numéro de ligne :");
			String ligneS = ligne.nextLine();
			numLigne = Integer.parseInt(ligneS);
			numLigne = numLigne - 1;
			if((numLigne < 0) || (numLigne > 2))
			{
				System.out.println("Hors tableau !");
			}
		}
		numColonne = 4;
		while ((numColonne < 0) || (numColonne > 2))
		{
			Scanner colonne = new Scanner(System.in);
			System.out.println("Entrez le numéro de colonne :");
			String colonneS = colonne.nextLine();
			numColonne = Integer.parseInt(colonneS);
			numColonne = numColonne - 1;
			if((numColonne < 0) || (numColonne > 2))
			{
				System.out.println("Hors tableau !");
			}
		}
	}

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
