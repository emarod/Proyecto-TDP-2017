package premios;

import main.Visitor;
import mapa.Celda;

public abstract class PremioVida extends Premio {

	public PremioVida(Celda c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	public PremioVida() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Premio clone(Celda c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCosto() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean accept(Visitor V) {
		// TODO Auto-generated method stub
		return false;
	}

}
