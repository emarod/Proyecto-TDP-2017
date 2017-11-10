package tokens;

import javax.swing.ImageIcon;

import mapa.Celda;

public class MonedaBronce extends Moneda {

	public MonedaBronce(Celda c, int prof) {
		super(c, prof);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/MonedaBronce.gif")));
		duracion = 10;
		valor = 25;
		activar();
	}
}