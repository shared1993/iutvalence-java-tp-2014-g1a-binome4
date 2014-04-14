package fr.iutvalence.tp1a.binome4.morpion;

/**
 * TODO.
 * @author TODOs
 * @version 1.0.0
 */
public class Joueur {
	/** Nom du joueur */
    private final String nom;
    
    /** Pion du joueur */
    private final Pion pion;

	/** Constructeur du joueur avec le nom et le pion */
    public Joueur(String nom, Pion pion) {
    	this.nom = nom;
		this.pion = pion;
    }
    
    /** Accesseur pour le nom du joueur */
    public String nom() {
    	return nom;
    }
    
    /** Accesseur pour le pion du joueur */
    public Pion pion() {
    	return pion;
    }
}
