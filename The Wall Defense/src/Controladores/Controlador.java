package Controladores;

import java.util.LinkedList;

import main.Unidad;

public abstract class Controlador implements Runnable{
	
	protected boolean esperar=false;
	protected Thread hilo;
	protected LinkedList<Unidad> repositorio;
	
	public abstract boolean desactivar(Unidad unidad);
	
	public abstract boolean activar(Unidad unidad);
	
	protected void liberarRepo() {
		esperar=true;
	}
	
	protected void devolverRepo() {
		esperar=false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
