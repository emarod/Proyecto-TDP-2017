package comprables;

import main.GameObject;
import main.Visitor;

public abstract class Comprable extends GameObject {

	public Comprable() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean accept(Visitor V) {
		// TODO Auto-generated method stub
		return false;
	}

}
