package enemigo;

import javax.swing.JLabel;

import interfaz.Escenario;
import mapa.Celda;
import mapa.Map;

public class Horda {
	
	protected Enemigo horda[];
	protected Celda celda;
	protected Map mapa;
	protected Escenario stage;
	protected JLabel graf;
	protected int enemigos=0;
	
	public Horda(Escenario s){	
		stage=s;
		mapa=stage.getMapa();
		horda=new Enemigo[1];
		inicializarHorda();
		//ejecutar();
	}
	
	public void inicializarHorda(){
		
		int y=(int) (Math.random() * 5);
		horda[0]=new Enemigo(mapa.getCelda(15, y),1,new WhiteWalker());
		y=(int) (Math.random() * 5);
		//horda[1]=new Enemigo(mapa.getCelda(15, y),1,new NightKing());
		//horda[1].activar();
		/*horda[0].getState().setEnemigo(horda[0]);
		horda[0].getCelda().getObjects()[1]=horda[0];
		horda[0].setCelda(mapa.getCelda(15, y));
		horda[0].getGrafico().setBounds(64*15,64*y,64,64);
		
		y=(int) (Math.random() * 5);
		horda[1]=new Enemigo(mapa.getCelda(15, y),1,new NightKing());
		horda[1].getState().setEnemigo(horda[1]);
		horda[1].getCelda().getObjects()[1]=horda[1];
		horda[1].setCelda(mapa.getCelda(15, y));
		horda[1].getGrafico().setBounds(64*15,64*y,64,64);*/
		
	}
	
	public void ejecutar() {
			
			stage.agregar(horda[0].getGrafico(), new Integer(2));
			stage.agregar(horda[1].getGrafico(), new Integer(2));
			//horda[0].activar(10);
			//horda[1].activar(10);

			enemigos++;
	}
	
	
}
