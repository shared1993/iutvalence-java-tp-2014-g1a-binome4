package fr.iutvalence.tp1a.binome4.morpion;

import java.util.Scanner;

public class Saisir {
    
    public int saisir() {
	int numLigne, numColonne;
	
	if (Morpion.tour) {
	    System.out.printf("C'est à \"%s\" de jouer (X) :%n",Morpion.pseudoJ1);
	} else {
	    System.out.printf("C'est à \"%s\" de jouer (O) :%n",Morpion.pseudoJ2);
	}
	numLigne = 4;
	Scanner reader = new Scanner(System.in);
	while ((numLigne < 0) || (numLigne > 2)) {
	    System.out.println("Entrez le numéro de ligne :");
	    /* TODO Pourquoi ne pas récupérer directement un entier ? */
	    String ligneS = reader.nextLine();
	    numLigne = Integer.parseInt(ligneS) - 1;
	    if ((numLigne < 0) || (numLigne > 2)) {
		System.out.println("Hors tableau !");
	    }
	}
	numColonne = 4;
	while ((numColonne < 0) || (numColonne > 2)) {
	    System.out.println("Entrez le numéro de colonne :");
	    String colonneS = reader.nextLine();
	    numColonne = Integer.parseInt(colonneS) - 1;
	    if ((numColonne < 0) || (numColonne > 2)) {
		System.out.println("Hors tableau !");
	    }
	}
	
	return numLigne+numColonne;
    }
}
