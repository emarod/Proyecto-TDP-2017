package Controladores;

import java.util.HashMap;
import java.util.Map;

public class CareTaker {

	private Map<String, MementoUnidad> savepoint;

	public CareTaker() {
		savepoint = new HashMap<String, MementoUnidad>();
	}

	public void saveMemento(MementoUnidad mementoUnidad, String save) {
		savepoint.put(save, mementoUnidad);
	}

	public MementoUnidad getMemento(String save) {
		return savepoint.get(save);
	}

	public void clearSavepoint() {
		savepoint.clear();
	}

}
