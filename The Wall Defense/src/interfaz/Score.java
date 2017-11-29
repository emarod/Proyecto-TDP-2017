package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

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
	public Score() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);
		agregarLabel();

	}

	// Metodos locales.

	private void agregarLabel() {
		puntaje = new JLabel("Score 0");

		String fName = "/resources/font/ARCADECLASSIC.TTF";
		InputStream is = this.getClass().getResourceAsStream(fName);
		Font font = new Font("fName", Font.CENTER_BASELINE, 50);
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, is);
			puntaje.setFont(font);
		}
		catch (FontFormatException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		// Recojo la fuente que se esta utilizando actualmente.
		Font auxFont = new Font("ArcadeClassic", Font.CENTER_BASELINE, 50);
		// Aplico la fuente actual, y al final le doy el tamaño del texto...
		puntaje.setForeground(Color.WHITE);
		puntaje.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 50));
		this.add(puntaje, BorderLayout.CENTER);
	}

	public void actualizar() {
		puntaje.setText("Score " + (Director.getPartida().getScore()));
	}
}
