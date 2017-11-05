package interfaz;
 
 import javax.swing.border.LineBorder;

import interfaz.botones.BtnArquero;
import interfaz.botones.BtnDragon;
import interfaz.botones.BtnCaballero;
import interfaz.botones.BtnEspadachin;
import interfaz.botones.BtnBarricada;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		this.setLayout(new BorderLayout());
		this.setBounds(76, 0, 200, 300);
		this.setBackground(Color.RED);
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		armarPanel();
		armarBotonera();
	}
	
	//Metodos locales.
	private void armarBotonera() {
		
		BtnDragon dragon= new BtnDragon(this.escenario);
		dragon.setBounds(100, 200, dragon.getIcon().getIconWidth(), dragon.getIcon().getIconHeight());
		
		
		BtnArquero ygritte= new BtnArquero(this.escenario);
		ygritte.setBounds(50, 200, ygritte.getIcon().getIconWidth(), ygritte.getIcon().getIconHeight());
		
		
		BtnCaballero lannister = new BtnCaballero(this.escenario);
		lannister.setBounds(0, 15, lannister.getIcon().getIconWidth(), lannister.getIcon().getIconHeight());		
		
		BtnEspadachin JonSnow = new BtnEspadachin(this.escenario);
		JonSnow.setBounds(0, 50, JonSnow.getIcon().getIconWidth(), JonSnow.getIcon().getIconHeight());
		
		BtnBarricada barricada = new BtnBarricada(this.escenario);
		barricada.setBounds(0, 50, barricada.getIcon().getIconWidth(), barricada.getIcon().getIconHeight());
		
		JButton caminante = new JButton(new ImageIcon(this.getClass().getResource("/resources/dinamic/personajes/whitewalker_espadachin_atacando.gif")));
		caminante.setSize(32, 32);
		caminante.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						//escenario.getMapa().crearEnemigo(e, 4, 0);
					}
				}
		);
		this.add(caminante,BorderLayout.EAST);
		agregarBoton(ygritte);
		agregarBoton(dragon);
		agregarBoton(lannister);
		agregarBoton(JonSnow);
		agregarBoton(barricada);
		
	}
	
	public void agregarBoton(JButton boton) {
		botonera.add(boton);
	}
	
	public void armarPanel() {
		botonera=new JPanel();
		botonera.setLayout(new GridLayout());
		botonera.setBounds(76, 0, 300, 100);
		botonera.setBackground(Color.BLUE);
		background=new ImageIcon(this.getClass().getResource("/resources/static/tienda/fondo.png"));
		this.add(botonera, BorderLayout.WEST);
	}
}