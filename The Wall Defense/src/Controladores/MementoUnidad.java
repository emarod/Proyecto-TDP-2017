package Controladores;

public class MementoUnidad {

	protected int daño;
	protected int vida;
	protected int velocidad;

	public MementoUnidad(int d, int v, int vel) {
		daño = d;
		vida = v;
		velocidad = vel;
	}

	public int getDaño() {
		return daño;
	}

	public int getVida() {
		return vida;
	}

	public int getVelocidad() {
		return velocidad;
	}

}
