package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;

public class WhiteWalker extends State{
	
	protected int puntosCelda = 32;
	protected int puntosVelocidad;
	
	public WhiteWalker() {
		velocidad_enemigo=10000;
		puntosVelocidad=velocidad_enemigo;
		resistencia=1;
	}
	public State lvlUp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}

	public void mover() {
		Celda siguiente;
		int xCelda=this.enemigo.getCelda().getPosX();
		int yCelda=this.enemigo.getCelda().getPosY();
		int xGrafico= enemigo.getGrafico().getX();
		int yGrafico= enemigo.getGrafico().getY();
		if(xCelda!=0) {
			puntosVelocidad--;
			if(puntosVelocidad==0) {
				puntosCelda--;				
				enemigo.getGrafico().setBounds(xGrafico-1, yGrafico, 32, 32);
				puntosVelocidad=velocidad_enemigo;
			}		
			if(puntosCelda==0) {
				siguiente=this.enemigo.getCelda().getCelda(xCelda-1,yCelda);
				enemigo.intercambiar_celdas(siguiente);
				puntosCelda=32;
			}
		}
		
	}
	
    public void destruir(){
    	enemigo.destruir();    	
    	this.enemigo.getCelda().getCM().desactivar(this.enemigo);
	   
	}
	
	public void setEnemigo(Enemigo enemigo){
		this.enemigo = enemigo;
		this.enemigo.getCelda().getCM().activar(this.enemigo);
	}
	
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/white_walker.gif"));
		grafico.setIcon(imagen);
	}
	
	@Override
	public void setGraficos(Icon[] graficos, JLabel grafico) {
		// TODO Auto-generated method stub
		
	}

}
