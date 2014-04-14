package fr.iutvalence.tp1a.binome4.morpion;

/**
 * TODO.
 * @author TODOs
 * @version 1.0.0
 */
public class Joueur {
    private final String nom;
    
    private final Pion pion;

    public Joueur(String nom, Pion pion) {
    	this.nom = nom;
		this.pion = pion;
    }
    
    public String nom() {
    	return nom;
    }
    
    public Pion pion() {
    	return pion;
    }
}
