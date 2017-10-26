package interfaz;

import javax.swing.*;
import java.awt.*;

public class Score extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ProximaHorda horda;
	
	public Score(Escenario stage) {
		this.setLayout(new BorderLayout());
		horda=new ProximaHorda(stage);
		stage.setHorda(horda);
		armarPanel();
		
	}
	
	public void armarPanel() {
		//Icon bannerUp=new ImageIcon(this.getClass().getResource("/resources/static/banner/score2.png"));
		//this.add(new JLabel(bannerUp),BorderLayout.CENTER);
		this.setBackground(Color.BLACK);
		this.add(horda, BorderLayout.EAST);
	}
}
