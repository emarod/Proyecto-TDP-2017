package Controladores;

import java.util.LinkedList;

import main.Unidad;
import main.Visitor;

public class ControladorAtaque extends Controlador{
	
	public ControladorAtaque(){
		hilo = new Thread(this);
		repositorio = new LinkedList<Unidad>();		
		hilo.start();
	}

	@Override
	public void run() {
		while(true) {
			while(esperar) {
				System.out.println("ESPERAR");
				pausado=true;
				if(!esperar)
					pausado=false;
			};
			if(repositorio.size()== 0) {
				unidadActual=repositorio.getFirst();			
				System.out.println("atacar");
				unidadActual.atacar();
				
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
	public void activar(Unidad unidad) {
		super.activar(unidad);		
		unidad.setAtacar(true);
		unidad.atacar();
	}
}
