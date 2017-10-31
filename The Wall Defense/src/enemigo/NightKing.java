package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.GameObject;
import mapa.Celda;

public class NightKing extends StateEnemigo {
	

	public NightKing() {
		puntaje=200;
		velocidad_enemigo=5;
		resistencia=6;
	}

	@Override
	public void atacar() {
		
	}

	public void mover() {		
		Celda siguiente;
		boolean detener=false;
		int xCelda=this.enemigo.getCelda().getPosX();
		int yCelda=this.enemigo.getCelda().getPosY();
		int xGrafico= enemigo.getGrafico().getX();
		int yGrafico= enemigo.getGrafico().getY();
		siguiente=this.enemigo.getCelda().getCelda(xCelda-1,yCelda);
		for(int i=0;i<7;i++) {
			GameObject objeto =siguiente.getObjects()[i];
			if (objeto!=null && !objeto.Accept(enemigo.getVisitor())){
//				this.enemigo.getCelda().getDirector().desactivar(this.enemigo);
				detener=true;
			}
		}
		if(!detener && xCelda!=0) {
			enemigo.getGrafico().setBounds(xGrafico-64, yGrafico, 64, 64);
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
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/personajes/whitewalker_nightking_atacando.gif"));
		grafico.setIcon(imagen);
	}
	
	public void setGraficos(Icon[] graficos, JLabel grafico) {
		// TODO Auto-generated method stub
		
	}
	
	public int getPuntaje() {
		return puntaje;
	}

}
