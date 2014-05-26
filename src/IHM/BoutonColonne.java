package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Application.Grille;

public class BoutonColonne extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final int colonne;
	private Grille grille;
	private InteractionIHM ihm;
	
	public BoutonColonne(int col, Grille grille, InteractionIHM ihm){
		colonne = col;
		this.grille = grille;
		this.ihm = ihm;
		this.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int ligne = grille.placerPion(colonne);
		if (ligne == -100) {
			ihm.alerteMauvaisPlacement();
		}
		else {
			ihm.placerPion(ligne,colonne,grille.getJoueurCourant());
			if (grille.verifVictoire(ligne, colonne)) {
				ihm.victoire(grille.getJoueurCourant());
			} else {
			ihm.changerJoueur();
			}
		}
	}
	
}
