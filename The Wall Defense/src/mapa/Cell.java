package mapa;

import java.util.List;

public class Cell extends Celda {

	public Cell(int posX, int posY) {
		super(posX, posY);
	}

	@Override
	public void addChild(Celda c) {
		throw new UnsupportedOperationException("Operacion no soportada");
	}

	@Override
	public void removeChild(Celda c) {
		throw new UnsupportedOperationException("Operacion no soportada");
	}

	@Override
	public List<Celda> getChildren(Celda c) {
		throw new UnsupportedOperationException("Operacion no soportada");
	}

}
