package interfaz;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Controladores.Director;
import Controladores.RandomGenerator;
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
	int fondoNivel;

	// Constructor.
	public Escenario() {
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1026, 384));
		this.add(layeredPane);

		mapa = new Mapa();
		Director.setMapa(mapa);
		mapa.setEscenario(this);

		RandomGenerator r = Director.getRandom();
		fondoNivel = r.poll(2) + 1;

		mapa.inicializarCeldas(fondoNivel);
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

	public void agregarGrande(JLabel objeto, int entero) {
		objeto.setSize(128, 128);
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
		mapa.inicializarCeldas(fondoNivel);

	}

	public void crearPanel() {
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1026, 384));

		this.add(layeredPane);
	}

}