package interfaz;
 
 import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import mapa.Map;

public class MenuCompra extends JPanel{
	JLabel personaje;
	Map mapa;
	private JLayeredPane layeredPane;
 
 	/**
 	 * 
 	 */
 	private static final long serialVersionUID = 1L;
 	
	public MenuCompra() {
//		this.setLayout(null);
		layeredPane= new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(384, 96));
		this.add(layeredPane);
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setBackground(UIManager.getColor("Button.background"));
		this.setPreferredSize(new Dimension(384, 96));
		personaje=new JLabel(new ImageIcon(this.getClass().getResource("/resources/dinamic/Ygritte.gif")));
		personaje.setBounds(0, 0, 32, 32);
		personaje.setSize(32, 32);
		layeredPane.add(personaje);
		añadirOyentes();
		System.out.println("personaje =>("+personaje.getX()+","+personaje.getY()+")");
	}
	
	public void armarMenu() {
	}
	
	public void añadirOyentes() {		
		personaje.addMouseListener(new MouseInputListener() {
			int xi,yi,xf,yf;
			
			
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println("holas");
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				personaje.setLocation((e.getX()/32)*32, (e.getY()/32)*32);
				
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				personaje.setLocation((e.getX()/32)*32, (e.getY()/32)*32);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				xi = personaje.getX();
				yf = personaje.getY();				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
//				personaje.setVisible(false);
				System.out.println("posición =>("+e.getX()+","+e.getY()+")");
			}
		});
	}
	
}
