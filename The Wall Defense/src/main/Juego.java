package main;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;

import interfaz.GUI;
public class Juego {
	protected static GUI frame;

	public static void main(String[] args) {
		new Juego();

	}
	
	public Juego() {
		pantallaPrincipal();
	}
	
	public void pantallaPrincipal(){
		final JFrame menu=new JFrame("The Wall Defense");
		menu.setVisible(true);
		menu.setResizable(false);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setBounds(100, 100, 525, 410);
		menu.setLocationRelativeTo(null);
		JLayeredPane contentPane=new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menu.setContentPane(contentPane);
		//imagen para boton y fondo
		Icon imagenboton=new ImageIcon(this.getClass().getResource("/resources/static/background/start.png"));
		Icon background=new ImageIcon(this.getClass().getResource("/resources/static/background/background.png"));


		//Menu
		//Boton Jugar accede al juego.
		final JButton jugar=new JButton("Jugar");
		jugar.setBounds(200,190,150,50);
		jugar.setSize(300,100);
		jugar.setVisible(true);	  
		jugar.setIcon(imagenboton);
		//jugar.setBounds(170, y, width, height);
		jugar.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				menu.dispose();
				crearGUI();			   
			} 
		}
		);
		
		menu.setContentPane(new JLabel(background));
		menu.pack();
		menu.add(jugar,new Integer(2));

	}
	
	public void crearGUI(){
		frame=new GUI();
		frame.setVisible(true);
	}	

}
