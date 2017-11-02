package powerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jugador.Jugador;
import main.GameObject;
import mapa.Celda;

public class DañoAtkAumentado extends PowerUp {
	
	public DañoAtkAumentado(Celda c, int prof) {
		super(c, prof);
		grafico=new JLabel();
		graficoToken = new JLabel();
		graficoToken.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/token_daño_atk_aumentado.gif")));
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/daño_atk_aumentado.gif")));
	}
	
	public JLabel getGraficoToken(){
		return graficoToken;
	}
	
	public void aplicar(Jugador j){
		int ataque_actual = j.getAtaque();
		j.setAtaque(ataque_actual*2);
	}
	
}
