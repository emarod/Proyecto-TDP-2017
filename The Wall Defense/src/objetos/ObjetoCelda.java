package objetos;

import javax.swing.JLabel;

import main.Visitor;
import mapa.Celda;

public interface ObjetoCelda {

	public abstract Celda getCelda();

	public abstract void setCelda(Celda c);

	public abstract JLabel getGrafico();

	public abstract void setGrafico(JLabel j);

	public abstract void setGrafico(int i);

	public abstract void crear();

	public abstract void crearMulticelda();

	public abstract void intercambiar_celdas(Celda C);

	public abstract boolean accept(Visitor V);

	public abstract void setProfundidad(int i);

	public abstract int getProfundidad();

	public abstract void destruir();

}
