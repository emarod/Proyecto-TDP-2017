package Controladores;

import java.util.LinkedList;

import main.Unidad;

public class ControladorMovimiento extends Controlador{
	
	public ControladorMovimiento(){
		hilo = new Thread(this);
		repositorio= new LinkedList<Unidad>();
		hilo.start();
	}

	@Override
	public void run() {
		while(!esperar) {
			for (Unidad unidad : repositorio) {
				unidad.mover();
			}
		}
	}

	@Override
	public boolean desactivar(Unidad unidad) {
		 unidad.setMovimiento(false);
		 repositorio.remove(unidad);
		return false;
	}

	@Override
	public synchronized boolean activar(Unidad unidad) {
		System.out.println("Activar");
		unidad.setMovimiento(true);
		liberarRepo();
		try {
			System.out.println("Esperando que muera el hilo");
			hilo.join();
			System.out.println("Murio el hilo");
			repositorio.addFirst(unidad);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		devolverRepo();
		hilo.start();
		return true;
	}
	
	public void congelar(Unidad unidad,boolean b) {
		unidad.setCongelar(b);
	}
	
	public void retrasar(Unidad unidad, int i) {
		unidad.setRetraso(i);
	}
}
