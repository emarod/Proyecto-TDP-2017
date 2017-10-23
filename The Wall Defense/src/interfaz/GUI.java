package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class GUI extends JFrame{
	
	protected static final long serialVersionUID = 1L;
	
	protected Escenario escenario;
	protected MenuCompra tienda;
	protected ProximaHorda horda;
	protected JPanel panelInferior;
	protected JPanel panelIzquierdo;
	protected JPanel panelDerecho;
	protected JPanel panelSuperior;
	protected JPanel grafica;

	public GUI() {	
		super("The Wall Defense");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 650, 400);
		this.setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		//((JComponent) getContentPane()).setBorder(new LineBorder(new Color(0, 0, 0)));
		//getContentPane().setBounds(, y, width, height);
		
		//Escenario. Donde va el mapa
		escenario= new Escenario();	
		getContentPane().add(escenario, BorderLayout.CENTER);
		
		//MenuCompra
		tienda= new MenuCompra(escenario);
		
		//Menu de proxima horda
		horda= new ProximaHorda(escenario);
		escenario.setHorda(horda);

		//Panel Inferior
		panelInferior= new JPanel();
		panelInferior.setLayout(new BorderLayout());
		panelInferior.setPreferredSize(new Dimension(10, 100));
		getContentPane().add(panelInferior, BorderLayout.SOUTH);
		panelInferior.add(horda, BorderLayout.CENTER);
		panelInferior.add(tienda,BorderLayout.WEST);
		
		//Panel izquierdo
		panelIzquierdo= new JPanel();
		panelIzquierdo.setLayout(new BorderLayout());
		Icon bannerLeft=new ImageIcon(this.getClass().getResource("/resources/static/banner/bannerleft.jpg"));
		panelIzquierdo.setBounds(0, 0, 100, 300);
		panelIzquierdo.setPreferredSize(new Dimension(10, 100));
		panelIzquierdo.setBorder(new LineBorder(new Color(0, 0, 0)));
		//panelIzquierdo.add(new JLabel(bannerLeft), BorderLayout.WEST);
		getContentPane().add(panelIzquierdo);
		
		//Panel Derecho
		panelDerecho= new JPanel();
		panelDerecho.setLayout(new BorderLayout());
		Icon bannerRight=new ImageIcon(this.getClass().getResource("/resources/static/banner/bannerright.jpg"));
		//panelDerecho.add(new JLabel(bannerRight), BorderLayout.EAST);
		getContentPane().add(panelDerecho, BorderLayout.EAST);
		
		//Panel Superior
		panelSuperior= new JPanel();
		panelSuperior.setLayout(new BorderLayout());
		panelSuperior.setPreferredSize(new Dimension(10, 25));
		panelSuperior.setBorder(new LineBorder(new Color(0, 0, 0)));
		//Icon bannerRight=new ImageIcon(this.getClass().getResource("/resources/static/banner/bannerright.jpg"));
		//panelDerecho.add(new JLabel(bannerRight), BorderLayout.EAST);
		getContentPane().add(panelSuperior, BorderLayout.NORTH);
	}
}
