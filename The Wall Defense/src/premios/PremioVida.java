package premios;

import mapa.Celda;

public abstract class PremioVida extends Premio {

	protected int vida;

	public PremioVida(Celda c) {
		super(c);
	}

	public PremioVida() {
		super();
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
