package Morpion_Swing;

import javax.swing.SwingUtilities;

public class Main {
	
	public static void main(String[] args){
	SwingUtilities.invokeLater(new Runnable(){
		public void run(){
			MorpionFenetreDeJeu fenetre = new MorpionFenetreDeJeu();
			fenetre.setVisible(true);
		}
	});

	}
}
