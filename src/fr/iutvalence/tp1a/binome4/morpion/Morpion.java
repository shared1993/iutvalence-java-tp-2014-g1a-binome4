package fr.iutvalence.tp1a.binome4.morpion;
/**
 * @author culty & prinsac
 */
import java.util.Scanner;

public class Morpion {
    private static final int VIDE = 0;
    private static final int pionJoueur1 = 1;
    private static final int pionJoueur2 = 2;
    private final int[][] tableau;
    private boolean tour;
    private int numLigne;
    private int numColonne;
    private int nbTour = 0;
    
    public Morpion() {
        /* TODO Peut être simplifié en "new int [3][3]" parce que VIDE=0 */
        tableau = new int[][]{{VIDE, VIDE, VIDE}, {VIDE, VIDE, VIDE}, {VIDE, VIDE, VIDE}};
        tour = true;
        /** tour=true: le joueur 1 joue, tour=false: le joueur 2 joue */
    }

    public void jouer() {
	System.out.println(toString());// Afficher
        while((!victoire())&&(nbTour<9)){
            saisir();// Saisir
            poserPion(numLigne, numColonne);// poserPion
            System.out.println(toString());// Afficher
            victoire();
       }
       if((victoire())&&(tour))
	   System.out.println("Le joueur 2 a gagné !");
       if((victoire())&&(!tour))
	   System.out.println("Le joueur 1 a gagné !");
       if(!victoire())
	   System.out.println("Match nul !");
	   
    }

    public void poserPion(int ligne, int colonne)  {
	if(tableau[ligne][colonne]!=VIDE){
	    System.out.println("Case déjà occupée !");
	    jouer();
	}
	else{
	    tableau[ligne][colonne] = tour ? pionJoueur1 : pionJoueur2;
	    tour = !tour;
	    nbTour++;
	}
    }

    /* TODO Peut être simplifié avec un enum. À discuter. */
    public String toString() {
	String morpionAsciiArt = "";

	for (int numeroDeLigne = 0; numeroDeLigne < 3; numeroDeLigne++) {
	    for (int numeroDeColonne = 0; numeroDeColonne < 3; numeroDeColonne++) {
		if(this.tableau[numeroDeLigne][numeroDeColonne] == VIDE)
		    morpionAsciiArt += "a ";
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
	if(tour)
	    System.out.println("Joueur 1 :");
	else
	    System.out.println("Joueur 2 :");
	numLigne = 4;
	while((numLigne < 0) || (numLigne > 2)){
	    	Scanner saisieLigne = new Scanner(System.in);
		System.out.println("Veuillez saisir le numéro de ligne :");
		String ligne = saisieLigne.nextLine();
		numLigne = Integer.parseInt(ligne);
		numLigne = numLigne - 1;
		if((numLigne<0)||(numLigne>2))
		    System.out.println("Hors tableau !");
	}
	numColonne = 4;
	while((numColonne < 0) || (numColonne > 2)){
	    Scanner saisieColonne = new Scanner(System.in);
	    System.out.println("Veuillez saisir le numéro de colonne :");
	    String colonne = saisieColonne.nextLine();
	    numColonne = Integer.parseInt(colonne);
	    numColonne = numColonne - 1;
	    if((numColonne<0)||(numColonne>2))
		    System.out.println("Hors tableau !");
	}

    }
    
    public boolean victoire(){
	return
		(((tableau[0][0]==tableau[0][1])&&(tableau[0][0]==tableau[0][2]))&&(tableau[0][0]!=VIDE)) || 
		(((tableau[1][0]==tableau[1][1])&&(tableau[1][0]==tableau[1][2]))&&(tableau[1][0]!=VIDE)) ||
		(((tableau[2][0]==tableau[2][1])&&(tableau[2][0]==tableau[2][2]))&&(tableau[2][0]!=VIDE)) ||
		(((tableau[0][0]==tableau[1][0])&&(tableau[0][0]==tableau[2][0]))&&(tableau[0][0]!=VIDE)) ||
		(((tableau[0][1]==tableau[1][1])&&(tableau[0][1]==tableau[2][1]))&&(tableau[0][1]!=VIDE)) ||
		(((tableau[0][2]==tableau[1][2])&&(tableau[0][2]==tableau[2][2]))&&(tableau[0][2]!=VIDE)) ||
		(((tableau[0][0]==tableau[1][1])&&(tableau[0][0]==tableau[2][2]))&&(tableau[0][0]!=VIDE)) ||
		(((tableau[0][2]==tableau[1][1])&&(tableau[0][2]==tableau[2][0]))&&(tableau[0][2]!=VIDE))
	;
    }

}
