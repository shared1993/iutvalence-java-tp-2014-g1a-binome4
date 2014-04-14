package fr.iutvalence.tp1a.binome4.morpion;

/**
 * @author Prinsac & Culty
 * @version 1.0
 */

import java.util.Scanner;

public class Saisir {

	/** Saisie du numero de ligne et de colonne où placer le pion. */
	public static int[] saisir() {
		int numLigne, numColonne;
		numLigne = 4;
		Scanner reader = new Scanner(System.in);
		while ((numLigne < 0) || (numLigne > 2)) {
			System.out.println("Entrez le numéro de ligne :");
			numLigne = reader.nextInt();
			numLigne = numLigne - 1;
			if ((numLigne < 0) || (numLigne > 2)) {
				System.out.println("Hors tableau !");
			}
		}
		numColonne = 4;
		while ((numColonne < 0) || (numColonne > 2)) {
			System.out.println("Entrez le numéro de colonne :");
			numColonne = reader.nextInt();
			numColonne = numColonne - 1;
			if ((numColonne < 0) || (numColonne > 2)) {
				System.out.println("Hors tableau !");
			}
		}

		return new int[] { numLigne, numColonne };
	}
}
