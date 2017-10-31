package powerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;

public class Bomba extends PowerUp {
	
	public Bomba(Celda c, int prof) {
		super(c, prof);
		grafico=new JLabel();
		graficoToken = new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/token_bomba.gif")));
		graficoToken.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/explosion.gif")));
	}
	
	public JLabel getGraficoToken(){
		return graficoToken;
	}
}
