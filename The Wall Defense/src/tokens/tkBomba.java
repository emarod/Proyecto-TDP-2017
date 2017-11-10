package tokens;

import javax.swing.ImageIcon;

import mapa.Celda;
import preciosos.Bomba;

public class tkBomba extends TokenPrecioso {

	public tkBomba(Celda c, int prof) {
		super(c, prof);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/token_bomba.gif")));
		duracion = 7;
		precioso = new Bomba(prof);
		activar();
	}

}
