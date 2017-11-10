package tokens;

import javax.swing.ImageIcon;

import mapa.Celda;
import powerUp.Invulnerable;

public class tkInvulnerable extends TokenPowerUp {

	public tkInvulnerable(Celda c, int prof) {
		super(c, prof);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/token_campo_fuerza.gif")));
		duracion = 7;
		power = new Invulnerable(c, prof);
		activar();
	}

}
