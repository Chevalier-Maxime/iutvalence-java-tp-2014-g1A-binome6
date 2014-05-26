package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import Application.Etat;
import Application.Grille;
import Application.Puissance4;



public class FenetreDAffichage implements Runnable, InteractionIHM
{
	
	private JButton[][] grilleIHM = new JButton[6][7];
	
	 public AffichagePanneauJoueur panneauJoueurGauche =new AffichagePanneauJoueur("joueur1","jaune");
	 public  AffichagePanneauJoueur panneauJoueurDroit =new AffichagePanneauJoueur("joueur2","rouge");
	 JFrame fenetre = new JFrame();
	 Grille grille = new Grille();
			
	public void run()
	{
		//*************************** caracteristique de la fenetre**************************
		
		fenetre.setResizable(false);
		fenetre.setTitle("Puissance 4");
		fenetre.setSize(1050, 600);
		fenetre.getContentPane().setLayout(new BorderLayout());
	    
	    JSplitPane panneauMilieu = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	    JPanel partieHauteMilieu =new JPanel();
	    final JPanel partieBasseMilieu =new JPanel();
	    
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
	// 	Grille grille = new Grille();
	 	for (int i = 0; i < 7; i++) {
	 		partieHauteMilieu.add(new BoutonColonne(i, grille, this));
	 	}

	 	partieBasseMilieu.setLayout(new GridLayout(6,7));
	 	panneauJoueurDroit.transformPanel();

	 	
	//***************************** Ajout des boutons au gridlayout et  rendre inactif*****************
	 		 		
	 	for(int i=0;i<Grille.NOMBRE_DE_LIGNES;i++){
	 		for(int j=0;j<Grille.NOMBRE_DE_COLONNES;j++){	 			
	 			partieBasseMilieu.add(grilleIHM[i][j] = new JButton());
	 			grilleIHM[i][j].setEnabled(false);
	 		}
	 	}
	

	
	 //*************************Diposition des diff�rents panel principaux*************************
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
		
		
		
		
		
		
		
		
		
		
		
	/*	
		
		
		 class boutonPlacement implements ActionListener
			{
		
			 
			 public void tourDeJeux(BoutonColonne[] b){
				
				 Color color = Color.red.brighter();
				 
				 for(int i=b.length-1;0<=i;i--){
					if(partie1.joueurCourant == Etat.JOUEUR_1){
					//	panneauJoueurGauche.remetPanel();
						
						if(b[i].estColore==false){
							//panneauJoueurGauche.getBackground().darker();
							position=b[i].positiony;
							numLigne=partie1.grille.placerPion(b[i].positiony,partie1.joueurCourant);
							b[i].setBackground(Color.YELLOW);
							b[i].estColore=true;
							if (partie1.grille.verifVictoire(numLigne, position, partie1.joueurCourant)==true){
								int rejouer = JOptionPane.showConfirmDialog(fenetre, "Felicitation Joueur 1, vous avez gagn�! \nVoulez vous rejouer ?", "Félicitation !", JOptionPane.YES_NO_OPTION);
								if (rejouer== JOptionPane.OK_OPTION)
								{
									fenetre.dispose();
									ApplicationDAffichageDeFenetre.main(null);
									
								}
									
								else
								{
									fenetre.dispose();	
								}
							}
							partie1.joueurCourant = Etat.JOUEUR_2;
							panneauJoueurGauche.transformPanel();
							panneauJoueurDroit.remetPanel();
							break;
						}	
				
					}
					else  
						if(partie1.joueurCourant == Etat.JOUEUR_2){
						//	panneauJoueurGauche.remetPanel();
						if(b[i].estColore==false){
							position=b[i].positiony;
							numLigne=partie1.grille.placerPion(b[i].positiony,partie1.joueurCourant);
							b[i].setBackground(Color.RED);
							b[i].estColore=true;
							if (partie1.grille.verifVictoire(numLigne, position, partie1.joueurCourant)==true){
								int rejouer = JOptionPane.showConfirmDialog(fenetre, "Felicitation Joueur 2, vous avez gagn�! \nVoulez vous rejouer ?", "Félicitation !", JOptionPane.YES_NO_OPTION);
								if (rejouer== JOptionPane.OK_OPTION)
								{
									fenetre.dispose();
									ApplicationDAffichageDeFenetre.main(null);
									
								}
									
								else
								{
									fenetre.dispose();	
								}
							}
							partie1.joueurCourant = Etat.JOUEUR_1;
							panneauJoueurDroit.transformPanel();
							panneauJoueurGauche.remetPanel();
						break;
						
						}
						}			
					}
			 }

				public void actionPerformed(ActionEvent e)
				{
					
					Object source = e.getSource();
					
					if (source == bColl1)
					{  
						tourDeJeux(boutonColonne1);
						if (partie1.grille.verifVictoire(numLigne, position, partie1.joueurCourant)==true){
							JOptionPane.showMessageDialog(fenetre, "Felicitation vous avez gagn�!");
							fenetre.dispose();	
						}
						
						
					} else	
						
//**********************************************Bouton 2**************************************************					
						if (source == bColl2)
						{
							
							tourDeJeux(boutonColonne2);							
							}	
					
//**********************************************Bouton 3**************************************************	
						else if (source == bColl3)
						{  
							tourDeJeux(boutonColonne3);	
						} 
					
//**********************************************Bouton 4**************************************************	
						else if (source == bColl4)
						{  
							tourDeJeux(boutonColonne4);	
						}
					
//**********************************************Bouton 5**************************************************	
						else if (source == bColl5)
						{  
							tourDeJeux(boutonColonne5);
						}
					
//**********************************************Bouton 6**************************************************	
						else if (source == bColl6)
						{  
							tourDeJeux(boutonColonne6);
						}
					
//**********************************************Bouton 7**************************************************	
						else if (source == bColl7)
						{  
							tourDeJeux(boutonColonne7);
						}					
				}
			
			}
		 
			

		bColl1.addActionListener(new boutonPlacement());
		bColl2.addActionListener(new boutonPlacement());
		bColl3.addActionListener(new boutonPlacement());
		bColl4.addActionListener(new boutonPlacement());
		bColl5.addActionListener(new boutonPlacement());
		bColl6.addActionListener(new boutonPlacement());
		bColl7.addActionListener(new boutonPlacement());
		
		
		
		
		
		
	}

*/
	@Override
	public void alerteMauvaisPlacement() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void placerPion(int ligne, int colonne, Etat joueurCourant) {
		this.grilleIHM[ligne][colonne].setBackground(joueurCourant.getColor());
		
	}


	@Override
	public void victoire(Etat joueurCourant) {
		// TODO Auto-generated method stub
/*		if (grille.verifVictoire(lignePion, colonnePion)){
			int rejouer = JOptionPane.showConfirmDialog(fenetre, "Felicitation Joueur 2, vous avez gagn�! \nVoulez vous rejouer ?", "Félicitation !", JOptionPane.YES_NO_OPTION);
			if (rejouer== JOptionPane.OK_OPTION)
			{
				fenetre.dispose();
				ApplicationDAffichageDeFenetre.main(null);
				
			}
				
			else
			{
				fenetre.dispose();	
			}
		
	}*/
	}


	@Override
	public void changerJoueur() {
		// mettre le changement de couleur du panel et essayer de se passer du joueur courant en parametre
		
	}

}
