package fr.iutvalence.tp1a.binome4.morpion;

import java.util.Scanner;

/**
 * TODO.
 *
 * @author Prinsac & Culty
 * @version 1.0
 */
public class Appli
{    
	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("Entrez le pseudo du joueur 1 (X) :");
		String pseudoJ1S = reader.nextLine();
		System.out.println("Entrez le pseudo du joueur 2 (O) :");
		String pseudoJ2S = reader.nextLine();
		new Score();
		for(int nbPartie = 0;nbPartie<3;nbPartie++)
		{
			Morpion partie = new Morpion();
			partie.jouer();
		}
	}
}
