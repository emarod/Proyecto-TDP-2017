package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Controladores.Director;
import main.CONFIG;
import main.GameObject;
import main.Juego;
//import mapa.Celda;

/*
 * Clase GUI.
 * Clase  encargada de la interfaz grafica general.
 */

public class GUI extends JFrame {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected Escenario escenario;
	protected MenuCompra tienda;
	protected ProximaHorda horda;
	protected Score puntaje;
	protected MenuObjetos objetos;
	protected JPanel panelInferior;
	protected JPanel panelIzquierdo;
	protected JPanel panelDerecho;
	protected JPanel panelSuperior;
	protected JPanel grafica;
	protected ImageIcon imagen;
	protected MenuCompra menucompra;
	protected Dinero dinero;
	protected Score score;
	protected MenuObjetos menuObjetos;
	protected Nivel level;
	protected Acumulados acumulados;
	protected JButton go;
	protected JButton sell;
	protected int money;
	protected Juego game;
	protected int dificultad;
	protected JLabel inst;
	protected JButton close, next, back;
	protected JPanel panelCentro;
	protected int cont = 0;

	// Constructor.
	public GUI(Juego g, int dificultad) {
		super("The Wall Defense");
		this.dificultad = dificultad * 5;
		System.out.println(this.dificultad);
		game = g;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 1245, 570);
		this.setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		Director.setGui(this);

		// Escenario. Donde va el mapa.
		escenario = new Escenario();

		inst = new JLabel(new ImageIcon(this.getClass().getResource("/resources/static/background/PanelAlpha.png")));

		// cerrar panel instrucciones
		close = new JButton();
		close.setToolTipText("cerrar");
		close.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/close.png")));
		close.setBackground(Color.BLACK);
		close.setBorderPainted(false);
		close.setBorder(new LineBorder(Color.BLACK));
		close.setFocusPainted(false);
		close.setOpaque(false);
		close.setContentAreaFilled(false);
		close.setBounds(495, 310, close.getIcon().getIconWidth(), close.getIcon().getIconHeight());

		// boton de siguiente instruccciones
		next = new JButton();
		next.setToolTipText("siguiente");
		next.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/next1.png")));
		next.setBackground(Color.BLACK);
		next.setBorderPainted(false);
		next.setBorder(new LineBorder(Color.BLACK));
		next.setFocusPainted(false);
		next.setOpaque(false);
		next.setContentAreaFilled(false);
		next.setBounds(553, 305, next.getIcon().getIconWidth(), next.getIcon().getIconHeight());

