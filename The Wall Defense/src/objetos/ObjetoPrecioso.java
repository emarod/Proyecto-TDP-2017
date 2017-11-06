package objetos;

import javax.swing.Icon;

import main.GameObject;
import mapa.Celda;

public abstract class ObjetoPrecioso extends GameObject {
	// Atributos locales.
	protected int vida;
	protected Obstaculo obstaculo;
	protected Icon[] graficos;
	protected int graph;

	public ObjetoPrecioso(Celda[] c, int prof) {
		celda = c;
		profundidad = prof;
	}

	public boolean recibirDaño(int golpe) {
		boolean destruir = false;
		if (vida <= golpe) {
			destruir = true;
		}
		else {
			vida = vida - golpe;
		}
		if (destruir) {
			destruir();
		}
		return destruir;
	}

}
