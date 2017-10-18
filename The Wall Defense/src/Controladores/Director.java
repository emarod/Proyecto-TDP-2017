package Controladores;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import main.Unidad;

public class Director{

	ScheduledExecutorService taskPool;		
	
//	Crea un pool de hilos. Mantiene un flujo de ejecución de tareas, actualmente 
//	haciendo uso de un solo hilo.
	
	public Director(){		
//		taskPool = Executors.newScheduledThreadPool(2);
		taskPool = Executors.newSingleThreadScheduledExecutor();		
		
	}

	public boolean desactivar(Unidad unidad) {
		return unidad.getTask().cancel(true);
		
	}
		
	public ScheduledFuture<?> ejecutar(Unidad d,int delay) {
		return taskPool.scheduleWithFixedDelay(d,0,100*delay,TimeUnit.MILLISECONDS);
	}
}