		// boton de anterior instruccciones
		back = new JButton();
		back.setToolTipText("anterior");
		back.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/back.png")));
		back.setBackground(Color.BLACK);
		back.setBorderPainted(false);
		back.setBorder(new LineBorder(Color.BLACK));
		back.setFocusPainted(false);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBounds(435, 305, next.getIcon().getIconWidth(), next.getIcon().getIconHeight());
		back.setVisible(false);

		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				panelCentro.setVisible(false);
				getContentPane().remove(inst);
				getContentPane().remove(close);
				getContentPane().remove(panelCentro);
				getContentPane().add(escenario, BorderLayout.CENTER);
				panelInferior.add(armarGo(), BorderLayout.WEST);
				panelInferior.add(armarSell(), BorderLayout.EAST);
				menuObjetos.setActivado(true);

			}

		});

		next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (cont == 0) {
					// getContentPane().remove(panelCentro);
					// panelCentro.remove(inst1);
					inst.setIcon(
							new ImageIcon(this.getClass().getResource("/resources/static/background/PanelAlpha2.png")));
					cont = cont + 1;
					back.setVisible(true);
					next.setVisible(true);
					System.out.println(cont);

				}

				else {
					if (cont == 1) {
						inst.setIcon(new ImageIcon(
								this.getClass().getResource("/resources/static/background/PanelAlpha3.png")));
						cont = cont + 1;
						back.setVisible(true);
						next.setVisible(false);
						System.out.println(cont);
					}

					else {
						if (cont == 2) {
							next.setVisible(false);
							System.out.println(cont);
						}
					}
				}

			}

		});

		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (cont == 1) {
					// getContentPane().remove(panelCentro);
					// panelCentro.remove(inst1);
					inst.setIcon(
							new ImageIcon(this.getClass().getResource("/resources/static/background/PanelAlpha.png")));
					cont = cont - 1;
					back.setVisible(false);
					next.setVisible(true);
					System.out.println(cont);

				}

				else {
					if (cont == 2) {
						inst.setIcon(new ImageIcon(
								this.getClass().getResource("/resources/static/background/PanelAlpha2.png")));
						cont = cont - 1;
						back.setVisible(true);
						next.setVisible(true);
						System.out.println(cont);

					}
				}

			}

		});

		// Armar resto de la interfaz
		acumulados = new Acumulados();
		menucompra = new MenuCompra();
		menuObjetos = new MenuObjetos();
		score = new Score();
		level = new Nivel();
		dinero = new Dinero();

		menuObjetos.setActivado(false);

		// Imagen de frame
		imagen = new ImageIcon(this.getClass().getResource("/resources/static/background/icon2.jpg"));
		this.setIconImage(imagen.getImage());

		// Panel centro
		panelCentro = new JPanel();
		panelCentro.setLayout(new BorderLayout());
		panelCentro.setPreferredSize(new Dimension(1026, 390));
		panelCentro.setBackground(Color.BLACK);
		panelCentro.add(close);
		panelCentro.add(next);
		panelCentro.add(back);
		panelCentro.add(inst, BorderLayout.CENTER);
		getContentPane().add(panelCentro, BorderLayout.CENTER);

		// Panel Inferior
		panelInferior = new JPanel();
		panelInferior.setLayout(new BorderLayout());
		panelInferior.setPreferredSize(new Dimension(10, 90));
		panelInferior.setBackground(Color.BLACK);
		panelInferior.add(acumulados, BorderLayout.CENTER);
		getContentPane().add(panelInferior, BorderLayout.SOUTH);

		// Panel izquierdo
		panelIzquierdo = new JPanel();
		panelIzquierdo.setLayout(new BorderLayout());
		// Icon bannerLeft=new
		// ImageIcon(this.getClass().getResource("/resources/static/banner/Banner_4.jpg"));
		panelIzquierdo.setPreferredSize(new Dimension(150, 300));
		panelIzquierdo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelIzquierdo.setBackground(Color.BLACK);
		panelIzquierdo.add(menucompra);
		getContentPane().add(panelIzquierdo, BorderLayout.WEST);

		// Panel Derecho
		panelDerecho = new JPanel();
		panelDerecho.setLayout(new BorderLayout());
		panelDerecho.setPreferredSize(new Dimension(100, 300));
		panelDerecho.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDerecho.setBackground(Color.BLACK);
		panelDerecho.add(menuObjetos);
		getContentPane().add(panelDerecho, BorderLayout.EAST);

		// Panel Superior
		panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.BLACK);
		panelSuperior.setLayout(new BorderLayout());
		panelSuperior.setPreferredSize(new Dimension(10, 50));
		panelSuperior.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSuperior.add(score, BorderLayout.EAST);
		panelSuperior.add(dinero, BorderLayout.WEST);
		panelSuperior.add(level, BorderLayout.CENTER);
		getContentPane().add(panelSuperior, BorderLayout.NORTH);

		this.pack();
	}

	public Escenario getEscenario() {
		return escenario;
	}

	public void resetEscenario() {
		escenario = new Escenario();
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
				Director.getMapa().nuevaHorda(dificultad).ejecutar();
				Director.getMapa().ejecutar();
				go.setVisible(false);
				sell.setVisible(true);
				menucompra.deshabilitarCompra();
				menuObjetos.deshabilitarCompra();
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
				if (celdaLabel != null) {
					int x_jugador = Math.round(celdaLabel.getX() / 64);
					int y_jugador = Math.round(celdaLabel.getY() / 64);
					if (x_jugador > 0) {
						// si es un jugador
						GameObject jugador = Director.getCelda(x_jugador, y_jugador)
								.getObjects()[CONFIG.PROFUNDIDAD_JUGADOR];
						if (jugador != null) {
							jugador.destruir();
							Director.getPartida().añadirDinero(25);
							dinero.actualizar();
						}
						// si posee un efecto.
						/*
						 * GameObject efecto = Director.getCelda(x_jugador,
						 * y_jugador).getObjects()[CONFIG.PROFUNDIDAD_EFECTO]; if (efecto != null) {
						 * efecto.destruir(); }
						 */
						GameObject efecto = Director.getCelda(x_jugador, y_jugador)
								.getObjects()[CONFIG.PROFUNDIDAD_EFECTO];
						if (efecto != null) {
							efecto.destruir();
						}
					}
				}
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

	public void setPuntaje(String p) {
		score.actualizar();

	}

	public void setDinero() {
		dinero.actualizar();

	}

	public void nextLevel() {
		if (level.ultimo()) {
			Director.getGui().getGame().terminarGUI(true);
		}
		else {
			go.setVisible(true);
			sell.setVisible(false);
			getMenu().habilitarCompra();
			getMenuObjetos().habilitarCompra();
			// escenario.eliminarPanel();
			level.actualizar();
			// removeAll();
			/*
			 * escenario = new Escenario(); escenario.crearPanel();
			 * escenario.iniciarCeldas();
			 */
		}

	}

	public Juego getGame() {
		return game;
	}

	/*
	 * @Override public void removeAll() { Celda c = null; for (int x = 0; x < 16;
	 * x++) { for (int y = 0; y < 6; y++) { c = Director.getMapa().getCelda(x, y);
	 * if (c.getObjects() != null) { for (int i = 0; i < c.getObjects().length; i++)
	 * { c.getObjects()[i].destruir(); } } } } }
	 */
}
