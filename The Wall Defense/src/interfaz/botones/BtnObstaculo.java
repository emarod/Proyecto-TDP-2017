package interfaz.botones;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import interfaz.Escenario;
import obstaculos.Obstaculo;

/*
 * Clase abstracta BtnObstaculo.
 * Clase que generaliza el comportamiento de un boton para el despliegue de un obstaculo.
 */

public abstract class BtnObstaculo extends JButton {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected Escenario stage;
	protected Obstaculo obstaculo;

	// Constructor.
	public BtnObstaculo(Escenario e) {
		stage = e;
		this.setSize(32, 32);
		this.setBorderPainted(true);
		this.setContentAreaFilled(false);
		this.setOpaque(true);
		this.setBackground(Color.BLACK);

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				create();
			}
		});
	}

	// Metodos abstractos.
	public abstract void create();

}