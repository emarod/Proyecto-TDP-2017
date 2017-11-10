package tokens;

import javax.swing.ImageIcon;

import mapa.Celda;
import powerUp.DañoAtkAumentado;

public class tkDañoAumentado extends TokenPowerUp {

	public tkDañoAumentado(Celda c, int prof) {
		super(c, prof);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/token_daño_atk_aumentado.gif")));
		duracion = 7;
		power = new DañoAtkAumentado(c, prof);
		activar();
	}

}
