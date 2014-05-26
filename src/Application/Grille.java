package Application;
/* TODO Package. */

/**
 * TODO.
 * 
 * @author Blanc-Partula
 * @version TODO
 */
public class Grille {
	/** Le nombre de cases par ligne. */
	public static final int NOMBRE_DE_LIGNES = 6;
	/** Le nombre de cases par colonne. */
	public static final int NOMBRE_DE_COLONNES = 7;
	
	private static final Etat joueurParDefaut = Etat.JOUEUR_1;

	/* TODO Change en cours de partie ? */
	/** Les cases de la grille. */
	private Etat[][] cases;
	
	private Etat joueurCourant;

	/** Construire une nouvelle grille vide. */
	public Grille() {
		this.cases = new Etat[Grille.NOMBRE_DE_LIGNES][Grille.NOMBRE_DE_COLONNES];
		this.joueurCourant=joueurParDefaut;

		for (int numeroDeLigne = 0; numeroDeLigne < Grille.NOMBRE_DE_LIGNES; numeroDeLigne++) {
			for (int numeroDeColonne = 0; numeroDeColonne < Grille.NOMBRE_DE_COLONNES; numeroDeColonne++) {
				this.cases[numeroDeLigne][numeroDeColonne] = Etat.VIDE;
			}
		}
	}
/*
	public int placerPion(int colonne) {
		return placerPion(colonne,Etat.JOUEUR_1);
	}
*/
	
	/** TODO. */
	public int placerPion(int colonnePion) {
		if (colonnePion > Grille.NOMBRE_DE_LIGNES || colonnePion < 0) {
			return colonnePion;
		}

		int i = NOMBRE_DE_LIGNES - 1;
		do {
			if (cases[i][colonnePion] == Etat.VIDE) {
				cases[i][colonnePion] = joueurCourant;
				int numLigne = i;
				
				if (this.joueurCourant==Etat.JOUEUR_1)
					this.joueurCourant=Etat.JOUEUR_2;
				else 
					this.joueurCourant=Etat.JOUEUR_1;
				
				return numLigne;
			}
			i--;
		} while (i >= 0);
		return -100;
		/* XXX INDIQUER LE PROBLEME */
	}

	/**
	 * Obtenir une repr�sentation en ASCII de la grille.
	 */
	public String toString() {
		String grillealpha = "";

		for (int numeroDeLigne = 0; numeroDeLigne < Grille.NOMBRE_DE_LIGNES; numeroDeLigne++) {
			grillealpha += '|';
			for (int numeroDeColonne = 0; numeroDeColonne < Grille.NOMBRE_DE_COLONNES; numeroDeColonne++) {
				grillealpha += this.cases[numeroDeLigne][numeroDeColonne]
						.toString();
				grillealpha += '|';
			}
			grillealpha += "\n";
		}
		grillealpha += " \n 0 1 2 3 4 5 6";
		return grillealpha;
	}

