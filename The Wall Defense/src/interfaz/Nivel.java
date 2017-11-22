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

public class Nivel extends JPanel {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected JLabel level;
	protected Escenario escenario;
	protected int nroNivel;

	// Constructor.
	public Nivel() {
		nroNivel = 1;
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		agregarLabel();
		this.setBackground(Color.BLACK);
	}

	// Metodos locales.
	private void agregarLabel() {
		level = new JLabel("Level " + nroNivel);
		// level.setSize(level.getWidth(), this.getHeight());
		// Recojo la fuente que se esta utilizando actualmente.
		Font auxFont = new Font("ArcadeClassic", Font.CENTER_BASELINE, 50);
		// Aplico la fuente actual, y al final le doy el tamaño del texto...
		level.setForeground(Color.WHITE);
		level.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 50));
		this.add(level, BorderLayout.CENTER);
	}

	public void actualizar() {
		nroNivel++;
		level.setText("Level " + nroNivel);
	}

	public boolean ultimo() {
		return nroNivel == 3;
	}

	public int getNroNivel() {
		return nroNivel;
	}

}