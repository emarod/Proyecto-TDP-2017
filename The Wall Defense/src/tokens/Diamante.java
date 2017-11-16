package tokens;

import javax.swing.ImageIcon;

import mapa.Celda;

public class Diamante extends Moneda {

	public Diamante(Celda c) {
		super(c);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/diamante.gif")));
		duracion = 10;
		valor = 500;
		activar();
	}

}
