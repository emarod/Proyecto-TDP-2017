package objetoMapa;

import mapa.Celda;

public abstract class ObjetoMapaVida extends ObjetoMapa {
	protected int vida;

	public ObjetoMapaVida(Celda c) {
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
