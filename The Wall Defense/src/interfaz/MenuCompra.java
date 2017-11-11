package interfaz;
 

import interfaz.botones.BtnArquero;
import interfaz.botones.BtnDragon;
import interfaz.botones.BtnCaballero;
import interfaz.botones.BtnEspadachin;
import interfaz.botones.BtnBarricada;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import mapa.Mapa;

/*
 * Clase MenuCompra.
 * Clase encargada de desplegar el menu de compra.
 */

public class MenuCompra extends JPanel{
	
	//Atributos locales.
	protected JLabel personaje;
	protected Mapa mapa;
	protected Escenario escenario;
	protected static final long serialVersionUID = 1L;
	protected JPanel botonera;
	protected Icon background;
	protected BtnDragon dragon;
	protected BtnArquero ygritte;
	protected BtnCaballero lannister;
	protected BtnEspadachin JonSnow;
 	
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
		
		dragon= new BtnDragon(this.escenario);
		
			dragon.addMouseListener(
					new MouseAdapter() {


						public  void mouseReleased(MouseEvent evento) {
							escenario.getDinero().setMontoCompra(dragon.getJugador().getState().getCosto());
							if (escenario.getDinero().getTotal()<dragon.getJugador().getState().getCosto()) {
								dragon.setEnabled(false);
							}
							chequear();
						}

					});
		
		
		ygritte= new BtnArquero(this.escenario);
		ygritte.addMouseListener(
				new MouseAdapter() {


					public  void mouseReleased(MouseEvent evento) {
						escenario.getDinero().setMontoCompra(ygritte.getJugador().getState().getCosto());
						if (escenario.getDinero().getTotal()<ygritte.getJugador().getState().getCosto()) {
							ygritte.setEnabled(false);
						}
						chequear();

					}

				});
		
		
		lannister = new BtnCaballero(this.escenario);
		lannister.addMouseListener(
				new MouseAdapter() {


					public  void mouseReleased(MouseEvent evento) {
						escenario.getDinero().setMontoCompra(lannister.getJugador().getState().getCosto());
						if (escenario.getDinero().getTotal()<lannister.getJugador().getState().getCosto()) {
							lannister.setEnabled(false);
						}
						chequear();
					}

				});
		
		JonSnow = new BtnEspadachin(this.escenario);
		JonSnow.addMouseListener(
				new MouseAdapter() {


					public  void mouseReleased(MouseEvent evento) {
						escenario.getDinero().setMontoCompra(JonSnow.getJugador().getState().getCosto());
						if (escenario.getDinero().getTotal()<JonSnow.getJugador().getState().getCosto()) {
							JonSnow.setEnabled(false);
						}
						chequear();
					}

				});
		
		
		BtnBarricada barricada = new BtnBarricada(this.escenario);
		barricada.setBounds(0, 50, barricada.getIcon().getIconWidth(), barricada.getIcon().getIconHeight());
		
		agregarBoton(ygritte);
		agregarBoton(dragon);
		agregarBoton(lannister);
		agregarBoton(JonSnow);

		
	}
	
	private void agregarBoton(JButton boton) {
		this.add(boton);
	}
	
	private void chequear() {
		if(escenario.getDinero().getTotal()<75) {
			dragon.setEnabled(false);
		}
		
		if(escenario.getDinero().getTotal()<50) {
			ygritte.setEnabled(false);
		}
		
		if(escenario.getDinero().getTotal()<30) {
			JonSnow.setEnabled(false);
		}
		
		if(escenario.getDinero().getTotal()<25) {
			lannister.setEnabled(false);
		}
		
	}

}