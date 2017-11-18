package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Controladores.Director;
import main.CONFIG;
import main.GameObject;
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
	protected MenuCompra menucompra;
	protected Dinero dinero;
	protected Score score;
	protected MenuObjetos menuObjetos;
	protected Nivel level;
	protected Acumulados acumulados;
	protected JButton go;
	protected JButton sell;

	// Constructor.
	public Escenario() {

		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1026, 384));

		this.add(layeredPane);

		menucompra = new MenuCompra(this);
		score = new Score(this);
		menuObjetos = new MenuObjetos(this);
		level = new Nivel(this);
		dinero = new Dinero(this);
		acumulados = new Acumulados(this);

		mapa = Director.getMapa();
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

	public void setPuntaje(String p) {
		score.actualizar();

	}

	public int getPosX() {
		return this.getX();
	}

	public int getPosY() {
		return this.getY();
	}

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

	public MenuObjetos getMenuObjetos() {
		return menuObjetos;
	}

	public Acumulados getAcumulados() {
		return acumulados;
	}

	public void nextLevel() {
		layeredPane.removeAll();
		mapa.inicializarCeldas();
		armarGo();
		armarSell();
	}

	// Creo boton de inicio de horda y mapa.
	public JButton armarGo() {
		go = new JButton();
		go.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/go.png")));
		go.setSize(go.getIcon().getIconWidth(), go.getIcon().getIconHeight());
		go.setBackground(Color.BLACK);
		go.setBorderPainted(false);
		go.setBorder(new LineBorder(Color.BLACK));
		go.setFocusPainted(false);
		go.setContentAreaFilled(false);

		go.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				go.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/go.png")));
				getMapa().nuevaHorda().ejecutar();
				getMapa().ejecutar();
				go.setVisible(false);
				sell.setVisible(true);
				getMenu().deshabilitarCompra();
				getMenuObjetos().deshabilitarCompra();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				go.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/gopressed.png")));
			}

			@Override
			public void mouseEntered(MouseEvent evento) {

			}

			@Override
			public void mouseExited(MouseEvent evento) {

			}

		});
		return go;
	}

	// Crea boton de vender personajes
	public JButton armarSell() {
		sell = new JButton();
		sell.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/sell.png")));
		sell.setSize(sell.getIcon().getIconWidth(), sell.getIcon().getIconHeight());
		sell.setBackground(Color.BLACK);
		sell.setBorderPainted(false);
		sell.setBorder(new LineBorder(Color.BLACK));
		sell.setFocusPainted(false);
		sell.setContentAreaFilled(false);
		sell.setVisible(false);

		sell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				sell.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/sell.png")));
				JLabel celdaLabel = Director.getMapa().getCeldaLabel();
				int x_jugador = Math.round(celdaLabel.getX() / 64);
				int y_jugador = Math.round(celdaLabel.getY() / 64);
				GameObject jugador = Director.getCelda(x_jugador, y_jugador).getObjects()[CONFIG.PROFUNDIDAD_JUGADOR];
				if (jugador != null) {
					jugador.destruir();
				}
				// Director.getPartida().añadirDinero();
				getDinero().actualizar();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				sell.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/sellpressed.png")));
			}

			@Override
			public void mouseEntered(MouseEvent evento) {

			}

			@Override
			public void mouseExited(MouseEvent evento) {

			}

		});

		return sell;
	}
}