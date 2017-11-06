package interfaz;
 

import interfaz.botones.BtnArquero;
import interfaz.botones.BtnDragon;
import interfaz.botones.BtnCaballero;
import interfaz.botones.BtnEspadachin;
import interfaz.botones.BtnBarricada;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import mapa.Map;

/*
 * Clase MenuCompra.
 * Clase encargada de desplegar el menu de compra.
 */

public class MenuCompra extends JPanel{
	
	//Atributos locales.
	protected JLabel personaje;
	protected Map mapa;
	protected Escenario escenario;
	protected static final long serialVersionUID = 1L;
	protected JPanel botonera;
	protected Icon background;
 	
	//Constructor.
	public MenuCompra(Escenario escenario) {
		this.escenario= escenario;
		this.setLayout(new GridLayout(5,1));
		//this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.setBounds(76, 0, 381, 811);
		this.setBackground(Color.RED);
		background=new ImageIcon(this.getClass().getResource("/resources/static/tienda/fondo.png"));
		//this.add(new JLabel(background));
		//armarPanel();
		armarBotonera();
	}
	
	//Metodos locales.
	private void armarBotonera() {
		
		BtnDragon dragon= new BtnDragon(this.escenario);
		
		
		BtnArquero ygritte= new BtnArquero(this.escenario);
		
		
		BtnCaballero lannister = new BtnCaballero(this.escenario);
		
		BtnEspadachin JonSnow = new BtnEspadachin(this.escenario);
		
		BtnBarricada barricada = new BtnBarricada(this.escenario);
		barricada.setBounds(0, 50, barricada.getIcon().getIconWidth(), barricada.getIcon().getIconHeight());
		
		agregarBoton(ygritte);
		agregarBoton(dragon);
		agregarBoton(lannister);
		agregarBoton(JonSnow);

		
	}
	
	public void agregarBoton(JButton boton) {
		this.add(boton);
	}

}