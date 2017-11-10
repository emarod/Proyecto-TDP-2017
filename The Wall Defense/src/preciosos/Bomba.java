package powerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import jugador.Jugador;
import main.GameObject;
import mapa.Celda;

/*
 * Clase Bomba.
 * Clase que especifica el comportamiento del poder bomba.
 */

public class Bomba extends PowerUp {
	
	//Constructor.
	public Bomba(Celda c, int prof) {
		super(c, prof);
		grafico=new JLabel();
		graficoToken = new JLabel();
		graficoToken.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/token_bomba.gif")));
		c.getEscenario().repaint();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/explosion.gif")));
	}
	
	public void aplicar(Celda c){
		GameObject objetos []= c.getObjects();
		for(int i=1 ;i<objetos.length; i++){
			objetos[i]=null;
		}
	}

	//Metodos heredados.
	public void aplicar(Jugador j) {
		
	}
	
	public JLabel getGraficoToken(){
		return graficoToken;
	}
	
}
