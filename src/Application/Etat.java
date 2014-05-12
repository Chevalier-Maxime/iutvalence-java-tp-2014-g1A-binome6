package Application;
/* TODO Package. */

/**
 * TODO.
 * 
 * @author Blanc-Partula
 * @version TODO
 */
public enum Etat {
	VIDE("."), JOUEUR_1("O"), JOUEUR_2("X");

	private final String representation;

	Etat(String repr) {
		representation = repr;
	}

	@Override
	public String toString() {
		return this.representation;
	}
}