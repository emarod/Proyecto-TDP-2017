package enemigo;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class EnemigoRun implements Runnable{
	private Enemigo e;
	private Thread t;
	private boolean parar=false;

	public EnemigoRun(Enemigo e){
	   this.e=e;
	   t=new Thread(this);
	   t.start();
	   
	}
	
	public void run(){    	
    	
    }
	
	public void parar(){
	   parar=true;
	}
    
	public void parar(int n){
		t.interrupt();
	}
    
}
