package efectos;

import main.Unidad;
import mapa.Celda;

public class Relentizar extends BuffTemporal {

	public Relentizar(Celda c) {
		super(c);
		tiempo = 3;
	}

	@Override
	public void aplicar(Unidad u) {
		unidad = u;
		unidad.setVelocidad(Math.round(unidad.getVelocidad() / 2));
		crear();
		ejecutar();
	}

}
