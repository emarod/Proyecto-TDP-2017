package mapa;

public class ParentCell extends Celda {

	protected Celda child;

	public ParentCell(int posX, int posY) {
		super(posX, posY);
	}

	@Override
	public void addChild(Celda c) {
		child = c;
	}

	@Override
	public void removeChild() {
		child = null;
	}

	@Override
	public Celda getChild() {
		return child;
	}
}
