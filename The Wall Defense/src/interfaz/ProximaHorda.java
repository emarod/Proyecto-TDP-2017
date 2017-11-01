package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import enemigo.Horda;

public class ProximaHorda extends JPanel{
	
	protected static final long serialVersionUID = 1L;
	protected JLabel puntaje;
	protected Escenario escenario;
	protected Horda horda;
	
	public ProximaHorda(Escenario esc) {
		this.setLayout(new BorderLayout());
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.escenario=esc;
		agregarLabel();
		//agregarBoton();
		this.setBackground(Color.BLACK);
		horda=new Horda(escenario);
		
	}
	
	private void agregarLabel() {
		puntaje=new JLabel("0000");
		puntaje.setSize(puntaje.getWidth(), this.getHeight());
		//Recojo la fuente que se esta utilizando actualmente.
		Font auxFont=new Font("Game of Thrones Regular", Font.CENTER_BASELINE,50); 
		//Aplico la fuente actual, y al final le doy el tamaño del texto...
		puntaje.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 50));
		//puntaje.setSize(new Dimension(10,50));
		this.add(puntaje,BorderLayout.CENTER);
	}
	
	public void setPuntaje(String str) {
		puntaje.setText(str);
	}
	
	private void agregarBoton() {
		JButton wwalker=new JButton(new ImageIcon(this.getClass().getResource("/resources/dinamic/white_walker.gif")));
		wwalker.setSize(32,32);
		wwalker.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						//escenario.crearPersonaje("whitewalker");
					}
				}
		);
		this.add(wwalker);
		
		JButton dañar=new JButton(new ImageIcon(this.getClass().getResource("/resources/static/disparo/flecha.png")));
		dañar.setSize(32,32);
		dañar.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						escenario.hacerDaño();
					}
				}
		);
		this.add(dañar);
	}
}
