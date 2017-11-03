package interfaz;

import javax.swing.*;
import java.awt.*;

/*
 * Clase Score.
 * Clase encargada de desplegar el panel con el puntaje.
 */

public class Score extends JPanel {
	
	//Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected ProximaHorda horda;
	
	//Constructor.
	public Score(Escenario stage) {
		this.setLayout(new BorderLayout());
		horda=new ProximaHorda(stage);
		stage.setHorda(horda);
		armarPanel();
		
	}
	
	//Metodos locales.
	public void armarPanel() {
		//Icon bannerUp=new ImageIcon(this.getClass().getResource("/resources/static/banner/score2.png"));
		//this.add(new JLabel(bannerUp),BorderLayout.CENTER);
		this.setBackground(Color.BLACK);
		this.add(horda, BorderLayout.EAST);
	}
}
