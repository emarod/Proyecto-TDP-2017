package objetos;

import mapa.Celda;

public abstract class ObstaculoVida extends Obstaculo {
	protected int vida;

	public ObstaculoVida(Celda[] c, int prof) {
		super(c, prof);
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
