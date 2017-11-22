package interfaz;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Controladores.Director;
import mapa.Mapa;

/*
 * Clase Escenario.
 * Clase encargada de la grafica que muestra el campo de juego.
 */

public class Escenario extends JPanel {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected JLayeredPane layeredPane;
	protected Mapa mapa;

	// Constructor.
	public Escenario() {
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1026, 384));
		this.add(layeredPane);

		mapa = new Mapa();
		Director.setMapa(mapa);
		mapa.setEscenario(this);

		mapa.inicializarCeldas();
	}

	// Metodos locales.
	public void agregar(JLabel objeto, int entero) {
		objeto.setSize(64, 64);
		layeredPane.add(objeto, new Integer(entero));
		repaint();
	}

	public void agregarLargo(JLabel objeto, int entero) {
		objeto.setSize(128, 64);
		layeredPane.add(objeto, new Integer(entero));
		repaint();
	}

	public Mapa getMapa() {
		return mapa;
	}

	public int getPosX() {
		return this.getX();
	}

	public int getPosY() {
		return this.getY();
	}

	public void eliminarPanel() {
		layeredPane.removeAll();

	}

	public void iniciarCeldas() {
		mapa.inicializarCeldas();

	}

	public void crearPanel() {
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1026, 384));

		this.add(layeredPane);
	}

}