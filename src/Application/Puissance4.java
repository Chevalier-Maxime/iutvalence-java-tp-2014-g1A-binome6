package Application;
/* TODO Package. */
import java.util.Scanner;

/**
 * TODO.
 * 
 * @author Blanc-Partula
 * @version TODO
 */
public class Puissance4 {
	/** TODO. */

	
	/* TODO Change en cours de partie ? */
	/** TODO. */
	public Grille grille;

	public Puissance4() {
		//this.joueurCourant = t;
		this.grille = new Grille();
	}

	public void jouer() {
		int i = 0;
		while (i <= 0) {

			System.out.println("Veuillez saisir le num�ro de colonne");
			Scanner sc = new Scanner(System.in);
			int numScan = sc.nextInt();
			int numLigne = grille.placerPion(numScan);
			System.out.println(grille);
			boolean victoire = grille.verifVictoire(numLigne, numScan);
			System.out.println(victoire);
			
			
			i = i - 1;
			if (victoire==true){
				break;
			}
			/* Saisir */
			/* Tenter de poser. */
			/* Victoire. */
			/* Saisir mettre dans application */
			/* Tenter de poser. */
			/* Victoire ? */
		}
		System.out.println("Bravo tu as gagn�");
	}
}