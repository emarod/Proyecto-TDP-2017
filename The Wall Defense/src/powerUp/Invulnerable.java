package powerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;

public class Invulnerable extends PowerUp {
	
	public Invulnerable(Celda c, int prof) {
		super(c, prof);
		grafico=new JLabel();
		graficoToken = new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/token_campo_fuerza.gif")));
		graficoToken.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/campo_fuerza.gif")));
	}
	
	public JLabel getGraficoToken(){
		return graficoToken;
	}
}
