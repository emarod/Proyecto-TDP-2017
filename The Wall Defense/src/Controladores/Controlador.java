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
		boolean agregado = false;
		liberarRepo();
		while (!agregado)
			if(pausado) {
				repositorio.addLast(unidad);
				unidades++;
				agregado=true;
		}		
		devolverRepo();		
	}
	
	protected void liberarRepo() {
		System.out.println("Liberar");
		esperar=true;
	}
	
	protected void devolverRepo() {
		System.out.println("Devolcer");
		esperar=false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
