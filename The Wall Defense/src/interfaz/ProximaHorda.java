package interfaz;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ProximaHorda extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel puntaje;
	
	public ProximaHorda() {
		
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		agregarLabel();
	}
	
	private void agregarLabel() {
		puntaje=new JLabel("Puntaje: 1000");
		this.add(puntaje);
	}
}
