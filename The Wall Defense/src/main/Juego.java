package main;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;

import Controladores.Director;
import interfaz.GUI;
import interfaz.MenuInicio;
import interfaz.Resultado;

/*
 * Clase Juego.
 * Esta clase posee el main.
 * Clase encargada de controlar el menu de inicio.
 */

public class Juego {

	// Atributos locales.
	protected static GUI frame;
	protected JFrame menu = new JFrame("The Wall Defense");
	protected MenuInicio opciones;
	protected Director director;
	protected Resultado resultado;

	// main
	public static void main(String[] args) {
		new Juego();

	}

	// Constructor.
	public Juego() {
		pantallaPrincipal();
	}

	// Metodos locales.
	public void pantallaPrincipal() {
		menu.setVisible(true);
		menu.setResizable(false);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setBounds(100, 100, 525, 410);
		menu.setLocationRelativeTo(null);
		JLayeredPane contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menu.setContentPane(contentPane);
		Icon background = new ImageIcon(this.getClass().getResource("/resources/static/background/background.png"));

		// Imagen de frame
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/static/background/icon2.jpg"));
		menu.setIconImage(imagen.getImage());

		// Carga de juego
		director = Director.newDirector();
		director.setGui(this);

		// Creo menu de inicio
		opciones = new MenuInicio(this);

		menu.setContentPane(new JLabel(background));
		menu.pack();
		menu.add(opciones, new Integer(2));

	}

	public void crearGUI(int d) {
		opciones.removeAll();
		opciones = null;
		menu.removeAll();
		menu.dispose();
		frame = new GUI(this, d);
		frame.setVisible(true);

	}

	public void terminarGUI(boolean result) {
		frame.removeAll();
		frame.dispose();

		menu = new JFrame("The Wall Defense");
		menu.setVisible(true);
		menu.setResizable(false);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setBounds(100, 100, 525, 410);
		menu.setLocationRelativeTo(null);
		JLayeredPane contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menu.setContentPane(contentPane);
		Icon background = new ImageIcon(this.getClass().getResource("/resources/static/background/background.png"));

		resultado = new Resultado(this, result);

		menu.setContentPane(new JLabel(background));
		menu.pack();
		menu.add(resultado, new Integer(2));

	}

}
