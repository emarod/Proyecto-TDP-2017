package tokens;

import javax.swing.ImageIcon;

import mapa.Celda;
import premios.Bomba;

public class tkBomba extends TokenPrecioso {

	public tkBomba(Celda c) {
		super(c);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/token_bomba.gif")));
		duracion = 7;
		precioso = new Bomba(null);
		activar();
	}

}
