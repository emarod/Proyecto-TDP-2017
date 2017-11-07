package interfaz;
/*
 * Clase Dinero.
 * Clase encargada de mostrar la cantidad de dinero.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Nivel extends JPanel{
	
	//Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected Icon level;
	protected Escenario escenario;
	
	//Constructor.
	public Nivel(Escenario esc) {
		this.setLayout(new BorderLayout());
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.escenario=esc;
		agregarLabel();
		this.setBackground(Color.BLACK);		
	}
	
	//Metodos locales.
	private void agregarLabel() {
		level=new ImageIcon(this.getClass().getResource("/resources/static/etiquetas/level1.png"));
		this.add(new JLabel(level), BorderLayout.CENTER);	
	}
	
	
	public void setLevel(int i) {
		
		switch(i) {
		
		case 1: {
			level=new ImageIcon(this.getClass().getResource("/resources/static/etiquetas/level1.png"));
			this.add(new JLabel(level), BorderLayout.CENTER);	
		}
		case 2: {
			level=new ImageIcon(this.getClass().getResource("/resources/static/etiquetas/level2.png"));
			this.add(new JLabel(level), BorderLayout.CENTER);	
		}
			
		}
	}
	
}