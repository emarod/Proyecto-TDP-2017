package tokens;

import javax.swing.ImageIcon;

import mapa.Celda;

public class MonedaOro extends Moneda {

	public MonedaOro(Celda c, int prof) {
		super(c, prof);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/MonedaOro.gif")));
		duracion = 10;
		valor = 100;
		activar();
	}
}
