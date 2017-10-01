package Controladores;

import java.util.LinkedList;

import main.Unidad;

public class ControladorAtaque extends Controlador{
	
	public ControladorAtaque(){
		hilo = new Thread(this);
		repositorio = new LinkedList<Unidad>();
	}

	@Override
	public void run() {
		while(true) {
			unidadActual= repositorio.removeFirst();
			repositorio.addLast(unidadActual);
			unidadActual.atacar();			
		}
	}

	@Override
	public boolean desactivar(Unidad unidad) {		
		unidad.setAtacar(false);
		repositorio.remove(unidad);
		return true;
	}

	@Override
	public void activar(Unidad unidad) {
		super.activar(unidad);		
		unidad.setAtacar(true);
		unidad.atacar();
	}
}
