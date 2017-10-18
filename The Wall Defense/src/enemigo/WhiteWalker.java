package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.GameObject;
import mapa.Celda;

public class WhiteWalker extends StateEnemigo{
	
	public WhiteWalker() {
		puntaje=100;
		velocidad_enemigo=10;
		resistencia=3;
	}

	@Override
	public void atacar() {
		
	}

	public void mover() {		
		Celda siguiente;
		int xCelda=this.enemigo.getCelda().getPosX();
		int yCelda=this.enemigo.getCelda().getPosY();
		int xGrafico= enemigo.getGrafico().getX();
		int yGrafico= enemigo.getGrafico().getY();
		siguiente=this.enemigo.getCelda().getCelda(xCelda-1,yCelda);
		for(int i=0;i<5 && mover;i++) {
			GameObject objeto =siguiente.getObjects()[i];					
			if (objeto!=null && !objeto.Accept(enemigo.getVisitor())){
				this.enemigo.getCelda().getDirector().desactivar(this.enemigo);
			}
		}
		if(xCelda!=0) {
			enemigo.getGrafico().setBounds(xGrafico-32, yGrafico, 32, 32);
			enemigo.intercambiar_celdas(siguiente);						
		}				
	}
	
    public void destruir(){
    	System.out.println("Destruir WhiteWalker");
    	this.enemigo.getCelda().getDirector().desactivar(this.enemigo);
	   
	}
	
	public void setEnemigo(Enemigo enemigo){
		this.enemigo = enemigo;				
	}
	
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/white_walker.gif"));
		grafico.setIcon(imagen);
	}
	
	public void setGraficos(Icon[] graficos, JLabel grafico) {
		// TODO Auto-generated method stub
		
	}
	
	public int getPuntaje() {
		return puntaje;
	}

}
