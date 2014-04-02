package fr.iutvalence.tp1a.binome4.morpion;

/**
 * @author Prinsac & Culty
 * @version 1.0
 */

import java.util.Scanner;

public class Appli
{    
	/** Application générale. */
	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("Entrez le pseudo du joueur 1 (X) :");
		String pseudoJ1S = reader.nextLine();
		System.out.println("Entrez le pseudo du joueur 2 (O) :");
		String pseudoJ2S = reader.nextLine();
		new Score(pseudoJ1S,pseudoJ2S);
		for(int nbPartie = 0;nbPartie<3;nbPartie++)
		{
			Morpion partie = new Morpion();
			partie.jouer();
		}
	}
}
 