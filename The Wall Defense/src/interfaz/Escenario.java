package interfaz;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.border.Border;

import mapa.Map;

public class Escenario extends JPanel {
	private static final int width=20;
	private static final int height=12;
	private Map mapa;
	
	public Escenario(){
		mapa= new Map(width,height);
		this.setLayout(new GridLayout(width,height));		
	}

}
