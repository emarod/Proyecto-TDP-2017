package interfaz;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaz.botones.BtnBarricada;
import interfaz.botones.BtnBomba;
import mapa.Mapa;

/*
* Clase MenuPowerups.
* Clase encargada de desplegar el menu de power ups.
*/

public class MenuObjetos extends JPanel {

	// Atributos locales.
	protected JLabel personaje;
	protected Mapa mapa;
	protected Escenario escenario;
	protected static final long serialVersionUID = 1L;
	protected JPanel botonera;
	protected Icon background;

	// Constructor.
	public MenuObjetos(Escenario escenario) {
		this.escenario = escenario;
		this.setLayout(new FlowLayout());
		this.setBounds(76, 0, 300, 200);
		this.setBackground(Color.BLACK);
		armarBotonera();
	}

	// Metodos locales.
	private void armarBotonera() {

		BtnBarricada barricada = new BtnBarricada(this.escenario);
		BtnBomba bomba = new BtnBomba(this.escenario);

		agregarBoton(barricada);
		agregarBoton(bomba);

	}

	public void agregarBoton(JButton boton) {
		this.add(boton);
	}
}
