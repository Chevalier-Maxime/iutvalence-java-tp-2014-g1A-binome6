package Application;

import java.awt.Color;

/* TODO Package. */

/**
 * TODO.
 * 
 * @author Blanc-Partula
 * @version TODO
 */
public enum Etat {
	VIDE(".",Color.WHITE), JOUEUR_1("O",Color.YELLOW), JOUEUR_2("X",Color.RED);

	private final String representation;
	private final Color couleur;

	Etat(String repr,Color color) {
		representation = repr;
		couleur=color;
		
	}
	public Color getColor(){
		return this.couleur;
	}

	
	@Override
	public String toString() {
		return this.representation;
	}
	
}