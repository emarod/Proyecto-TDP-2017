package obstaculos;

import mapa.Celda;

public abstract class ObstaculoVida extends Obstaculo {
	protected int vida;

	public ObstaculoVida(Celda[] c) {
		super(c);
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
