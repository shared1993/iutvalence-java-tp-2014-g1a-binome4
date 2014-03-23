package fr.iutvalence.tp1a.binome4.morpion;

import java.util.Scanner;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
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
		/* TODO Vous ne retenez pas les références ? */
        new Pseudo(pseudoJ1S,pseudoJ2S);
		new Score();
        /* TODO Remplacez cette boucle infinie. */
		while(true)
		{
			Morpion partie = new Morpion();
			partie.jouer();
		}
	}
}
