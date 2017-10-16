package Controladores;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import main.Unidad;

public class Director{

	protected ControladorAtaque cntrAtaque;
	protected ControladorMovimiento cntrMovimiento;
	ScheduledExecutorService taskPool;
	protected volatile boolean activo;	
	
	public Director(){
		taskPool = Executors.newScheduledThreadPool(4);
		cntrAtaque = new ControladorAtaque(this);
		cntrMovimiento = new ControladorMovimiento(this);		
		
	}	
	
	public void activarAtaque(Unidad unidad) {
		cntrAtaque.activar(unidad);
	}
	
	public void activarMovimiento(Unidad unidad) {
		cntrMovimiento.activar(unidad);
	}
	
	public void terminar(Unidad unidad) {
		
	}

	public void desactivarMovimiento(Unidad unidad) {
		cntrMovimiento.desactivar(unidad);
		
	}
	
	public void desactivarAtaque(Unidad unidad) {
		cntrAtaque.desactivar(unidad);
		
	}
	
	public ScheduledFuture<?> ejecutar(Unidad d,int delay) {
		return taskPool.scheduleWithFixedDelay(d,0,32,TimeUnit.MILLISECONDS);
	}
}
