package interfaz;

import java.awt.Dimension;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import mapa.Map;

public class Escenario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int width=20;
	private static final int height=12;
	private JLayeredPane layeredPane;
	public Escenario(){
		Random rnd=new Random();
		int r=rnd.nextInt(2);		
		layeredPane= new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(640, 384));		
		layeredPane.setBorder(BorderFactory.createTitledBorder(
				"The winter is coming wacho..."
		));
		this.add(layeredPane);
		new Map(this,width,height,r);
//		this.setBackground(new Color(255, 0, 255, 255));
	}
	
	public void  agregar(JLabel objeto,Integer entero){
		objeto.setSize(32,32);
		layeredPane.add(objeto,entero);
	}
	

}
