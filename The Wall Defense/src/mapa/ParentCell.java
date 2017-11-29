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
		}
		else {
			c.setChild(child);
			child = c;
		}

	}

	@Override
	public void setChild(Celda c) {
		child = c;
	}

	@Override
	public void setTail(Celda c) {
		tail = c;
	}

	@Override
	public void removeChild() {
		if (child == null) {
			throw new UnsupportedOperationException("Operacion no soportada");
		}

		if (child == tail) {
			System.out.println("TAIL");
			child.setChild(null);
			child.setTail(null);
			child = null;
			tail = null;
		}
		else {
			Celda c = child;
			child = c.getChild();
			c.setChild(null);
			c.setTail(null);
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

}
