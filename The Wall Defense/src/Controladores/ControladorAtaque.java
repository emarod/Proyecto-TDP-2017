package Controladores;

import java.util.LinkedList;

import main.Unidad;

public class ControladorAtaque extends Controlador{
	
	public ControladorAtaque(){
		hilo = new Thread(this);
		repositorio = new LinkedList<Unidad>();
		hilo.start();
	}

	@Override
	public void run() {
		while(!esperar) {
			for (Unidad unidad : repositorio) {
				unidad.atacar();
			}
		}
	}

	@Override
	public boolean desactivar(Unidad unidad) {		
		unidad.setAtacar(false);
		repositorio.remove(unidad);
		return true;
	}

	@Override
	public boolean activar(Unidad unidad) {
		unidad.setAtacar(true);
		liberarRepo();		
		try {
			hilo.join();
			repositorio.addLast(unidad);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		devolverRepo();
		return true;
	}
}
