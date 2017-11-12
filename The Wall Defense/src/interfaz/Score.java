package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Controladores.Director;

/*
 * Clase Score.
 * Clase encargada de desplegar el panel con el puntaje.
 */

public class Score extends JPanel {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected JLabel puntaje;
	protected Director director;

	// Constructor.
	public Score(Escenario stage) {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);
		director = director.newDirector();
		agregarLabel();

	}

	// Metodos locales.

	private void agregarLabel() {
		puntaje = new JLabel("Score 0000");
		// puntaje.setSize(puntaje.getWidth(), this.getHeight());
		// Recojo la fuente que se esta utilizando actualmente.
		Font auxFont = new Font("ArcadeClassic", Font.CENTER_BASELINE, 50);
		// Aplico la fuente actual, y al final le doy el tamaño del texto...
		puntaje.setForeground(Color.WHITE);
		puntaje.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 50));
		// puntaje.setSize(new Dimension(10,50));
		this.add(puntaje, BorderLayout.CENTER);
	}

	public void actualizar() {
		puntaje.setText("Score " + (director.getPartida().getScore()));
	}
}
