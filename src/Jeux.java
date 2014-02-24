/**
 * @author culty & prinsac
 */
public class Jeux {
	
    private int tableau[][] = {{0,0,0},{0,0,0},{0,0,0}}; // Tableau représentant la grille
    private int joueur1 = 1; // Numéro du joueur 1
    private int joueur2 = 2; // Numéro du joueur 2
    private boolean tour = true; //tour=true: le joueur 1 joue, tour=false: le joueur 2 joue
    
    public void Jeux(){
    }
 
    public void poserPion(){
	if (tour == true){
	   tableau[][] = {{0,0,0},{0,0,0},{0,0,0}};
	    tour = !tour;
	}
	else{
	    
	}
    }
}