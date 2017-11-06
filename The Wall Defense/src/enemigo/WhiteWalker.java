package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import main.GameObject;
import mapa.Celda;

/*
 * Clase WhiteWalker.
 * Clase que especifica las caracteristicas y comportamiento del enemigo whitewalker.
 */

public class WhiteWalker extends Enemigo{
	
	//Atributos locales.
	protected Enemigo enemigo;
	
	//Constructor.
	public WhiteWalker(Celda[] c,int prof) {
		super(c,prof);
		puntaje=100;
		velocidad=50;
		vida=3;
		daño = 1;
		graficos= new Icon[11];
		graficos[0]=new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando00.png"));
		graficos[1]=new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando01.png"));
		graficos[2]=new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando02.png"));
		graficos[3]=new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando03.png"));
		graficos[4]=new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando04.png"));
		graficos[5]=new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando05.png"));
		graficos[6]=new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando06.png"));
		graficos[7]=new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando07.png"));
		graficos[8]=new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando08.png"));
		graficos[9]=new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando09.png"));
		graficos[10]=new ImageIcon(this.getClass().getResource("/resources/static/ww_atacando/ww_atacando10.png"));
	}
	
	//Metodos heredados.
	public void atacar() {
	}

	public void mover() {		
		Celda siguiente;
		boolean detener=false;
		int xCelda= enemigo.getCeldas()[0].getPosX();
		int yCelda= enemigo.getCeldas()[0].getPosY();
		int xGrafico= enemigo.getGrafico().getX();
		int yGrafico= enemigo.getGrafico().getY();
		siguiente=enemigo.getCeldas()[0].getCelda(xCelda-1,yCelda);
		for(int i=0;i<7;i++) {
			GameObject objeto =siguiente.getObjects()[i];
			if (objeto!=null && !objeto.accept(enemigo.getVisitor())){
				detener=true;
			}
		}
		if(!detener && xCelda!=0) {
			enemigo.getGrafico().setBounds(xGrafico-64, yGrafico, 64, 64);
			enemigo.intercambiar_celdas(siguiente);
		}
	}
	
	public void setEnemigo(Enemigo enemigo){
		this.enemigo = enemigo;				
	}
	
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/static/ww_nightking_atacando/ww_nightking_atacando00.png"));
		graph=0;
		grafico.setIcon(imagen);
	}
	
	public void setGraficos(Icon[] graficos, JLabel grafico) {
		
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public Enemigo clone(Celda[] c) {
		//Profundidad 1 predeterminada. Retorna una unidad de mismo tipo.
		Enemigo clon = new WhiteWalker(c, 1);
		return clon;
	}
	
	public void playSound(){
		
	}
	
    public void destruir(){
    	super.destruir();
    	System.out.println("Destruir WhiteWalker");
	}
    
    public int getDaño(){
    	return daño;
    }
}