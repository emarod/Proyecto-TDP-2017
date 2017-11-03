package interfaz;

import java.awt.Dimension;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import mapa.Map;

/*
 * Clase Escenario.
 * Clase encargada de la grafica que muestra el campo de juego.
 */

public class Escenario extends JPanel {
	
	//Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected static final int width=16;
	protected static final int height=6;
	protected JLayeredPane layeredPane;
	protected Map mapa;
	protected ProximaHorda horda;
	
	//Constructor.
	public Escenario(){
		Random rnd=new Random();
		int r=rnd.nextInt(2);		
		layeredPane= new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1026, 384));
		
		this.add(layeredPane);
		mapa= new Map(this,width,height,r);
	}
	
	//Metodos locales.
	public void  agregar(JLabel objeto,int entero){
		objeto.setSize(64,64);
		layeredPane.add(objeto,new Integer(entero));
		repaint();
	}

	public void  agregarLargo(JLabel objeto,int entero){
		objeto.setSize(128,64);
		layeredPane.add(objeto,new Integer(entero));
		repaint();
	}
	
	public Map getMapa() {
		return mapa;
	}
	
	public void hacerDaño(){
		mapa.hacerDaño();
	}
	
	public void setHorda(ProximaHorda p) {
		horda=p;
	}

	public void setPuntaje(String p) {
		horda.setPuntaje(p);
		
	}
	
	public int getPosX() {
		return this.getX();
	}
	
	public int getPosY() {
		return this.getY();
	}

}