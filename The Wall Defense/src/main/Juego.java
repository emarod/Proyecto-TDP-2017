package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;

import interfaz.GUI;

public class Juego {
	private static GUI frame;

	public static void main(String[] args) {
		new Juego();

	}
	
	public Juego() {
		pantallaPrincipal();
	}
	
	public void pantallaPrincipal(){
		final JFrame menu=new JFrame("The Wall Defense");
		menu.setVisible(true);
		menu.setResizable(true);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setBounds(100, 100, 525, 410);
		menu.setLocationRelativeTo(null);
		JLayeredPane contentPane=new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menu.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Menu
		//Boton Jugar accede al juego.
		final JButton jugar=new JButton("Jugar");
		jugar.setBounds(185,140,150,50);
		jugar.setVisible(true);	  	   
		jugar.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				menu.dispose();
				crearGUI();			   
			} 
		}
		);
		menu.add(jugar,new Integer(2));
	}
	
	public void crearGUI(){
		frame=new GUI(this);
		frame.setVisible(true);
	}	

}
