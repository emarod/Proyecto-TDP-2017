package interfaz.botones;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;

import interfaz.Escenario;
import jugador.Jugador;

/*
 * Clase abstracta BtnJugador.
 * Clase que generaliza el comportamiento de un boton para el despliegue de un jugador.
 */

public abstract class BtnJugador extends JButton {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected Escenario stage;
	protected Jugador player;
	protected Icon imagen;
	protected Icon info;
	public static int costo;

	// Constructor.
	public BtnJugador(Escenario e) {
		stage = e;
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

	// Metodos abstractos.
	public abstract void create();

	public abstract void oyente();

}