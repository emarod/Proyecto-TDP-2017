package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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
	protected JButton go;
	protected ImageIcon imagen;

	// Constructor.
	public GUI() {
		super("The Wall Defense");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 1245, 570);
		this.setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		// Escenario. Donde va el mapa.
		escenario = new Escenario();
		getContentPane().add(escenario, BorderLayout.CENTER);

		// Creo boton de inicio de horda.
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
				escenario.getMapa().nuevaHorda().ejecutar();
				escenario.getMapa().ejecutar();
				go.setVisible(false);
				escenario.getMenu().deshabilitarCompra();
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

		// Imagen de frame
		imagen = new ImageIcon(this.getClass().getResource("/resources/static/background/icon2.jpg"));
		this.setIconImage(imagen.getImage());

		// Panel Inferior
		panelInferior = new JPanel();
		panelInferior.setLayout(new BorderLayout());
		panelInferior.setPreferredSize(new Dimension(10, 90));
		panelInferior.setBackground(Color.BLACK);
		panelInferior.add(go, BorderLayout.EAST);
		getContentPane().add(panelInferior, BorderLayout.SOUTH);

		// Panel izquierdo
		panelIzquierdo = new JPanel();
		panelIzquierdo.setLayout(new BorderLayout());
		// Icon bannerLeft=new
		// ImageIcon(this.getClass().getResource("/resources/static/banner/Banner_4.jpg"));
		panelIzquierdo.setPreferredSize(new Dimension(150, 300));
		panelIzquierdo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelIzquierdo.setBackground(Color.BLACK);
		panelIzquierdo.add(escenario.getMenu());
		getContentPane().add(panelIzquierdo, BorderLayout.WEST);

		// Panel Derecho
		panelDerecho = new JPanel();
		panelDerecho.setLayout(new BorderLayout());
		panelDerecho.setPreferredSize(new Dimension(100, 300));
		panelDerecho.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDerecho.setBackground(Color.BLACK);
		panelDerecho.add(escenario.getMenuObjetos());
		getContentPane().add(panelDerecho, BorderLayout.EAST);

		// Panel Superior
		panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.BLACK);
		panelSuperior.setLayout(new BorderLayout());
		panelSuperior.setPreferredSize(new Dimension(10, 50));
		panelSuperior.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSuperior.add(escenario.getScore(), BorderLayout.EAST);
		panelSuperior.add(escenario.getDinero(), BorderLayout.WEST);
		panelSuperior.add(escenario.getLevel(), BorderLayout.CENTER);
		getContentPane().add(panelSuperior, BorderLayout.NORTH);

		this.pack();
	}

	public Escenario getEscenario() {
		return escenario;
	}
}
