package interfaz;

import java.awt.Dimension;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import mapa.Map;

public class Escenario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int width=20;
	private static final int height=12;
	private JLayeredPane layeredPane;
	private Map mapa;
	public Escenario(){
		Random rnd=new Random();
		int r=rnd.nextInt(2);		
		layeredPane= new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(640, 384));
		this.add(layeredPane);
		mapa= new Map(this,width,height,r);
//		this.setBackground(new Color(255, 0, 255, 255));
	}
	
	public void  agregar(JLabel objeto,Integer entero){
		objeto.setSize(32,32);
		layeredPane.add(objeto,entero);
	}
	
	public void crearPersonaje(String personaje) {
		mapa.crearPersonaje(personaje);
	}
	
	public Map getMapa() {
		return mapa;
	}
	
	public void hacerDaño(){
		mapa.hacerDaño();
	}
	

}
