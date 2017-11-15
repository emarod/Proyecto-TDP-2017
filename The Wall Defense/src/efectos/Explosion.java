package efectos;

import java.util.concurrent.TimeUnit;

import javax.swing.Icon;

import Controladores.Director;
import main.CONFIG;
import main.Unidad;
import mapa.Celda;

public class Explosion extends BuffTemporal {

	protected Icon[] graficos;
	protected int graph;
	protected int daño;

	public Explosion(Celda c, Icon[] graficos, int d) {
		super(c);
		this.graficos = graficos;
		tiempo = 100;
		daño = d;
		graph = 0;
		grafico.setIcon(this.graficos[graph]);
		grafico.setBounds(celda.getPosX() * 64, celda.getPosY() * 64, 64, 64);
		celda.getObjects()[profundidad] = this;
		Director.getMapa().getEscenario().agregar(grafico, profundidad);
		Director.ejecutarUna(this, tiempo, TimeUnit.MILLISECONDS);
	}

	@Override
	public void aplicar(Unidad u) {
		System.out.println("destruir daño " + daño);
		u.recibirDaño(daño);
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
			grafico.setIcon(graficos[graph++]);
			celda.getObjects()[CONFIG.PROFUNDIDAD_ENEMIGO].accept(visitor);
			Director.ejecutarUna(this, tiempo, TimeUnit.MILLISECONDS);
		}

	}

}
