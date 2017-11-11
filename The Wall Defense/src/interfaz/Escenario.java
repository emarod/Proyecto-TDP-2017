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
	protected ProximaHorda horda;
<<<<<<< HEAD

	// Constructor.
	public Escenario(Director director) {
		layeredPane = new JLayeredPane();
=======
	protected MenuCompra menucompra;
	protected Dinero dinero;
	protected Score score;
	protected MenuPowerups powerups;
	protected Nivel level;
	
	//Constructor.
	public Escenario(){
		Random rnd=new Random();
		int r=rnd.nextInt(2);		
		layeredPane= new JLayeredPane();
>>>>>>> master
		layeredPane.setPreferredSize(new Dimension(1026, 384));

		this.add(layeredPane);
<<<<<<< HEAD
		mapa = Director.getMapa();
		mapa.setEscenario(this);
		mapa.inicializarCeldas();
=======
		mapa= new Map(this,width,height,r);
		menucompra=new MenuCompra(this);
		dinero=new Dinero(this);
		score=new Score(this);
		powerups=new MenuPowerups(this);
		level=new Nivel(this);
>>>>>>> master
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
<<<<<<< HEAD

=======
	
	public MenuCompra getMenu() {
		return menucompra;
	}
	
	public Dinero getDinero() {
		return dinero;
	}
	
	public Score getScore() {
		return score;
	}
	
	public Nivel getLevel() {
		return level;
	}
	
>>>>>>> master
	public void setHorda(ProximaHorda p) {
		horda = p;
	}

	public void setPuntaje(String p) {
		horda.setPuntaje(p);

	}
<<<<<<< HEAD

=======
	
	public boolean terminoHorda(){
		return horda.terminoHorda();
	}
	
	public void reiniciarHorda(){
		horda.reiniciarHorda();
	}
	
	public void actualizarEnemigos(){
		horda.actualizarEnemigos();
	}
	
>>>>>>> master
	public int getPosX() {
		return this.getX();
	}

	public int getPosY() {
		return this.getY();
	}
}