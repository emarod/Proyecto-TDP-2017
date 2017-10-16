package Controladores;

import java.util.concurrent.ConcurrentLinkedDeque;

import main.Unidad;

public abstract class Controlador implements Runnable{
	
	protected ConcurrentLinkedDeque<Unidad> repositorio;	
	protected Unidad unidadActual;
	protected int unidades=0;
	protected volatile boolean activo=false;
	
	
	public synchronized void activar(Unidad unidad) {		
		repositorio.addLast(unidad);
		unidadActual=unidad;
		unidades++;
	}


	public abstract void run();
	
	public synchronized void desactivar(Unidad unidad) {
		repositorio.remove(unidad);
		unidades--;
	}
	
	public abstract void iniciar();
	
	public abstract void terminar();
	
	public boolean getActivo() {
		return activo;
	}
}
