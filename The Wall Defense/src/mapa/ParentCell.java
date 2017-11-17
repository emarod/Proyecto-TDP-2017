package mapa;

public class ParentCell extends Celda {

	protected Celda child;
	protected Celda tail;

	public ParentCell(int posX, int posY) {
		super(posX, posY);
		child = null;
	}

	@Override
	public void addChild(Celda c) {
		if (hijos == 0) {
			child = tail = c;
		}
		else {
			tail.addChild(c);
			tail = c;
		}
		hijos++;

	}

	@Override
	public void removeChild() {
		if (hijos == 0) {
			throw new UnsupportedOperationException("Operacion no soportada");
		}
		child = child.getChild();
		hijos--;
		if (hijos == 0) {
			child = null;
			tail = null;
		}
	}

	@Override
	public Celda getChild() {
		return child;
	}

	@Override
	public int size() {
		return hijos;
	}

}
