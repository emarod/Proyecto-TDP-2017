package Controladores;

import java.util.concurrent.ConcurrentLinkedDeque;

import main.Unidad;

public class ControladorMovimiento extends Controlador{
	
	public ControladorMovimiento(Director d){
		super(d);		
	}
	
	public void desactivar(Unidad unidad) {
		super.desactivar(unidad);		
	}

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
