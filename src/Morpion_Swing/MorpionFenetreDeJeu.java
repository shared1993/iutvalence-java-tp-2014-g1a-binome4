package Morpion_Swing;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MorpionFenetreDeJeu extends JFrame {
	XOBouttons buttons[] = new XOBouttons[9];
	public  MorpionFenetreDeJeu (){
		build(); //initialisation de la fenetre
	}
	
	private void build(){
		setTitle("Jeu de Morpion"); //On donne un titre � l'application
		setSize(400,400); //On donne une taille � notre fen�tre
		setLocationRelativeTo(null); //On centre la fen�tre sur l'�cran
		setResizable(false); //On interdit la redimensionnement de la fen�tre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit � l'application de se fermer lors du clic sur la croix
		setContentPane(buildContentPane());
	}
	
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		for(int i=0;i<9;i++){
			buttons[i] = new XOBouttons();
			panel.add(buttons[i]);
		}
		panel.setBackground(Color.white);
		//JLabel label1 = new JLabel("score Joueur1");
		//JLabel label2 = new JLabel("score Joueur2");
		
		//panel.add(label1);
		//panel.add(label2);
		return panel;
	}

}
