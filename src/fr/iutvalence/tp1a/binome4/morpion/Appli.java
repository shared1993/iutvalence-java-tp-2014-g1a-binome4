package fr.iutvalence.tp1a.binome4.morpion;

import java.util.Scanner;
import static fr.iutvalence.tp1a.binome4.morpion.Pion.*;

/**
 * @author Prinsac & Culty
 * @version 1.0
 */
public class Appli
{    
	/** Application g�n�rale. */
	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("Entrez le pseudo du joueur 1 (X) :");
		String pseudoJ1S = reader.nextLine();
		Joueur joueur1 = new Joueur(pseudoJ1S, JOUEUR1);
		System.out.println("Entrez le pseudo du joueur 2 (O) :");
		String pseudoJ2S = reader.nextLine();
		Joueur joueur2 = new Joueur(pseudoJ2S, JOUEUR2);
		Score gestionnaireScore = new Score(joueur1,joueur2);
		for(int nbPartie = 0; nbPartie<3;nbPartie++)
		{
			Morpion partie = new Morpion(joueur1, joueur2, gestionnaireScore);
			partie.jouer();
		}
	}
}
 