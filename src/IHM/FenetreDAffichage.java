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

public class FenetreDAffichage implements Runnable
{
	
	public JButton bColl1 = new JButton("v");
	public JButton bColl2 = new JButton("v");
	public JButton bColl3 = new JButton("v");
	public JButton bColl4 = new JButton("v");
	public JButton bColl5 = new JButton("v");
	public JButton bColl6 = new JButton("v");
	public JButton bColl7 = new JButton("v");
	public JFrame fenetre = new JFrame();
	
	public boutonGrille bg00 = new boutonGrille(false,0,0);
	public boutonGrille bg01 = new boutonGrille(false,0,1);
	public boutonGrille bg02 = new boutonGrille(false,0,2);
	public boutonGrille bg03 = new boutonGrille(false,0,3);
	public boutonGrille bg04 = new boutonGrille(false,0,4);
	public boutonGrille bg05 = new boutonGrille(false,0,5);
	public boutonGrille bg06 = new boutonGrille(false,0,6);
	public boutonGrille bg10 = new boutonGrille(false,1,0);
	public boutonGrille bg11 = new boutonGrille(false,1,1);
	public boutonGrille bg12= new boutonGrille(false,1,2);
	public boutonGrille bg13 = new boutonGrille(false,1,3);
	public boutonGrille bg14 = new boutonGrille(false,1,4);
	public boutonGrille bg15 = new boutonGrille(false,1,5);
	public boutonGrille bg16 = new boutonGrille(false,1,6);
	public boutonGrille bg20 = new boutonGrille(false,2,0);
	public boutonGrille bg21 = new boutonGrille(false,2,1);
	public boutonGrille bg22 = new boutonGrille(false,2,2);
	public boutonGrille bg23 = new boutonGrille(false,2,3);
	public boutonGrille bg24 = new boutonGrille(false,2,4);
	public boutonGrille bg25 = new boutonGrille(false,2,5);
	public boutonGrille bg26 = new boutonGrille(false,2,6);
	public boutonGrille bg30 = new boutonGrille(false,3,0);
	public boutonGrille bg31 = new boutonGrille(false,3,1);
	public boutonGrille bg32 = new boutonGrille(false,3,2);
	public boutonGrille bg33 = new boutonGrille(false,3,3);
	public boutonGrille bg34 = new boutonGrille(false,3,4);
	public boutonGrille bg35 = new boutonGrille(false,3,5);
	public boutonGrille bg36 = new boutonGrille(false,3,6);
	public boutonGrille bg40 = new boutonGrille(false,4,0);
	public boutonGrille bg41 = new boutonGrille(false,4,1);
	public boutonGrille bg42 = new boutonGrille(false,4,2);
	public boutonGrille bg43= new boutonGrille(false,4,3);
	public boutonGrille bg44 = new boutonGrille(false,4,4);
	public boutonGrille bg45 = new boutonGrille(false,4,5);
	public boutonGrille bg46 = new boutonGrille(false,4,6);
	public boutonGrille bg50 = new boutonGrille(false,5,0);
	public boutonGrille bg51 = new boutonGrille(false,5,1);
	public boutonGrille bg52= new boutonGrille(false,5,2);
	public boutonGrille bg53 = new boutonGrille(false,5,3);
	public boutonGrille bg54 = new boutonGrille(false,5,4);
	public boutonGrille bg55 = new boutonGrille(false,5,5);
	public boutonGrille bg56 = new boutonGrille(false,5,6);
	
	 public AffichagePanneauJoueur panneauJoueurGauche =new AffichagePanneauJoueur("joueur1","jaune");
	 public  AffichagePanneauJoueur panneauJoueurDroit =new AffichagePanneauJoueur("joueur2","rouge");
		
