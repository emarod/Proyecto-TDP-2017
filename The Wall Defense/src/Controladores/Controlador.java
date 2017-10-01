package Controladores;

import java.util.LinkedList;

import main.Unidad;

public abstract class Controlador implements Runnable{
	
	protected boolean esperar=false;
	protected boolean pausado=false;
	protected Thread hilo;
	protected LinkedList<Unidad> repositorio;
	protected Unidad unidadActual;
	protected int unidades=0;
	
	public abstract boolean desactivar(Unidad unidad);
	
	public void activar(Unidad unidad) {
		liberarRepo();
		System.out.println("Hilo pausado agregando unidad");
		repositorio.addLast(unidad);
		unidadActual=unidad;
		unidades++;		
		devolverRepo();
		if(!hilo.isAlive())
			hilo.start();
	}
	
	protected void pausar() {
		System.out.println("Pausar "+ this.getClass());
		pausado=true;
	}
	
	protected void reanudar() {
		System.out.println("Reaundar "+ this.getClass());
		pausado=false;
	}
	
	protected void liberarRepo() {
		System.out.println("Liberar "+ this.getClass());
		esperar=true;
	}
	
	protected void devolverRepo() {
		System.out.println("Devolcer");
		esperar=false;
		pausado=false;
	}	

	@Override
	public void run() {
		
	}
	
}
