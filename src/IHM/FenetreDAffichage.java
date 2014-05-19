package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

public class FenetreDAffichage implements Runnable
{
	//private JSplitPane split;
	
	public void run()
	{
		JFrame fenetre = new JFrame();
		fenetre.setResizable(false);
		
		// bouton de selection grille
		JButton bColl1 = new JButton("v");
		JButton bColl2 = new JButton("v");
		JButton bColl3 = new JButton("v");
		JButton bColl4 = new JButton("v");
		JButton bColl5 = new JButton("v");
		JButton bColl6 = new JButton("v");
		JButton bColl7 = new JButton("v");
		
		// bouton de la grille
		


		
		fenetre.setTitle("Puissance 4");
		fenetre.setSize(1050, 600);
		
		//On définit le layout à utiliser sur le content pane
	    fenetre.getContentPane().setLayout(new BorderLayout());
	    
	    //Au nord
	    //*TODO afficher boite de dialogue pour recuperer le nom*/
	    AffichagePanneauJoueur panneauJoueurGauche =new AffichagePanneauJoueur("joueur1","jaune");
	    AffichagePanneauJoueur panneauJoueurDroit =new AffichagePanneauJoueur("joueur2","rouge");
	 	
	    JSplitPane panneauMilieu = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	    JPanel partieHauteMilieu =new JPanel();
	    JPanel partieBasseMilieu =new JPanel();
	    
	    panneauMilieu.add(partieHauteMilieu);
	    panneauMilieu.add(partieBasseMilieu);
	    panneauMilieu.setSize(800,600);
	 	partieHauteMilieu.setSize(800,250);
	 	partieHauteMilieu.setBackground(Color.GREEN);
	 	partieBasseMilieu.setBackground(Color.BLUE);
	 	panneauMilieu.setEnabled(false);
	 	panneauMilieu.setBorder(null);
	 	panneauMilieu.setDividerSize(0);
	 	partieHauteMilieu.setLayout(new GridLayout(1,7));
	 	partieHauteMilieu.add(bColl1);
	 	partieHauteMilieu.add(bColl2);
	 	partieHauteMilieu.add(bColl3);
	 	partieHauteMilieu.add(bColl4);
	 	partieHauteMilieu.add(bColl5);
	 	partieHauteMilieu.add(bColl6);
	 	partieHauteMilieu.add(bColl7);
	 	
	 	partieBasseMilieu.setLayout(new GridLayout(6,7));
	 	for(int i=0;i<6*7;i++){
	 		partieBasseMilieu.add(new JButton(" "));
	 		partieBasseMilieu.getComponent(i).setEnabled(false);
	 	}
	 	//p4.getComponent(n)
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 
	 	fenetre.getContentPane().add(panneauMilieu, BorderLayout.CENTER);
	    //À l'ouest
	    fenetre.getContentPane().add(panneauJoueurGauche, BorderLayout.WEST);
	    //À l'est
	    fenetre.getContentPane().add(panneauJoueurDroit, BorderLayout.EAST);
		// Spécification du comportement à la fermeture de la fenêtre (ici, destruction)
		fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//fenetre.pack();
		fenetre.setVisible(true);
	}

}
