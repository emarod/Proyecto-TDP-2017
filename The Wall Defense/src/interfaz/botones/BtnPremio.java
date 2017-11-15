package interfaz.botones;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;

import interfaz.Escenario;
import premios.Premio;

/*
 * Clase abstracta BtnObstaculo.
 * Clase que generaliza el comportamiento de un boton para el despliegue de un obstaculo.
 */

public abstract class BtnPremio extends JButton {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected Escenario stage;
	protected Premio precioso;
	protected Icon info;
	public int costo;

	// Constructor.
	public BtnPremio(Escenario e) {
		stage = e;
		this.setSize(32, 32);
		this.setBorderPainted(true);
		this.setContentAreaFilled(false);
		this.setOpaque(true);
		this.setBackground(Color.BLACK);

	}

	// Metodos abstractos.
	public abstract void create();

	public abstract void oyente();
}
