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
	}

	@Override
	public void run() {
		if (graph == graficos.length) {
			destruir();
		}
		else {
			grafico.setIcon(graficos[graph]);
			graph++;
			GameObject afectarEnemigo = celda.getObjects()[CONFIG.PROFUNDIDAD_ENEMIGO];
			GameObject afectarJugador = celda.getObjects()[CONFIG.PROFUNDIDAD_JUGADOR];
			if (afectarEnemigo != null) {
				afectarEnemigo.accept(visitor);
			}
			if (afectarJugador != null) {
				afectarJugador.accept(visitor);
			}
			Director.ejecutarUna(this, tiempo, TimeUnit.MILLISECONDS);
		}

	}

}
