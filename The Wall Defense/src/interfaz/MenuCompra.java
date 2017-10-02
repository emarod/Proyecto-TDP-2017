package interfaz;
 
 import javax.swing.JPanel;
 
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import mapa.Map;

public class MenuCompra extends JPanel{
	JLabel personaje;
	JPanel panel;
	Map mapa;
 
 	/**
 	 * 
 	 */
 	private static final long serialVersionUID = 1L;
 	
	public MenuCompra(Escenario mapa ) {
		this.mapa=mapa.getMapa();		
		personaje=new JLabel(new ImageIcon(this.getClass().getResource("/resources/dinamic/Ygritte.gif")));
		personaje.setBounds(10, 0, 46, 14);
		personaje.setSize(32, 32);
		añadirOyentes();
	}
	
	public void armarMenu() {
		
		panel.add(personaje);
		
	
	}
	
	public void añadirOyentes() {
		
		personaje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				personaje.setVisible(false);
				mapa.agregarPersonajeEnMapa(1, 1, arg0);
				/**try {
					arg0.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				personaje.setVisible(true);
				**/
			}
		});
	}
	
}
