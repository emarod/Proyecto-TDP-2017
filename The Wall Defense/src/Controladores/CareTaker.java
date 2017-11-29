package Controladores;

import java.util.HashMap;
import java.util.Map;

public class CareTaker {

	private Map<Integer, MementoUnidad> savepoint;

	public CareTaker() {
		savepoint = new HashMap<Integer, MementoUnidad>();
	}

	public void saveMemento(MementoUnidad mementoUnidad, int save) {
		savepoint.put(save, mementoUnidad);
	}

	public MementoUnidad getMemento(int save) {
		return savepoint.get(save);
	}

	public void clearSavepoint() {
		savepoint.clear();
	}

	public void clearSavepoint(int i) {
		savepoint.remove(i);
	}

}
