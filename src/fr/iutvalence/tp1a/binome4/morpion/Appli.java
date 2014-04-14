package fr.iutvalence.tp1a.binome4.morpion;

import java.util.Scanner;
import static fr.iutvalence.tp1a.binome4.morpion.Pion.*;

/**
 * @author Prinsac & Culty
 * @version 1.0
 */
public class Appli {
	/** Application g�n�rale. */
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Entrez le pseudo du joueur 1 (X) :");
		String pseudoJ1S = reader.nextLine();
		Joueur joueur1 = new Joueur(pseudoJ1S, X);
		System.out.println("Entrez le pseudo du joueur 2 (O) :");
		String pseudoJ2S = reader.nextLine();
		Joueur joueur2 = new Joueur(pseudoJ2S, O);
		Score gestionnaireScore = new Score(joueur1, joueur2);
		boolean rejouer=true;
		while(rejouer) {
			Morpion partie = new Morpion(joueur1, joueur2, gestionnaireScore);
			partie.jouer();
			Scanner rej = new Scanner(System.in);
			System.out.println("Voulez-vous rejouer ?");
			System.out.println("1 pour rejouer, 0 pour arrêter.");
			int demande = rej.nextInt();
			if(demande == 1)
				rejouer = true;
			else rejouer = false;
		}
	}
}
