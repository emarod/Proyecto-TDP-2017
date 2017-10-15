package Controladores;

import java.util.concurrent.ConcurrentLinkedDeque;

import main.Unidad;

public class ControladorMovimiento extends Controlador{
	
	public ControladorMovimiento(){
		hilo = new Thread(this);
		repositorio= new ConcurrentLinkedDeque<Unidad>();
		hilo.start();
	}

	@Override
	public void run() {
		while(true) {
			unidadActual= repositorio.pollFirst();
			if (unidadActual!=null){
				repositorio.addLast(unidadActual);
				if(!unidadActual.getMoviendo()) {
					unidadActual.mover();
				}
			}
		}
	}

	@Override
	public void desactivar(Unidad unidad) {
		super.desactivar(unidad);		
	}

	@Override
	public void activar(Unidad unidad) {
		super.activar(unidad);		
		
	}
	
	public void congelar(Unidad unidad,boolean b) {
		unidad.setCongelar(b);
	}
	
	public void retrasar(Unidad unidad, int i) {
		unidad.setRetraso(i);
	}
}
