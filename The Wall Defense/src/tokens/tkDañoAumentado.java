package tokens;

import javax.swing.ImageIcon;

import efectos.DañoAtkAumentado;
import mapa.Celda;

public class tkDañoAumentado extends TokenPowerUp {

	public tkDañoAumentado(Celda c) {
		super(c);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/token_daño_atk_aumentado.gif")));
		duracion = 7;
		power = new DañoAtkAumentado(c);
		activar();
	}

}
