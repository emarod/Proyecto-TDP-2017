package interfaz;

import java.awt.BorderLayout;

import javax.swing.*;


public class GUI extends JFrame{
	
	protected static final long serialVersionUID = 1L;
	protected Escenario escenario;
	protected MenuCompra tienda;
	protected ProximaHorda horda;
	protected JPanel panelInferior;

	public GUI() {	
		super("The Wall Defense");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 650, 528);
		this.setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		
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
		getContentPane().add(panelInferior, BorderLayout.SOUTH);
		panelInferior.add(horda, BorderLayout.EAST);
		panelInferior.add(tienda,BorderLayout.WEST);
		
		
	}
}
