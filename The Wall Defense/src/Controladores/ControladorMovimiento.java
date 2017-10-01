package Controladores;

import java.util.LinkedList;

import main.Unidad;

public class ControladorMovimiento extends Controlador{
	
	public ControladorMovimiento(){
		hilo = new Thread(this);
		repositorio= new LinkedList<Unidad>();
//		hilo.start();
	}

	@Override
	public void run() {		
		while(true) {
//				System.out.println("unidad.mover()");
				unidadActual= repositorio.removeFirst();
				repositorio.addLast(unidadActual);
				unidadActual.mover();
		}
	}

	@Override
	public boolean desactivar(Unidad unidad) {
		unidad.setMovimiento(false);
		repositorio.remove(unidad);
		return false;
	}

	@Override
	public void activar(Unidad unidad) {
		super.activar(unidad);
		unidad.setMovimiento(true);
	}
	
	public void congelar(Unidad unidad,boolean b) {
		unidad.setCongelar(b);
	}
	
	public void retrasar(Unidad unidad, int i) {
		unidad.setRetraso(i);
	}
}
