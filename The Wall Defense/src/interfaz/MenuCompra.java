package interfaz;

import java.awt.BorderLayout;
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

	protected JLabel iconoYgritte, iconoJon, iconoLannister, iconoDragon;

	// Constructor.
	public MenuCompra(Escenario escenario) {
		this.escenario = escenario;
		this.setLayout(new GridLayout(5, 1));
		this.setBounds(76, 0, 381, 811);
		this.setBackground(Color.BLACK);
		background = new ImageIcon(this.getClass().getResource("/resources/static/tienda/fondo.png"));
		armarBotonera();
	}

	// Metodos locales.
	private void armarBotonera() {

		dragon = new BtnDragon(this.escenario);

		dragon.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (Director.getPartida().getDinero() >= dragon.costo) {
					Director.getPartida().quitarDinero(dragon.costo);
					dragon.crearPersonaje();
				}
				if (Director.getPartida().getDinero() < dragon.costo) {
					dragon.setEnabled(false);
				}
				escenario.getDinero().actualizar();

			}

		});

		ygritte = new BtnArquero(this.escenario);
		ygritte.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (Director.getPartida().getDinero() >= ygritte.costo) {
					Director.getPartida().quitarDinero(ygritte.costo);
					ygritte.crearPersonaje();
				}
				if (Director.getPartida().getDinero() < ygritte.costo) {
					ygritte.setEnabled(false);
				}
				escenario.getDinero().actualizar();

			}

		});

		lannister = new BtnCaballero(this.escenario);
		lannister.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (Director.getPartida().getDinero() >= lannister.costo) {
					Director.getPartida().quitarDinero(lannister.costo);
					lannister.crearPersonaje();
				}
				if (Director.getPartida().getDinero() < lannister.costo) {
					lannister.setEnabled(false);
				}
				escenario.getDinero().actualizar();

			}

		});

		JonSnow = new BtnEspadachin(this.escenario);
		JonSnow.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (Director.getPartida().getDinero() >= JonSnow.costo) {
					Director.getPartida().quitarDinero(JonSnow.costo);
					JonSnow.crearPersonaje();
				}
				if (Director.getPartida().getDinero() < JonSnow.costo) {
					JonSnow.setEnabled(false);
				}
				escenario.getDinero().actualizar();
			}
		});

		agregarBoton(ygritte);
		agregarBoton(dragon);
		agregarBoton(lannister);
		agregarBoton(JonSnow);

	}

	private void agregarBoton(JButton boton) {
		this.add(boton);
	}

	public void chequear() {

		if (Director.getPartida().getDinero() < dragon.costo) {
			dragon.deshabilitar();
		}

		if (Director.getPartida().getDinero() < ygritte.costo) {
			ygritte.deshabilitar();
		}

		if (Director.getPartida().getDinero() < JonSnow.costo) {
			JonSnow.deshabilitar();
		}

		if (Director.getPartida().getDinero() < lannister.costo) {
			lannister.deshabilitar();
		}

	}

	public void deshabilitarCompra() {

		this.setLayout(new BorderLayout());

		ygritte.setVisible(false);
		dragon.setVisible(false);
		lannister.setVisible(false);
		JonSnow.setVisible(false);

		iconoYgritte = new JLabel(
				new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/ygritte.png")));
		iconoDragon = new JLabel(
				new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/dragon.png")));
		iconoLannister = new JLabel(
				new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/lannister.png")));
		iconoJon = new JLabel(
				new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/jonsnow.png")));
		/*
		 * iconoJon = new JLabel( new ImageIcon(this.getClass().getResource(
		 * "/resources/static/botones/personajes/jonsnow.png"))); iconoLannister = new
		 * JLabel( new ImageIcon(this.getClass().getResource(
		 * "/resources/static/botones/personajes/lannister.png"))); iconoDragon = new
		 * JLabel( new ImageIcon(this.getClass().getResource(
		 * "/resources/static/botones/personajes/dragon.png")));
		 *
		 * iconoYgritte.setBounds(0, 50, iconoYgritte.getIcon().getIconWidth(),
		 * iconoYgritte.getIcon().getIconHeight());
		 */

		iconoYgritte.setBounds(9, -1, iconoYgritte.getIcon().getIconWidth(), iconoYgritte.getIcon().getIconHeight());
		iconoDragon.setBounds(9, 78, iconoDragon.getIcon().getIconWidth(), iconoDragon.getIcon().getIconHeight());
		iconoLannister.setBounds(9, 280, iconoLannister.getIcon().getIconWidth(),
				iconoLannister.getIcon().getIconHeight());
		iconoJon.setBounds(-6, 221, iconoJon.getIcon().getIconWidth(), iconoJon.getIcon().getIconHeight());

		this.add(iconoYgritte);
		this.add(iconoDragon);
		this.add(iconoJon);
		this.add(iconoLannister);

	}

}
