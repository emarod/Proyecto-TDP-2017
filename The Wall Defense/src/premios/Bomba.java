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
			new Explosion(celda, explosion, daño);
			new Explosion(Director.getCelda(celda.getPosX() + 1, celda.getPosY()), OED, daño);
			new Explosion(Director.getCelda(celda.getPosX() - 1, celda.getPosY()), OEI, daño);
			new Explosion(Director.getCelda(celda.getPosX(), celda.getPosY() + 1), OEAR, daño);
			new Explosion(Director.getCelda(celda.getPosX(), celda.getPosY() - 1), OEAB, daño);
			Director.getBancoRecursos().playExplosion();
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
