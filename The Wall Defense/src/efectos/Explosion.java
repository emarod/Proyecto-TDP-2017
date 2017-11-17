package efectos;

import java.util.concurrent.TimeUnit;

import javax.swing.Icon;

import Controladores.Director;
import main.CONFIG;
import main.GameObject;
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
		Director.ejecutarUna(this, tiempo, TimeUnit.MILLISECONDS);
	}

	@Override
	public void aplicar(Unidad u) {
		u.recibirDaño(daño);
	}

	public void setIcon(Icon i) {
		grafico.setIcon(i);
	}

	@Override
	public void destruir() {
		super.destruir();
		graficos = null;
		System.out.println("explosion eliminada");
	}

	@Override
	public void run() {
		if (graph == graficos.length) {
			destruir();
		}
		else {
			grafico.setIcon(graficos[graph]);
			graph++;
			GameObject afectar = celda.getObjects()[CONFIG.PROFUNDIDAD_ENEMIGO];
			if (afectar != null) {
				afectar.accept(visitor);
			}
			Director.ejecutarUna(this, tiempo, TimeUnit.MILLISECONDS);
		}

	}

}
