package mapa;

public class ParentCell extends Celda {

	protected Celda child;

	public ParentCell(int posX, int posY) {
		super(posX, posY);
		child = null;
	}

	@Override
	public void addChild(Celda c) {
		if (child != null) {
			c.addChild(child);
			child = c;
		}
		else {
			child = c;
		}
		hijos++;

	}

	@Override
	public void removeChild() {
		if (child != null) {
			child = child.getChild();
			hijos--;
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
