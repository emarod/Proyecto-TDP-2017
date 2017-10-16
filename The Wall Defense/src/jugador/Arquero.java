package jugador;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoPlayer;

public class Arquero extends State{
	
	public Arquero() {
		resistencia=5;
		disparos_simultaneos=1;
		disparos_en_ejecucion=0;
		velocidad_disparo=10;
		
	}
	
	public void setJugador(Jugador jugador){
		this.jugador = jugador;
		this.jugador.getCelda().getDirector().activarAtaque(this.jugador);
	}
	
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/Ygritte.gif"));
		grafico.setIcon(imagen);
	}
	
	public void atacar(){
//		int xCelda=jugador.getCelda().getPosX();
//		int yCelda=jugador.getCelda().getPosY();
//		for(int x =0;jugador.getCelda().getPosX()<19 && atacar;x++) {
//			Celda siguiente = jugador.getCelda().getCelda(xCelda+1,yCelda);
//			GameObject objeto =siguiente.getObjects()[2];					
//			if (objeto!=null && !objeto.Accept(jugador.getVisitor())){
//				atacar=false;
//			}
//		}
		jugador.setAtacar(true);
		if(disparos_en_ejecucion<disparos_simultaneos){
			new DisparoPlayer(this,3,velocidad_disparo);
			
    		disparos_en_ejecucion++;
    	}
		jugador.setAtacar(false);
    }
    
    public void restarDisparosEnEjecucion(){
    	disparos_en_ejecucion--;
    }
    
    public int getDisparosEnEjecucion(){
    	return disparos_en_ejecucion;
    }

	@Override
	public void setGraficos(Icon[] graficos, JLabel grafico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public State clone() {
		return new Arquero();
	}
    
}