	/** m�thode de v�rification du puissance 4 */
	public boolean verifVictoire(int lignePion, int colonnePion) {

		/** v�rifie si il n'y a pas un puissance 4 sur une ligne */
		int compteur = 0;
		for (int i = 0; i < NOMBRE_DE_COLONNES; i++) {
			if (cases[lignePion][i] == joueurCourant) {
				compteur++;
			} else {
				compteur = 0;
			}
			if (compteur == 4) {
				return true;
			}
		}

		/** v�rifie si il n'y a pas un puissance 4 sur une colonne */
		compteur = 0;
		for (int i = 0; i < NOMBRE_DE_LIGNES; i++) {
			if (cases[i][colonnePion] == joueurCourant) {
				compteur++;
			} else {
				compteur = 0;
			}
			if (compteur == 4) {
				return true;
			}
		}

		/** v�rifie si il n'y a pas un puissance 4 sur la diagonale (0,0) */
		compteur = 0;
		for (int i = 0; i < NOMBRE_DE_LIGNES; i++) {
			if (cases[i][i] == joueurCourant) {
				compteur++;
			} else {
				compteur = 0;
			}
			if (compteur == 4) {
				return true;
			}
		}

		/** v�rifie si il n'y a pas un puissance 4 sur la diagonale (1,0) */
		compteur = 0;
		for (int i = 1; i < NOMBRE_DE_LIGNES; i++) {
			if (cases[i][i - 1] == joueurCourant) {
				compteur++;
			} else {
				compteur = 0;
			}
			if (compteur == 4) {
				return true;
			}
		}

		/**
		 * v�rifie si il n'y a pas un puissance 4 sur la diagonale (2,0) on ne
		 * fera pas les diagonales en-dessous car il est impossible d'aligner 4
		 * pions sur celle-ci
		 */
		compteur = 0;
		for (int i = 2; i < NOMBRE_DE_LIGNES; i++) {
			if (cases[i][i - 2] == joueurCourant) {
				compteur++;
			} else {
				compteur = 0;
			}
			if (compteur == 4) {
				return true;
			}
		}

		/** v�rifie si il n'y a pas un puissance 4 sur la diagonale (0,1) */
		compteur = 0;
		for (int i = 1; i < NOMBRE_DE_LIGNES; i++) {
			if (cases[i - 1][i] == joueurCourant) {
				compteur++;
			} else {
				compteur = 0;
			}
			if (compteur == 4) {
				return true;
			}
		}

		/** v�rifie si il n'y a pas un puissance 4 sur la diagonale (0,2) */
		compteur = 0;
		for (int i = 2; i < NOMBRE_DE_LIGNES; i++) {
			if (cases[i - 2][i] == joueurCourant) {
				compteur++;
			} else {
				compteur = 0;
			}
			if (compteur == 4) {
				return true;
			}
		}

		/**
		 * v�rifie si il n'y a pas un puissance 4 sur la diagonale (0,3) on ne
		 * fera pas les diagonales au-dessus car il est impossible de poser 4
		 * pions sur celle-ci
		 */
		compteur = 0;
		for (int i = 3; i < NOMBRE_DE_LIGNES; i++) {
			if (cases[i - 3][i] == joueurCourant) {
				compteur++;
			} else {
				compteur = 0;
			}
			if (compteur == 4) {
				return true;
			}
		}

		/** v�rifie si il n'y a pas un puissance 4 sur la diagonale (0,6) */
		compteur = 0;
		for (int i = 0; i < NOMBRE_DE_LIGNES; i++) {
			if (cases[i][6 - i] == joueurCourant) {
				compteur++;
			} else {
				compteur = 0;
			}
			if (compteur == 4) {
				return true;
			}
		}

		/** v�rifie si il n'y a pas un puissance 4 sur la diagonale (1,6) */
		compteur = 0;
		for (int i = 1; i < NOMBRE_DE_LIGNES; i++) {
			if (cases[i][7 - i] == joueurCourant) {
				compteur++;
			} else {
				compteur = 0;
			}
			if (compteur == 4) {
				return true;
			}
		}

		/** v�rifie si il n'y a pas un puissance 4 sur la diagonale (2,6) */
		compteur = 0;
		for (int i = 2; i < NOMBRE_DE_LIGNES; i++) {
			if (cases[i][8 - i] == joueurCourant) {
				compteur++;
			} else {
				compteur = 0;
			}
			if (compteur == 4) {
				return true;
			}
		}

		/** v�rifie si il n'y a pas un puissance 4 sur la diagonale (0,5) */
		compteur = 0;
		for (int i = 0; i < NOMBRE_DE_LIGNES; i++) {
			if (cases[i][5 - i] == joueurCourant) {
				compteur++;
			} else {
				compteur = 0;
			}
			if (compteur == 4) {
				return true;
			}
		}

		/** v�rifie si il n'y a pas un puissance 4 sur la diagonale (0,4) */
		compteur = 0;
		for (int i = 0; i < NOMBRE_DE_LIGNES-1; i++) {
			if (cases[i][4 - i] == joueurCourant) {
				compteur++;
			} else {
				compteur = 0;
			}
			if (compteur == 4) {
				return true;
			}
		}
		
		/** v�rifie si il n'y a pas un puissance 4 sur la diagonale (0,4) */
		compteur = 0;
		for (int i = 0; i < NOMBRE_DE_LIGNES-2; i++) {
			if (cases[i][3 - i] == joueurCourant) {
				compteur++;
			} else {
				compteur = 0;
			}
			if (compteur == 4) {
				return true;
			}
		}
		
		return false;
	}

	
	
public Etat getJoueurCourant() {
	return joueurCourant;
}
}