package fr.iutvalence.tp1a.binome4.morpion;
import java.util.Scanner;
/**
 * @author culty & prinsac
 */

public class Appli
{
	public static void main(String[] args)
	{
		Scanner pseudoJ1 = new Scanner(System.in);
		System.out.println("Entrez le pseudo du joueur 1 (X) :");
		String pseudoJ1S = pseudoJ1.nextLine();
		Scanner pseudoJ2 = new Scanner(System.in);
		System.out.println("Entrez le pseudo du joueur 2 (O) :");
		String pseudoJ2S = pseudoJ2.nextLine();
		new Pseudo(pseudoJ1S,pseudoJ2S);
		new Score();
		while(true)
		{
			Morpion partie = new Morpion();
			partie.jouer();
		}
	}
}
