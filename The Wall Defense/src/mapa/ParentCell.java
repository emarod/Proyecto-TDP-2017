package mapa;

public class ParentCell extends Celda {

	protected Celda child;
	protected Celda tail;

	public ParentCell(int posX, int posY) {
		super(posX, posY);
		child = null;
		tail = null;
	}

	@Override
	public void addChild(Celda c) {
		if (tail == null) {
			child = c;
			tail = child;
			hijos++;
		}
		else {
			c.addChild(tail);
			child = c;
		}

	}

	@Override
	public void removeChild() {
		if (hijos == 0) {
			throw new UnsupportedOperationException("Operacion no soportada");
		}
		child.removeTail();
		child = child.getChild();
		hijos--;
		if (child == tail) {

			child = null;
			tail = null;
		}
	}

	@Override
	public void removeTail() {
		tail = null;
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
