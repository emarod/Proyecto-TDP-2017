package powerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import jugador.Jugador;
import mapa.Celda;

/*
 * Clase DañoAtkAumentado.
 * Clase que especifica el comportamiento del poder que aumenta el daño de ataque.
 */

public class DañoAtkAumentado extends PowerUp {
	
	//Constructor.
	public DañoAtkAumentado(Celda c, int prof) {
		super(c, prof);
		grafico=new JLabel();
		graficoToken = new JLabel();
		graficoToken.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/token_daño_atk_aumentado.gif")));
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/daño_atk_aumentado.gif")));
	}
	
	//Metodos heredados.
	public JLabel getGraficoToken(){
		return graficoToken;
	}
	
	public void aplicar(Jugador j){
		int ataque_actual = j.getDaño();
		j.setAtaque(ataque_actual*2);
	}

	public void run() {
		super.run();		
	}
	
}
