package interfaz;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ProximaHorda extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel puntaje;
	protected Escenario escenario;
	
	public ProximaHorda(Escenario esc) {
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.escenario=esc;
		agregarLabel();
		agregarBoton();
	}
	
	private void agregarLabel() {
		puntaje=new JLabel("Puntaje: 0000");
		this.add(puntaje);
	}
	
	private void agregarBoton() {
		JButton wwalker=new JButton(new ImageIcon(this.getClass().getResource("/resources/dinamic/white_walker.gif")));
		wwalker.setSize(32,32);
		wwalker.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						escenario.crearPersonaje("whitewalker");
					}
				}
		);
		this.add(wwalker);	
	}
}
