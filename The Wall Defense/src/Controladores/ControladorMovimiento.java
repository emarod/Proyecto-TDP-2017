package Controladores;

import java.util.concurrent.ConcurrentLinkedDeque;

import main.Unidad;

public class ControladorMovimiento extends Controlador{
	
	public ControladorMovimiento(){
		repositorio= new ConcurrentLinkedDeque<Unidad>();		
	}

	@Override
	public void run() {
		activo=true;
		while(activo){
			unidadActual= repositorio.pollFirst();
			if (unidadActual!=null){
				repositorio.addLast(unidadActual);
				if(!unidadActual.getMoviendo()) {
					unidadActual.mover();
				}
			}
			try {
				Thread.sleep(50);
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
	
	public void congelar(Unidad unidad,boolean b) {
		unidad.setCongelar(b);
	}
	
	public void retrasar(Unidad unidad, int i) {
		unidad.setRetraso(i);
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void terminar() {
		// TODO Auto-generated method stub
		
	}
}
