package tokens;

import javax.swing.ImageIcon;

import mapa.Celda;
import powerUp.VelAtkAumentado;

public class tkVelocidadAumentada extends TokenPowerUp {

	public tkVelocidadAumentada(Celda c, int prof) {
		super(c, prof);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/token_vel_atk_aumentado.gif")));
		duracion = 7;
		power = new VelAtkAumentado(c, prof);
		activar();
	}

}
