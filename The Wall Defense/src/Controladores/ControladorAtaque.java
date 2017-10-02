package Controladores;

import java.util.concurrent.ConcurrentLinkedDeque;

import main.Unidad;

public class ControladorAtaque extends Controlador{
	
	public ControladorAtaque(){
		hilo = new Thread(this);
		repositorio = new ConcurrentLinkedDeque<Unidad>();
		hilo.start();
	}

	@Override
	public void run() {
		while(true) {
			unidadActual= repositorio.pollFirst();
			if (unidadActual!=null){
				repositorio.addLast(unidadActual);	
				unidadActual.atacar();
			}
		}
	}

	@Override
	public void desactivar(Unidad unidad) {
		super.desactivar(unidad);
		unidad.setAtacar(false);
	}

	@Override
	public void activar(Unidad unidad) {
		super.activar(unidad);		
		unidad.setAtacar(true);
		unidad.atacar();
	}
}
