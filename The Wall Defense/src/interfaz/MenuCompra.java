package interfaz;
 
 import javax.swing.border.LineBorder;

import interfaz.botones.BtnArquero;
import interfaz.botones.BtnCaballero;
import interfaz.botones.BtnEspadachin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import mapa.Map;

public class MenuCompra extends JPanel{
	protected JLabel personaje;
	protected Map mapa;
	protected Escenario escenario;
	protected static final long serialVersionUID = 1L;
	protected JPanel botonera;
	protected Icon background;
 	
	public MenuCompra(Escenario escenario) {
		this.escenario= escenario;
		this.setLayout(null);
		this.setBounds(76, 0, 100, 100);
		this.setBackground(Color.RED);
		this.setBorder(new LineBorder(new Color(0, 0, 0)));	
		armarPanel();
		armarBotonera();
	}
	
	private void armarBotonera() {
		
	
		
		
		BtnArquero ygritte= new BtnArquero(this.escenario);
		ygritte.setBounds(0, 15, 15, 15);
		botonera.add(ygritte);
		
		
		BtnCaballero lannister = new BtnCaballero(this.escenario);
		lannister.setBounds(0, 35, 32, 32);
		//botonera.add(lannister);
		
		BtnEspadachin JonSnow = new BtnEspadachin(this.escenario);
		JonSnow.setBounds(0, 50, 32, 32);
		//this.add(JonSnow);
		
		/*JButton caminante = new JButton(new ImageIcon(this.getClass().getResource("/resources/dinamic/white_walker.gif")));
		caminante.setSize(32, 32);
		caminante.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						escenario.crearPersonaje("caminante");
					}
				}
		);
		this.add(caminante);*/
		
		
		
		
		
	}
	
	public void armarPanel() {
		
		botonera=new JPanel();
		botonera.setLayout(new BorderLayout());
		botonera.setBounds(0,0,400,100);
		botonera.setBackground(Color.BLUE);
		background=new ImageIcon(this.getClass().getResource("/resources/static/tienda/fondo.png"));
		//botonera.add(new JLabel(background));
		this.add(botonera,BorderLayout.WEST);
		
	}
		

	
}