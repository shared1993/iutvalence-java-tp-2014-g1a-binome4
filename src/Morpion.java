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
    /* TODO Constante ? */
    private static final int VIDE        = 0;
    /* TODO Constante ? */
    private final        int pionJoueur1 = 1;
    /* TODO Constante ? */
    private final        int pionJoueur2 = 2;
    /* TODO Est-ce que ça change en cours de partie ? */
    private int[][] tableau;
    private boolean tour;

    public Morpion() {
        /* TODO Peut être simplifié en "new int [3][3]" parce que VIDE=0 */
        tableau = new int[][]{{VIDE, VIDE, VIDE}, {VIDE, VIDE, VIDE}, {VIDE, VIDE, VIDE}};
        tour = true;
        /* TODO Dans la JavaDoc ! */
        /*
              * tour=true: le joueur 1 joue, tour=false: le joueur 2
		      * joue
		      */
    }

    public void jouer() {
        System.out.println(toString());// Afficher
        saisir();// Saisir
        poserPion(numLigne, numColonne);// poserPion
        System.out.println(toString());
	// Victoire ?
    }

    public void poserPion(int numeroDeLigne, int numeroDeColonne)  {
	tableau[numeroDeLigne][numeroDeColonne] = tour ? pionJoueur1 : pionJoueur2;
	tour = !tour;
    }

    /* TODO Peut être simplifié avec un enum. À discuter. */
    public String toString() {
	String morpionAsciiArt = "";

	for (int numeroDeLigne = 0; numeroDeLigne < 3; numeroDeLigne++) {
	    for (int numeroDeColonne = 0; numeroDeColonne < 3; numeroDeColonne++) {
		if(this.tableau[numeroDeLigne][numeroDeColonne] == VIDE)
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

    /* TODO numLigne et numColonne deviennent des attributs. */
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
