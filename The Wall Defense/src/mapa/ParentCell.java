package mapa;

import java.util.LinkedList;
import java.util.List;

public class ParentCell extends Celda {

	protected List<Celda> children;

	public ParentCell(int posX, int posY) {
		super(posX, posY);
		children = new LinkedList<Celda>();
	}

	@Override
	public void addChild(Celda c) {
		children.add(c);
	}

	@Override
	public void removeChild(Celda c) {
		children.remove(c);
	}

	@Override
	public List<Celda> getChildren(Celda c) {
		return children;
	}
}
