package powerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jugador.Jugador;
import mapa.Celda;

public class VelAtkAumentado extends PowerUp {
		
		public VelAtkAumentado(Celda c, int prof) {
			super(c, prof);
			grafico=new JLabel();
			graficoToken.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/token_vel_atk_aumentado.gif")));
			//graficoToken.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/daño_atk_aumentado.gif")));
		}
		
		public JLabel getGraficoToken(){
			return graficoToken;
		}
		
		public void aplicar(Jugador j){
			//Duplicar la vel de ataque.
		}
	}
