package obstaculo;

import javax.swing.*;

/*
 * Clase abstracta PerfilJugador.
 * Clase que generaliza la idea de las caracteristicas especificas para un jugador en especifico.
 */

public abstract class PerfilObstaculo {
		
		//Atributos locales.
		protected int resistencia;
		protected Obstaculo obstaculo;
		protected Icon[] graficos;
		protected int graph;
		
		//Metodos locales.
		public boolean impact(int ataque){
	    	if(resistencia<=ataque) {
	    		System.out.println("Barrica destruida en resistencia "+resistencia);
	    		return true;
	    	}
	    	else{
	    		resistencia = resistencia - ataque;
	    		return false;
	    	}
	    }
		
	    public Obstaculo getObstaculo() {
			return obstaculo;
		}
	    
		//Metodos abstractos.
	    public abstract void setObstaculo(Obstaculo obstaculo);    
		public abstract void setGrafico(JLabel grafico);
		public abstract void playSound();
		public abstract void destruir();
		public abstract PerfilObstaculo clone();
		public abstract void restarResistencia(int ataque);
		public abstract void dañar(int daño);
}
