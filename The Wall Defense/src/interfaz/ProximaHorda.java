package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import enemigo.Horda;

/*
 * Clase ProximaHorda.
 * Clase encargada de desplegar el panel con la descripcion de la proxima horda.
 */

public class ProximaHorda extends JPanel {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected JLabel puntaje;
	protected Escenario escenario;
	protected Horda horda;

	// Constructor.
	public ProximaHorda(Escenario esc) {
		this.setLayout(new BorderLayout());
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.escenario = esc;
		agregarLabel();
		this.setBackground(Color.BLACK);

	}

	// Metodos locales.
	private void agregarLabel() {
		puntaje = new JLabel("0000");
		puntaje.setSize(puntaje.getWidth(), this.getHeight());
		// Recojo la fuente que se esta utilizando actualmente.
		Font auxFont = new Font("Game of Thrones Regular", Font.CENTER_BASELINE, 50);
		// Aplico la fuente actual, y al final le doy el tamaño del texto...
		puntaje.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 50));
		this.add(puntaje, BorderLayout.CENTER);
	}

	public void setPuntaje(String str) {
		puntaje.setText(str);
	}
}
