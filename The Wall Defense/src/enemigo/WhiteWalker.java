package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.GameObject;
import mapa.Celda;

public class WhiteWalker extends State{
	
	protected int puntosCelda = 32;
	protected int puntosVelocidad;	
	
	public WhiteWalker() {		
		mover=false;
		atacar=false;
		puntaje=100;
		velocidad_enemigo=700;
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
		siguiente=this.enemigo.getCelda().getCelda(xCelda-1,yCelda);
		for(int i=0;i<5 && mover;i++) {
			GameObject objeto =siguiente.getObjects()[i];					
			if (objeto!=null && !objeto.Accept(enemigo.getVisitor())){
				this.enemigo.getCelda().getCM().desactivar(this.enemigo);
				mover=false;
			}
		}
		if(xCelda!=0 && mover) {
			puntosVelocidad--;
			if(puntosVelocidad==0) {
				puntosCelda--;				
				enemigo.getGrafico().setBounds(xGrafico-1, yGrafico, 32, 32);
				puntosVelocidad=velocidad_enemigo;
			}		
			if(puntosCelda==0) {
				enemigo.intercambiar_celdas(siguiente);
				puntosCelda=32;				
			}
		}
//		System.out.println("celda--> ("+xCelda+","+yCelda+")");
//		System.out.println("graf--> ("+xGrafico+","+yGrafico+")");
		
	}
	
    public void destruir(){
    	this.enemigo.getCelda().getCM().desactivar(this.enemigo);
	   
	}
	
	public void setEnemigo(Enemigo enemigo){
		this.enemigo = enemigo;
		this.enemigo.getCelda().getCM().activar(this.enemigo);
		mover=true;
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
