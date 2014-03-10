/* TODO Javadoc */
/* TODO Package. */

/*
 * Les var de saisir (numLigne/numColonne) doivent être
 * modifié pour être utilisé dans tout le fichier.
 * 
 * 
 */

/**
 * @author culty & prinsac
 */
import java.util.Scanner;

public class Morpion {
    /* TODO Constantes ? */
    private static final int vide = 0;
    private final int pionJoueur1 = 1;
    private final int pionJoueur2 = 2;
    private int[][] tableau;
    private boolean tour;

    public Morpion() {

	tableau = new int[][] { { vide, vide, vide }, { vide, vide, vide },
		{ vide, vide, vide } };
	tour = true; /*
		      * tour=true: le joueur 1 joue, tour=false: le joueur 2
		      * joue
		      */
    }

    public void jouer(){
	System.out.println(toString());// Afficher
	saisir() ;// Saisir
	poserPion(numLigne,numColonne);// poserPion
	System.out.println(toString());
	// Victoire ?
    }

    public void poserPion(int numeroDeLigne, int numeroDeColonne)  {
	tableau[numeroDeLigne][numeroDeColonne] = tour ? pionJoueur1 : pionJoueur2;
	tour = !tour;
    }

    public String toString() {
	String morpionAsciiArt = "";

	for (int numeroDeLigne = 0; numeroDeLigne < 3; numeroDeLigne++) {
	    for (int numeroDeColonne = 0; numeroDeColonne < 3; numeroDeColonne++) {
		if(this.tableau[numeroDeLigne][numeroDeColonne] == vide)
		    morpionAsciiArt += "  ";
		else
    			if (this.tableau[numeroDeLigne][numeroDeColonne] == pionJoueur1)
    			    morpionAsciiArt += "x ";
    			else
    			    morpionAsciiArt += "o ";
		
	    }
	    morpionAsciiArt += "\n";
	}

	return morpionAsciiArt;
    }

    public void saisir() {	
	int numLigne = 4; 
	while((numLigne < 0) || (numLigne > 2)){
	    	Scanner saisieLigne = new Scanner(System.in);
		System.out.println("Veuillez saisir le numéro de ligne :");
		String ligne = saisieLigne.nextLine();
		numLigne = Integer.parseInt(ligne);
		numLigne = numLigne - 1;
	}
	int numColonne = 4;
	while((numColonne < 0) || (numColonne > 2)){
	    Scanner saisieColonne = new Scanner(System.in);
	    System.out.println("Veuillez saisir le numéro de colonne :");
	    String colonne = saisieColonne.nextLine();
	    numColonne = Integer.parseInt(colonne);
	    numColonne = numColonne - 1;
	}
	
    }

}