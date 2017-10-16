package Controladores;

import java.util.concurrent.ConcurrentLinkedDeque;

import main.Unidad;

public class ControladorAtaque extends Controlador{
	
	public ControladorAtaque(){
		repositorio = new ConcurrentLinkedDeque<Unidad>();
	}

	@Override
	public void run() {
		activo=true;
		while(activo){
			unidadActual= repositorio.pollFirst();
			if (unidadActual!=null){
				repositorio.addLast(unidadActual);
				if(!unidadActual.getMoviendo()) {
					unidadActual.atacar();
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

	@Override
	public void iniciar() {
				
	}

	@Override
	public void terminar() {
		// TODO Auto-generated method stub
		
	}
}
