package IHM;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AffichagePanneauJoueur extends JPanel
{
	

	JPanel p1 =new JPanel();
	JPanel p2 =new JPanel();
 	JPanel p3 =new JPanel();
	
	public AffichagePanneauJoueur(String nomjoueur,String couleur){
		

		this.setLayout(new BorderLayout());
	
		 	p1.setPreferredSize(new Dimension(200,200));
		 	p1.setBackground(Color.GREEN);
		 
		 	p3.setPreferredSize(new Dimension(200,200));
		 	p3.setBackground(Color.magenta);
		 	p2.setPreferredSize(new Dimension(200,200));
		 	p2.setBackground(Color.blue);
		 	
			JLabel labelNomJoueur = new JLabel(nomjoueur);
			JLabel labelPion = new JLabel();
			
			if(couleur=="rouge"){
				labelPion.setIcon(new ImageIcon("pionRougeTest.png"));				
			}else{
				labelPion.setIcon(new ImageIcon("pionjauneTest.png"));		
			}
			
			//label.setPreferredSize(new Dimension(200, 200));
			labelNomJoueur.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			//labelPion.setAlignmentX(JLabel.BOTTOM_ALIGNMENT);
			labelPion.setAlignmentX(JLabel.CENTER);
			labelPion.setAlignmentY(JLabel.CENTER);
			
			p1.add(labelNomJoueur);
			//p1.add(labelPion);
			p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
			p3.add(Box.createVerticalStrut(55));
			p3.add(labelPion);
			p3.add(Box.createHorizontalStrut(65));

		 	
		
		 	this.add(p1, BorderLayout.NORTH);
		    this.add(p3, BorderLayout.CENTER);
		    this.add(p2, BorderLayout.SOUTH);
		        
	}
	
	
	public void transformPanel(){
		p1.setBackground(Color.GREEN.darker());
		p2.setBackground(Color.blue.darker());
		p3.setBackground(Color.magenta.darker());
		
	}

	public void remetPanel(){
		p1.setBackground(Color.GREEN);
		p2.setBackground(Color.blue);
		p3.setBackground(Color.magenta);
		
	}
	


}
