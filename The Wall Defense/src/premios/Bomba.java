package premios;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Controladores.Director;
import efectos.Explosion;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Bomba.
 * Clase que especifica el comportamiento del poder bomba.
 */

public class Bomba extends PremioTemporal {

	protected int costo;
	protected Icon[] explosion;

	// Constructor.
	public Bomba() {
		super();
		construir();
	}

	public Bomba(Celda c) {
		super(c);
		construir();

	}

	private void construir() {
		tiempo = 1;
		graficos = new Icon[5];
		explosion = new Icon[7];
		for (int i = 0; i < graficos.length; i++) {
			if (i < 5) {
				graficos[i] = new ImageIcon(this.getClass().getResource("/resources/static/bomba/00" + i + ".png"));
			}
		}
		for (int i = 5; i < explosion.length; i++) {
			if (i < 10) {
				explosion[i] = new ImageIcon(this.getClass().getResource("/resources/static/bomba/00" + i + ".png"));
			}
			else {
				explosion[i] = new ImageIcon(this.getClass().getResource("/resources/static/bomba/0" + i + ".png"));
			}
		}

		graph = 0;
		grafico.setIcon(graficos[graph]);
		Director.ejecutarUna(this, tiempo);

	}

	public void explotar() {
		if (graph < 4) {
			grafico.setIcon(graficos[graph++]);
			Director.ejecutarUna(this, tiempo);
		}
		else {
			grafico.setIcon(graficos[graph]);
			new Explosion(celda, explosion);
			new Explosion(Director.getCelda(celda.getPosX() + 1, celda.getPosY()), explosion);
			new Explosion(Director.getCelda(celda.getPosX() - 1, celda.getPosY()), explosion);
			new Explosion(Director.getCelda(celda.getPosX(), celda.getPosY() + 1), explosion);
			new Explosion(Director.getCelda(celda.getPosX(), celda.getPosY() - 1), explosion);
			destruir();
		}
	}

	@Override
	public void destruir() {
		super.destruir();
	}

	// Metodos heredados.

	public void setGrafico(int i) {
		grafico.setIcon(graficos[i]);
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitPremio(this);
	}

	@Override
	public Premio clone(Celda c) {
		Premio clon = new Bomba(c);
		return clon;
	}

	@Override
	public void run() {
		explotar();
	}

}
