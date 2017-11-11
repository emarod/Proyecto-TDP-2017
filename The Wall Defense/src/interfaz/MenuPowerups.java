package interfaz;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaz.botones.BtnBarricada;
import mapa.Mapa;

/*
* Clase MenuPowerups.
* Clase encargada de desplegar el menu de power ups.
*/

public class MenuPowerups extends JPanel {

	// Atributos locales.
	protected JLabel personaje;
	protected Mapa mapa;
	protected Escenario escenario;
	protected static final long serialVersionUID = 1L;
	protected JPanel botonera;
	protected Icon background;

	// Constructor.
	public MenuPowerups(Escenario escenario) {
		this.escenario = escenario;
		this.setLayout(new FlowLayout());
		this.setBounds(76, 0, 300, 200);
		this.setBackground(Color.BLACK);
		armarBotonera();
	}

	// Metodos locales.
	private void armarBotonera() {

		BtnBarricada barricada = new BtnBarricada(this.escenario);
		BtnBarricada barricada2 = new BtnBarricada(this.escenario);

		agregarBoton(barricada);
		agregarBoton(barricada2);

	}

	public void agregarBoton(JButton boton) {
		this.add(boton);
	}
}