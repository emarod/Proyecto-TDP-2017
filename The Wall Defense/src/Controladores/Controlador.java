package Controladores;

import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;

import main.Unidad;

public abstract class Controlador implements Runnable{
	
	protected Thread hilo;
	protected ConcurrentLinkedDeque<Unidad> repositorio;	
	protected Unidad unidadActual;
	protected int unidades=0;
	
	public void activar(Unidad unidad) {		
		repositorio.addLast(unidad);
		unidadActual=unidad;
		unidades++;	
	}


	public void run() {
		
	}
	
	public void desactivar(Unidad unidad) {
		repositorio.remove(unidad);
		unidades--;
	}
	
}
