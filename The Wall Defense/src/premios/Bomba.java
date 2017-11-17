package premios;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Controladores.Director;
import efectos.Explosion;
import mapa.Celda;

/*
 * Clase Bomba.
 * Clase que especifica el comportamiento del poder bomba.
 */

public class Bomba extends PremioTemporal {

	protected int daño;
	protected Icon[] explosion;
	protected Icon[] OEAR;
	protected Icon[] OEAB;
	protected Icon[] OED;
	protected Icon[] OEI;

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
		daño = 10;
		graficos = new Icon[5];
		explosion = new Icon[7];
		OEAR = new Icon[7];
		OEAB = new Icon[7];
		OED = new Icon[7];
		OEI = new Icon[7];

		// BOMBA
		for (int i = 0; i < graficos.length; i++) {
			if (i < 5) {
				graficos[i] = new ImageIcon(this.getClass().getResource("/resources/static/bomba/00" + i + ".png"));
			}
		}

		// EXPLOSION
		for (int i = 0; i < explosion.length; i++) {
			int f = i + 5;
			if (f < 10) {
				explosion[i] = new ImageIcon(this.getClass().getResource("/resources/static/bomba/00" + f + ".png"));
			}
			else {
				explosion[i] = new ImageIcon(this.getClass().getResource("/resources/static/bomba/0" + f + ".png"));
			}
		}

		// ONDA abajo
		for (int i = 0; i < OEAB.length; i++) {
			if (i < 7) {
				System.out.print("10" + i);
				OEAB[i] = new ImageIcon(this.getClass().getResource("/resources/static/bomba/10" + i + ".png"));
			}
		}
		// ONDA arriba
		for (int i = 0; i < OEAR.length; i++) {
			if (i < 7) {
				OEAR[i] = new ImageIcon(this.getClass().getResource("/resources/static/bomba/20" + i + ".png"));
			}
		}
		// ONDA derecha
		for (int i = 0; i < OED.length; i++) {
			if (i < 7) {
				OED[i] = new ImageIcon(this.getClass().getResource("/resources/static/bomba/30" + i + ".png"));
			}
		}
		// ONDA izquierda
		for (int i = 0; i < OEI.length; i++) {
			if (i < 7) {
				OEI[i] = new ImageIcon(this.getClass().getResource("/resources/static/bomba/40" + i + ".png"));
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
			int x = celda.getPosX();
			int y = celda.getPosY();
			nuevaExplosion(celda);

			Celda celda1 = Director.getCelda(x + 1, y);
			nuevaOnda(celda1, OED);
			Celda celda2 = Director.getCelda(x - 1, y);
			nuevaOnda(celda2, OEI);
			Celda celda3 = Director.getCelda(x, y + 1);
			nuevaOnda(celda3, OEAB);
			Celda celda4 = Director.getCelda(x, y - 1);
			nuevaOnda(celda4, OEAR);

			Director.getBancoRecursos().playExplosion();
			destruir();
		}
	}

	@Override
	public void destruir() {
		super.destruir();
	}

	private void nuevaExplosion(Celda c) {
		if (c != null) {
			new Explosion(c, explosion, daño).crear();
		}
	}

	private void nuevaOnda(Celda c, Icon[] graficos) {
		if (c != null) {
			new Explosion(c, graficos, daño).crear();
		}
	}

	// Metodos heredados.

	public void setGrafico(int i) {
		grafico.setIcon(graficos[i]);
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
