package interfaz;

import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;

import javax.swing.*;
import main.Juego;


public class GUI extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private JLayeredPane contentPane;
    private Thread hilo;	
	private static Juego juego;
	private Escenario mapa;
	private MenuCompra tienda;
	private ProximaHorda horda;
	private JPanel panelInferior;

	public GUI(final Juego j) {	
		super("The Wall Defense");
		getContentPane().setLayout(null);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 618);
		setLocationRelativeTo(null);
		
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		//Menu de proxima horda
		horda= new ProximaHorda();
		
		
		//MenuCompra
		tienda= new MenuCompra();
		
		
		//Panel Inferior
		panelInferior= new JPanel();
		panelInferior.setLayout(new BorderLayout());
		contentPane.add(panelInferior, BorderLayout.SOUTH);
		panelInferior.add(horda, BorderLayout.EAST);
		panelInferior.add(tienda,BorderLayout.WEST);
		
		//Escenario. Donde va el mapa
		mapa= new Escenario();
		contentPane.add(mapa, BorderLayout.CENTER);
		
		
		hilo=new Thread(this);
		hilo.start();
		GUI.juego=j;
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
