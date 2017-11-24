package objetos;

import main.GameObject;
import mapa.Celda;

public abstract class ObjetoVida extends GameObject implements Vida {

	protected int vida;

	public ObjetoVida(Celda c) {
		super(c);
	}

	@Override
	public void recibirDaño(int golpe) {
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
	}

	@Override
	public int getVida() {
		return vida;
	}

	@Override
	public void setVida(int v) {
		vida = v;
	}

}
