package IHM;

import javax.swing.JButton;

public class boutonGrille extends JButton {
	public boolean estColore;
	public int positionx;
	public int positiony;

	
	
	public boutonGrille(boolean b,int posX,int posY){
		this.estColore=b;
		this.positionx=posX;
		this.positiony=posY;
		
		
	}
	
	public int getPosx(){
		return this.positionx;
	}
	
	public int getPosY(){
		return this.positiony;
	}
	
	public boolean estColore(){
		return this.estColore;
	}

}
