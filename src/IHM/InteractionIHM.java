package IHM;

import Application.Etat;

public interface InteractionIHM {
	public void alerteMauvaisPlacement();

	public void placerPion(int ligne, int colonne, Etat joueurCourant);

	public void victoire(Etat joueurCourant);

	public void changerJoueur();
	
}
