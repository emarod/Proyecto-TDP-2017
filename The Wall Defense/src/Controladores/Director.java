package Controladores;

import main.Unidad;

public class Director implements Runnable{

	protected ControladorAtaque cntrAtaque;
	protected ControladorMovimiento cntrMovimiento;
	protected Thread hiloAtaque;
	protected Thread hiloMovimiento;
	protected Thread hilo;
	protected volatile boolean activo;
	
	
	public Director() {
		hilo = new Thread(this);
		cntrAtaque = new ControladorAtaque();
		hiloAtaque = new Thread(cntrAtaque);
		cntrMovimiento = new ControladorMovimiento();
		hiloMovimiento = new Thread(cntrMovimiento);
		hiloAtaque.start();
		hiloMovimiento.start();		
		
		
	}
	
	public void run() {		
	}
	
	public void activarAtaque(Unidad unidad) {
		cntrAtaque.activar(unidad);
	}
	
	public void activarMovimiento(Unidad unidad) {
		cntrMovimiento.activar(unidad);
	}
	
	public void iniciar() {
		hilo.start();
		activo=true;
	}
	
	public void terminar() {
		activo=false;
	}

	public void desactivarMovimiento(Unidad unidad) {
		cntrMovimiento.desactivar(unidad);
		
	}
	
	public void desactivarAtaque(Unidad unidad) {
		cntrAtaque.desactivar(unidad);
		
	}
}
