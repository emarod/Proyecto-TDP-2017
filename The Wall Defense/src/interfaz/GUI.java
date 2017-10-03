package interfaz;

import java.awt.BorderLayout;

import javax.swing.*;
import main.Juego;


public class GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private Escenario mapa;
	private MenuCompra tienda;
	private ProximaHorda horda;
	private JPanel panelInferior;

	public GUI() {	
		super("The Wall Defense");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 640, 528);
		this.setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		
		//Menu de proxima horda
		horda= new ProximaHorda();
		
		
		//Escenario. Donde va el mapa
		mapa= new Escenario();	
		getContentPane().add(mapa, BorderLayout.CENTER);
		
		//MenuCompra
		tienda= new MenuCompra();		

		//Panel Inferior
		panelInferior= new JPanel();
		panelInferior.setLayout(new BorderLayout());
		getContentPane().add(panelInferior, BorderLayout.SOUTH);
		panelInferior.add(horda, BorderLayout.EAST);
		panelInferior.add(tienda,BorderLayout.WEST);
		
		
	}
}
