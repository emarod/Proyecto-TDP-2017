package main;

import enemigo.Horda;
import mapa.Celda;
import terreno.Nieve;
import terreno.Pasto;
import terreno.Terreno;

public class CONFIG {
	// Profundidad de celdas
	public static final int PROFUNDIDAD_CELDA = 6;
	public static final int PROFUNDIDAD_TERRENO = 0;
	public static final int PROFUNDIDAD_ENEMIGO = 2;
	public static final int PROFUNDIDAD_JUGADOR = 1;
	public static final int PROFUNDIDAD_OBSTACULO = 2;
	public static final int PROFUNDIDAD_PRECIOSO = 3;
	public static final int PROFUNDIDAD_EFECTO = 3;
	public static final int PROFUNDIDAD_DISPARO = 4;
	public static final int PROFUNDIDAD_PREMIO = 3;
	public static final int PROFUNDIDAD_TOKEN = 5;
	public static final int PROFUNDIDAD_COMPRABLE = 1;

	// Dimensiones Mapa
	public static final int CANT_CELDAS_Y = 6;
	public static final int CANT_CELDAS_X = 16;

	public static Terreno crearTerreno(Celda c, int n) {
		Terreno terreno;
		switch (n) {
			case 1:
				terreno = new Nieve(c);
				break;
			case 2:
				terreno = new Pasto(c);
				break;

			default:
				terreno = new Nieve(c);
				break;
		}
		terreno.crear();
		return terreno;

	}

	public static Horda crearHorda(int d) {
		return new Horda(d);
	}
}
