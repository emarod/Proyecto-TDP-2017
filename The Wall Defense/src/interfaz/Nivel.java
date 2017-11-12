package interfaz;
/*
 * Clase Dinero.
 * Clase encargada de mostrar la cantidad de dinero.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Controladores.Director;

public class Nivel extends JPanel {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected JLabel level;
	protected Escenario escenario;

	// Constructor.
	public Nivel(Escenario esc) {
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.escenario = esc;
		agregarLabel();
		this.setBackground(Color.BLACK);
	}

	// Metodos locales.
	private void agregarLabel() {
		level = new JLabel("Level 1");
		// level.setSize(level.getWidth(), this.getHeight());
		// Recojo la fuente que se esta utilizando actualmente.
		Font auxFont = new Font("ArcadeClassic", Font.CENTER_BASELINE, 50);
		// Aplico la fuente actual, y al final le doy el tamaño del texto...
		level.setForeground(Color.WHITE);
		level.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 50));
		this.add(level, BorderLayout.CENTER);
	}

	public void actualizar(int i) {

		level.setText("Level " + Director.getPartida().getNivel());

	}

}