package fr.iutvalence.tp1a.binome4.morpion;
/**
 * @author culty & prinsac
 */
public class AsciiUI
{

	public String toString()
	{
		String morpionAsciiArt = "";
		for(int numeroDeLigne = 0; numeroDeLigne < 3; numeroDeLigne++)
		{
			morpionAsciiArt += "------------- \n";
			for(int numeroDeColonne = 0; numeroDeColonne < 3; numeroDeColonne++)
			{
				morpionAsciiArt += "| ";
				if(this.tableau[numeroDeLigne][numeroDeColonne] == VIDE)
					morpionAsciiArt += "  ";
				else if(this.tableau[numeroDeLigne][numeroDeColonne] == pionJoueur1)
					morpionAsciiArt += "X ";
				else
					morpionAsciiArt += "O ";
			}
			morpionAsciiArt += "|";
			morpionAsciiArt += "\n";
		}
		morpionAsciiArt += "------------- \n";
		return morpionAsciiArt;
	}
}
