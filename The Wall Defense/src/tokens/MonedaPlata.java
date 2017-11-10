package tokens;

import javax.swing.ImageIcon;

import mapa.Celda;

public class MonedaPlata extends Moneda {

	public MonedaPlata(Celda c, int prof) {
		super(c, prof);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/MonedaPlata.gif")));
		duracion = 10;
		valor = 50;
		activar();
	}
}
