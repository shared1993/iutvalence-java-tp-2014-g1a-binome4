package fr.iutvalence.tp1a.binome4.morpion;

/**
 * @author culty & prinsac
 */
import java.util.Scanner;
import fr.iutvalence.tp1a.binome4.morpion.Pseudo;

public class Morpion
{
	private static final int VIDE = 0;
	private static final int pionJoueur1 = 1;
	private static final int pionJoueur2 = 2;
	private final int[][] tableau;
	private boolean tour;
	private int numLigne;
	private int numColonne;
	private int nbTour = 0;
	private Scanner saisieLigne;
	private Scanner saisieColonne;
	private int scoreJ1 = 0;
	private int scoreJ2 = 0;

	public Morpion()
	{
		tableau = new int[3][3];
		tour = true;
		/** tour=true: le joueur 1 joue, tour=false: le joueur 2 joue */
	}

	public void jouer()
	{
		
		System.out.println(pseudo.obtenirPseudoJ1());
		System.out.println(pseudo.obtenirPseudoJ2());
			System.out.println(toString());
			while ((!victoire()) && (nbTour < 9))
			{
				saisir();
				poserPion(numLigne, numColonne);
				System.out.println(toString());
				victoire();
			}
			if((victoire()) && (tour)){
				System.out.println("*************** " + pseudo.obtenirPseudoJ2() + " (O) GAGNE ***************");
				scoreJ2++;
			}
			if((victoire()) && (!tour)){
				System.out.println("*************** " + pseudo.obtenirPseudoJ1() + " (X) GAGNE ***************");
				scoreJ1++;
			}
			if(!victoire())
				System.out.println("*************** MATCH NUL ! ***************");
			System.out.println(pseudo.obtenirPseudoJ1() + " = " + scoreJ1);
			System.out.println(pseudo.obtenirPseudoJ2() + " = " + scoreJ2);
	}

	public void poserPion(int ligne, int colonne)
	{
		if(tableau[ligne][colonne] != VIDE)
		{
			System.out.println("Case déjà occupée !");
			jouer();
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
			System.out.println("C'est à \"" + pseudo.obtenirPseudoJ1() + "\" de jouer (X):");
		else
			System.out.println("C'est à \"" + pseudo.obtenirPseudoJ2() + "\" de jouer (O):");
		numLigne = 4;
		while ((numLigne < 0) || (numLigne > 2))
		{
			saisieLigne = new Scanner(System.in);
			System.out.println("Veuillez saisir le numéro de ligne :");
			String ligne = saisieLigne.nextLine();
			numLigne = Integer.parseInt(ligne);
			numLigne = numLigne - 1;
			if((numLigne < 0) || (numLigne > 2))
				System.out.println("Hors tableau !");
		}
		numColonne = 4;
		while ((numColonne < 0) || (numColonne > 2))
		{
			saisieColonne = new Scanner(System.in);
			System.out.println("Veuillez saisir le numéro de colonne :");
			String colonne = saisieColonne.nextLine();
			numColonne = Integer.parseInt(colonne);
			numColonne = numColonne - 1;
			if((numColonne < 0) || (numColonne > 2))
				System.out.println("Hors tableau !");
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

}
