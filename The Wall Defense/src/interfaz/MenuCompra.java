package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controladores.Director;
import interfaz.botones.BtnArquero;
import interfaz.botones.BtnCaballero;
import interfaz.botones.BtnDragon;
import interfaz.botones.BtnEspadachin;
import interfaz.botones.BtnGigante;
import interfaz.botones.BtnLobo;
import mapa.Mapa;

/*
 * Clase MenuCompra.
 * Clase encargada de desplegar el menu de compra.
 */

public class MenuCompra extends JPanel {

	// Atributos locales.
	protected JLabel personaje;
	protected Mapa mapa;
	protected Escenario escenario;
	protected static final long serialVersionUID = 1L;
	protected JPanel botonera;
	protected Icon background;
	protected BtnDragon dragon;
	protected BtnArquero ygritte;
	protected BtnGigante gigante;
	protected BtnCaballero lannister;
	protected BtnEspadachin JonSnow;
	protected BtnLobo lobo;
	protected Director director;
	protected boolean enPartida = false;

	// Constructor.
	public MenuCompra() {
		this.setLayout(new GridLayout(3, 2));
		this.setBounds(76, 0, 381, 811);
		this.setBackground(Color.BLACK);
		armarBotonera();
	}

	// Metodos locales.
	private void armarBotonera() {

		gigante = new BtnGigante();
		gigante.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				boolean desplego;
				if (gigante.isEnabled()) {
					if (Director.getPartida().getDinero() >= gigante.getCosto()) {
						desplego = gigante.crearPersonaje();
						if (desplego) {
							Director.getPartida().quitarDinero(gigante.getCosto());
						}
					}
					if (Director.getPartida().getDinero() < gigante.getCosto()) {
						gigante.setEnabled(false);
					}
					Director.getGui().setDinero();

				}
			}

		});

		lobo = new BtnLobo();
		lobo.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				boolean desplego;
				if (lobo.isEnabled()) {
					if (Director.getPartida().getDinero() >= lobo.getCosto()) {
						desplego = lobo.crearPersonaje();
						if (desplego) {
							Director.getPartida().quitarDinero(lobo.getCosto());
						}
					}
					if (Director.getPartida().getDinero() < lobo.getCosto()) {
						lobo.setEnabled(false);
					}
					Director.getGui().setDinero();

				}
			}

		});

		dragon = new BtnDragon();

		dragon.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				boolean desplego;
				if (dragon.isEnabled()) {
					if (Director.getPartida().getDinero() >= dragon.getCosto()) {
						desplego = dragon.crearPersonaje();
						if (desplego) {
							Director.getPartida().quitarDinero(dragon.getCosto());
						}
					}
					if (Director.getPartida().getDinero() < dragon.getCosto()) {
						dragon.setEnabled(false);
					}
					Director.getGui().setDinero();

				}
			}

		});

		ygritte = new BtnArquero();
		ygritte.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				boolean desplego;
				if (ygritte.isEnabled()) {
					if (Director.getPartida().getDinero() >= ygritte.getCosto()) {
						desplego = ygritte.crearPersonaje();
						if (desplego) {
							Director.getPartida().quitarDinero(ygritte.getCosto());
						}
					}
					if (Director.getPartida().getDinero() < ygritte.getCosto()) {
						ygritte.setEnabled(false);
					}
					Director.getGui().setDinero();

				}
			}
		});

		lannister = new BtnCaballero();
		lannister.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				boolean desplego;
				if (lannister.isEnabled()) {
					if (Director.getPartida().getDinero() >= lannister.getCosto()) {
						desplego = lannister.crearPersonaje();
						if (desplego) {
							Director.getPartida().quitarDinero(lannister.getCosto());
						}
					}
					if (Director.getPartida().getDinero() < lannister.getCosto()) {
						lannister.setEnabled(false);
					}
					Director.getGui().setDinero();

				}
			}

		});

		JonSnow = new BtnEspadachin();
		JonSnow.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				boolean desplego;
				if (JonSnow.isEnabled()) {
					if (Director.getPartida().getDinero() >= JonSnow.getCosto()) {
						desplego = JonSnow.crearPersonaje();
						if (desplego) {
							Director.getPartida().quitarDinero(JonSnow.getCosto());
						}
					}
					if (Director.getPartida().getDinero() < JonSnow.getCosto()) {
						JonSnow.setEnabled(false);
					}
					Director.getGui().setDinero();
				}
			}
		});

		agregarBoton(ygritte);
		agregarBoton(dragon);
		agregarBoton(lannister);
		agregarBoton(JonSnow);
		agregarBoton(gigante);
		agregarBoton(lobo);

	}

	private void agregarBoton(JButton boton) {
		this.add(boton);
	}

	public void chequear() {

		if (Director.getPartida().getDinero() >= dragon.getCosto() && !enPartida) {
			dragon.habilitar();
		}
		else {
			dragon.deshabilitar();
		}

		if (Director.getPartida().getDinero() >= ygritte.getCosto() && !enPartida) {
			ygritte.habilitar();
		}
		else {
			ygritte.deshabilitar();
		}

		if (Director.getPartida().getDinero() >= JonSnow.getCosto() && !enPartida) {
			JonSnow.habilitar();
		}
		else {
			JonSnow.deshabilitar();
		}

		if (Director.getPartida().getDinero() >= lannister.getCosto() && !enPartida) {
			lannister.habilitar();
		}
		else {
			lannister.deshabilitar();
		}

		if (Director.getPartida().getDinero() >= lobo.getCosto() && !enPartida) {
			lobo.habilitar();
		}
		else {
			lobo.deshabilitar();
		}

		if (Director.getPartida().getDinero() >= gigante.getCosto() && !enPartida) {
			gigante.habilitar();
		}
		else {
			gigante.deshabilitar();
		}

	}

	public void deshabilitarCompra() {
		enPartida = true;

		ygritte.deshabilitar();
		dragon.deshabilitar();
		JonSnow.deshabilitar();
		gigante.deshabilitar();
		lobo.deshabilitar();
		lannister.deshabilitar();

	}

	public void habilitarCompra() {
		enPartida = false;

		ygritte.habilitar();
		dragon.habilitar();
		JonSnow.habilitar();
		gigante.habilitar();
		lobo.habilitar();
		lannister.habilitar();

	}

}