	public Puissance4 partie1 = new Puissance4(Etat.JOUEUR_1);
	public int numLigne;
	public boolean victoire;
	public int position;
	
	
	public void run()
	{
		//*************************** caracteristique de la fenetre**************************
		fenetre.setResizable(false);
		fenetre.setTitle("Puissance 4");
		fenetre.setSize(1050, 600);
		//On d√©finit le layout √† utiliser sur le content pane
	    fenetre.getContentPane().setLayout(new BorderLayout());
	    
	    //Au nord
	    //*TODO afficher boite de dialogue pour recuperer le nom*/
	   
	 	
	    
	    
	    
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
	 	partieHauteMilieu.add(bColl1);
	 	partieHauteMilieu.add(bColl2);
	 	partieHauteMilieu.add(bColl3);
	 	partieHauteMilieu.add(bColl4);
	 	partieHauteMilieu.add(bColl5);
	 	partieHauteMilieu.add(bColl6);
	 	partieHauteMilieu.add(bColl7);
	 	

	 	partieBasseMilieu.setLayout(new GridLayout(6,7));
	 	
	 	panneauJoueurDroit.transformPanel();

	 	
	//***************************** Ajout des boutons au gridlayout et  rendre inactif*****************
	 	
	 	boutonGrille ensembleBouton[]={bg00,bg01,bg02,bg03,bg04,bg05,bg06,bg10,bg11,bg12,bg13,bg14,bg15,bg16,bg20,bg21,bg22,bg23,bg24,bg25,bg26,bg30,bg31,bg32,bg33,bg34,bg35,bg36,bg40,bg41,bg42,bg43,bg44,bg45,bg46,bg50,bg51,bg52,bg53,bg54,bg55,bg56};
	 		
	 	for(int i=0;i<ensembleBouton.length;i++){
	 		partieBasseMilieu.add(ensembleBouton[i]);
	 		ensembleBouton[i].setEnabled(false);
	 	}
	

	
	 //*************************Diposition des diffÈrents panel principaux*************************
	 	fenetre.getContentPane().add(panneauMilieu, BorderLayout.CENTER);
	    //√Ä l'ouest
	    fenetre.getContentPane().add(panneauJoueurGauche, BorderLayout.WEST);
	    //√Ä l'est
	    fenetre.getContentPane().add(panneauJoueurDroit, BorderLayout.EAST);
		// Sp√©cification du comportement √† la fermeture de la fen√™tre (ici, destruction)
		fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//fenetre.pack();
		fenetre.setVisible(true);

		
		 class boutonPlacement implements ActionListener
			{
			public boutonGrille boutonColonne1[] ={bg00,bg10,bg20,bg30,bg40,bg50};
			public boutonGrille boutonColonne2[] ={bg01,bg11,bg21,bg31,bg41,bg51};
			public boutonGrille boutonColonne3[] ={bg02,bg12,bg22,bg32,bg42,bg52};
			public boutonGrille boutonColonne4[] ={bg03,bg13,bg23,bg33,bg43,bg53};
			public boutonGrille boutonColonne5[] ={bg04,bg14,bg24,bg34,bg44,bg54};
			public boutonGrille boutonColonne6[] ={bg05,bg15,bg25,bg35,bg45,bg55};
			public boutonGrille boutonColonne7[] ={bg06,bg16,bg26,bg36,bg46,bg56};
			
			 
			 public void tourDeJeux(boutonGrille[] b){
				
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
								JOptionPane.showMessageDialog(fenetre, "Felicitation Joueur 1, vous avez gagnÈ!");
								fenetre.dispose();	
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
								JOptionPane.showMessageDialog(fenetre, "Felicitation Joueur 2, vous avez gagnÈ!");
								fenetre.dispose();	
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
							JOptionPane.showMessageDialog(fenetre, "Felicitation vous avez gagnÈ!");
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
		 
//**********************************************Listener des boutons**************************************************				

		bColl1.addActionListener(new boutonPlacement());
		bColl2.addActionListener(new boutonPlacement());
		bColl3.addActionListener(new boutonPlacement());
		bColl4.addActionListener(new boutonPlacement());
		bColl5.addActionListener(new boutonPlacement());
		bColl6.addActionListener(new boutonPlacement());
		bColl7.addActionListener(new boutonPlacement());
		
		
		
		
		
		
	}

}
