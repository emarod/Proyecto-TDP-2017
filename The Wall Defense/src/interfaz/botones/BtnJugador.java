package interfaz.botones;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;

import jugador.Jugador;

/*
 * Clase abstracta BtnJugador.
 * Clase que generaliza el comportamiento de un boton para el despliegue de un jugador.
 */

public abstract class BtnJugador extends JButton {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected Jugador player;
	protected Icon imagen;
	protected Icon info;
	protected int costo;
	protected boolean creo;

	// Constructor.
	public BtnJugador() {
		this.setSize(80, 79);
		this.setBorderPainted(true);
		this.setContentAreaFilled(false);
		this.setOpaque(true);
		this.setBackground(Color.BLACK);

	}

	// Metodo Implementado
	public Jugador getJugador() {
		return player;
	}

	public void habilitar() {
		this.setEnabled(true);

	}

	// Metodos abstractos.
	public abstract boolean create();

	public abstract void oyente();

	public int getCosto() {
		return costo;
	}

}