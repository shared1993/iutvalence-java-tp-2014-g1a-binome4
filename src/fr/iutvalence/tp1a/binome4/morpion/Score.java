package fr.iutvalence.tp1a.binome4.morpion;
/**
 * @author culty & prinsac
 */

public class Score
{
	public static int scoreJ1;
	public static int scoreJ2;
	public static int scoreNul;
	
	public Score()
	{
		scoreJ1 = 0;
		scoreJ2 = 0;
		scoreNul = 0;
	}
	
	public static void gagne(String gagnant)
	{
		if(gagnant==Pseudo.pseudoJ1)
			scoreJ1++;
		if(gagnant==Pseudo.pseudoJ2)
			scoreJ2++;
	}
	
	public static void nul()
	{
		scoreNul++;
	}
}
