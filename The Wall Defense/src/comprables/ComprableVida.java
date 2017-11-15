package comprables;

import mapa.Celda;

public abstract class ComprableVida extends Comprable {

	protected int vida;

	public ComprableVida(Celda c) {
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
