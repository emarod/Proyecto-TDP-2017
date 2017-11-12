package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controladores.Director;
import interfaz.botones.BtnArquero;
import interfaz.botones.BtnBarricada;
import interfaz.botones.BtnCaballero;
import interfaz.botones.BtnDragon;
import interfaz.botones.BtnEspadachin;
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
	protected BtnCaballero lannister;
	protected BtnEspadachin JonSnow;
	protected Director director;

	// Constructor.
	public MenuCompra(Escenario escenario) {
		this.escenario = escenario;
		this.setLayout(new GridLayout(5, 1));
		// this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.setBounds(76, 0, 381, 811);
		this.setBackground(Color.RED);
		background = new ImageIcon(this.getClass().getResource("/resources/static/tienda/fondo.png"));
		// this.add(new JLabel(background));
		// armarPanel();
		armarBotonera();
	}

	// Metodos locales.
	private void armarBotonera() {

		dragon = new BtnDragon(this.escenario);

		dragon.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				director.getPartida().quitarDinero(dragon.getJugador().getCosto());
				if (director.getPartida().getDinero() < dragon.getJugador().getCosto()) {
					dragon.setEnabled(false);
				}
				chequear();
				escenario.getDinero().actualizar();

			}

		});

		ygritte = new BtnArquero(this.escenario);
		ygritte.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				director.getPartida().quitarDinero(ygritte.getJugador().getCosto());
				if (director.getPartida().getDinero() < ygritte.getJugador().getCosto()) {
					ygritte.setEnabled(false);
				}
				chequear();
				escenario.getDinero().actualizar();

			}

		});

		lannister = new BtnCaballero(this.escenario);
		lannister.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				director.getPartida().quitarDinero(lannister.getJugador().getCosto());
				if (director.getPartida().getDinero() < lannister.getJugador().getCosto()) {
					lannister.setEnabled(false);
				}
				chequear();
				escenario.getDinero().actualizar();

			}

		});

		JonSnow = new BtnEspadachin(this.escenario);
		JonSnow.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				director.getPartida().quitarDinero(JonSnow.getJugador().getCosto());
				if (director.getPartida().getDinero() < JonSnow.getJugador().getCosto()) {
					JonSnow.setEnabled(false);
				}
				chequear();
				escenario.getDinero().actualizar();
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
		if (director.getPartida().getDinero() < 75) {
			dragon.setEnabled(false);
		}

		if (director.getPartida().getDinero() < 50) {
			ygritte.setEnabled(false);
		}

		if (director.getPartida().getDinero() < 30) {
			JonSnow.setEnabled(false);
		}

		if (director.getPartida().getDinero() < 25) {
			lannister.setEnabled(false);
		}

	}

}