package fr.iutvalence.tp1a.binome4.morpion;
/**
 * @author culty & prinsac
 */
import java.util.Scanner;

public class Pseudo
{
	private Scanner pseudoJ1;
	private Scanner pseudoJ2;
	private String pseudoJ1S;
	private String pseudoJ2S;
	
	public Pseudo(){
		this.pseudoJ1 = new Scanner(System.in);
		System.out.println("Pseudo du joueur 1 (X):");
		this.pseudoJ1S = pseudoJ1.nextLine();
		this.pseudoJ2 = new Scanner(System.in);
		System.out.println("Pseudo du joueur 2 (O):");
		this.pseudoJ2S = pseudoJ2.nextLine();
	}
	
	public String obtenirPseudoJ1(){
		return this.pseudoJ1S;
	}
	
	public String obtenirPseudoJ2(){
		return this.pseudoJ2S;
	}
}
