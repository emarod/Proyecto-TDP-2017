package tokens;

import javax.swing.ImageIcon;

import mapa.Celda;

public class MonedaOro extends Moneda {

	public MonedaOro(Celda c) {
		super(c);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/MonedaOro.gif")));
		duracion = 10;
		valor = 100;
		activar();
	}
}
