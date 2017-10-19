package interfaz;
 
 import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import interfaz.botones.BtnArquero;
import interfaz.botones.BtnCaballero;
import interfaz.botones.BtnEspadachin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import mapa.Map;

public class MenuCompra extends JPanel{
	JLabel personaje;
	Map mapa;
	private Escenario escenario;
 	/**
 	 * 
 	 */
 	private static final long serialVersionUID = 1L;
 	
	public MenuCompra(Escenario escenario) {
		this.escenario= escenario;
		this.setLayout(new GridLayout(2,2));
		this.setBounds(76, 0, 650, 394);
		this.setBackground(Color.RED);
		this.setBorder(new LineBorder(new Color(0, 0, 0)));		
		this.setPreferredSize(new Dimension(384, 96));
		armarBotonera();
	}
	
	private void armarBotonera() {
		BtnArquero ygritte= new BtnArquero(this.escenario);
		this.add(ygritte);
		
		
		BtnCaballero lannister = new BtnCaballero(this.escenario);
		this.add(lannister);
		
		JButton caminante = new JButton(new ImageIcon(this.getClass().getResource("/resources/dinamic/white_walker.gif")));
		caminante.setSize(32, 32);
		caminante.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						escenario.crearPersonaje("caminante");
					}
				}
		);
		this.add(caminante);
		
		BtnEspadachin JonSnow = new BtnEspadachin(this.escenario);
		this.add(JonSnow);
		
	}
		

	
}