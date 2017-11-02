package powerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jugador.Jugador;
import main.GameObject;
import mapa.Celda;

public class Bomba extends PowerUp {
	
	public Bomba(Celda c, int prof) {
		super(c, prof);
		grafico=new JLabel();
		graficoToken = new JLabel();
		graficoToken.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/token_bomba.gif")));
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/explosion.gif")));
	}
	
	public JLabel getGraficoToken(){
		return graficoToken;
	}
	
	public void aplicar(Celda c){
		GameObject objetos []= c.getObjects();
		for(int i=1 ;i<objetos.length; i++){
			objetos[i]=null;
		}
	}

	@Override
	public void aplicar(Jugador j) {
		// TODO Auto-generated method stub
		
	}
}
