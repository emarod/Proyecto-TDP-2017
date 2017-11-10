package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Controladores.Director;

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
	protected JPanel panelInferior;
	protected JPanel panelIzquierdo;
	protected JPanel panelDerecho;
	protected JPanel panelSuperior;
	protected JPanel grafica;

	// Constructor.
	public GUI(Director director) {
		super("The Wall Defense");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 1240, 550);
		this.setResizable(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		// Escenario. Donde va el mapa.
		escenario = new Escenario(director);
		getContentPane().add(escenario, BorderLayout.CENTER);

		// MenuCompra
		tienda = new MenuCompra(escenario);

		// Menu de proxima horda
		// horda= new ProximaHorda(escenario);
		// escenario.setHorda(horda);

		// Puntaje
		puntaje = new Score(escenario);

		// Panel Inferior
		panelInferior = new JPanel();
		panelInferior.setLayout(new BorderLayout());
		panelInferior.setPreferredSize(new Dimension(10, 79));
		getContentPane().add(panelInferior, BorderLayout.SOUTH);
		// panelInferior.add(horda, BorderLayout.EAST);
		panelInferior.add(tienda, BorderLayout.CENTER);

		// Panel izquierdo
		panelIzquierdo = new JPanel();
		panelIzquierdo.setLayout(new BorderLayout());
		Icon bannerLeft = new ImageIcon(this.getClass().getResource("/resources/static/banner/Banner_4.jpg"));
		panelIzquierdo.setBounds(0, 0, 400, 310);
		panelIzquierdo.setPreferredSize(new Dimension(100, 200));
		panelIzquierdo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelIzquierdo.setBackground(Color.BLACK);
		panelIzquierdo.add(new JLabel(bannerLeft), BorderLayout.CENTER);
		getContentPane().add(panelIzquierdo, BorderLayout.WEST);

		// Panel Derecho
		panelDerecho = new JPanel();
		panelDerecho.setLayout(new BorderLayout());
		Icon bannerRight = new ImageIcon(this.getClass().getResource("/resources/static/banner/Banner_2.jpg"));
		panelDerecho.setPreferredSize(new Dimension(100, 100));
		panelDerecho.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDerecho.setBackground(Color.BLACK);
		panelDerecho.add(new JLabel(bannerRight), BorderLayout.EAST);
		getContentPane().add(panelDerecho, BorderLayout.EAST);

		// Panel Superior
		panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.BLACK);
		panelSuperior.setLayout(new BorderLayout());
		panelSuperior.setPreferredSize(new Dimension(10, 50));
		panelSuperior.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSuperior.add(puntaje, BorderLayout.EAST);
		getContentPane().add(panelSuperior, BorderLayout.NORTH);
	}

	public Escenario getEscenario() {
		return escenario;
	}
}
