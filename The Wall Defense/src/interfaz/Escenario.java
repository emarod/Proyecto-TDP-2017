package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;
import mapa.Map;

public class Escenario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int width=20;
	private static final int height=12;
	public Escenario(){
		Random rnd=new Random();
		int r=rnd.nextInt(2);
		this.setLayout(new GridLayout(height,width));
		new Map(this,width,height,r);
		this.setBackground(new Color(255, 255, 255, 255));
	}

}
