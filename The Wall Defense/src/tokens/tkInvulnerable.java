package tokens;

import javax.swing.ImageIcon;

import efectos.Invulnerable;
import mapa.Celda;

public class tkInvulnerable extends TokenPowerUp {

	public tkInvulnerable(Celda c) {
		super(c);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/token_campo_fuerza.gif")));
		duracion = 7;
		power = new Invulnerable(c);
		activar();
	}

}
