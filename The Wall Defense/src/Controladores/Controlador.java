package Controladores;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ScheduledFuture;

import main.Unidad;

public abstract class Controlador{
	
	protected volatile boolean activo=false;
	protected Director director;
	
	public Controlador(Director d) {
		director=d;
	}
	
	public void activar(Unidad unidad) {
		director.ejecutar(unidad, 1);
	}
	
	public void desactivar(Unidad unidad) {
		unidad.getTask().cancel(true);
	}
	
	public abstract void iniciar();
	
	public abstract void terminar();
	
	public boolean getActivo() {
		return activo;
	}
}
