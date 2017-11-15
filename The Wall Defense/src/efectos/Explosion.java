package efectos;

import java.util.concurrent.TimeUnit;

import javax.swing.Icon;

import Controladores.Director;
import main.Unidad;
import mapa.Celda;

public class Explosion extends BuffTemporal {

	protected Icon[] graficos;
	protected int graph;

	public Explosion(Celda c, Icon[] graficos) {
		super(c);
		this.graficos = graficos;
		tiempo = 100;
		graph = 0;
		grafico.setIcon(this.graficos[graph]);
		grafico.setBounds(celda.getPosX() * 64, celda.getPosY() * 64, 64, 64);
		celda.getObjects()[profundidad] = this;
		Director.getMapa().getEscenario().agregar(grafico, profundidad);
		Director.ejecutarUna(this, tiempo, TimeUnit.MILLISECONDS);
	}

	@Override
	public void aplicar(Unidad u) {

	}

	public void setIcon(Icon i) {
		grafico.setIcon(i);
	}

	@Override
	public void destruir() {
		super.destruir();

	}

	@Override
	public void run() {
		if (graph == graficos.length) {
			destruir();
		}
		else {
			System.out.println("holaaa " + celda.getPosX() + "," + celda.getPosY());
			grafico.setIcon(graficos[graph++]);
			Director.ejecutarUna(this, tiempo, TimeUnit.MILLISECONDS);
		}

	}

}
