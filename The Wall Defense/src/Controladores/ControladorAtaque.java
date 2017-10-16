package Controladores;

import main.Unidad;

public class ControladorAtaque extends Controlador{
	
	public ControladorAtaque(Director d){
		super(d);		
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
		activo=true;		
	}

	@Override
	public void terminar() {
		activo=false;		
	}
}
