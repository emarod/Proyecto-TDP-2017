package powerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import jugador.Jugador;
import mapa.Celda;

/*
 * Clase Invulnerable.
 * Clase que especifica el comportamiento del poder que vuelve invulnerable a un personaje.
 */

public class Invulnerable extends PowerUp {
	
	//Constructor.
	public Invulnerable(Celda c, int prof) {
		super(c, prof);
		grafico=new JLabel();
		graficoToken = new JLabel();
		graficoToken.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/token_campo_fuerza.gif")));
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/campo_fuerza.gif")));
	}
	
	//Metodos heredados.
	public JLabel getGraficoToken(){
		return graficoToken;
	}
	
	public void aplicar(Jugador j){
		j.setInvulnerable();		
	}

	public void run() {
		super.run();		
	}
}
