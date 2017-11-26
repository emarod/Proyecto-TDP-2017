package interfaz.botones;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;

import objetos.Premio;

/*
 * Clase abstracta BtnObstaculo.
 * Clase que generaliza el comportamiento de un boton para el despliegue de un obstaculo.
 */

public abstract class BtnPremio extends JButton {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected Premio precioso;
	protected Icon info;
	public int costo;

	// Constructor.
	public BtnPremio() {
		this.setSize(32, 32);
		this.setBorderPainted(true);
		this.setContentAreaFilled(false);
		this.setOpaque(true);
		this.setBackground(Color.BLACK);

	}

	// Metodos abstractos.
	public abstract boolean create();

	public abstract void oyente();
}
