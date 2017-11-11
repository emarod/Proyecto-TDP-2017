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
		
		//Metodos locales.
		public boolean impact(int ataque){
			boolean impacta = resistencia<=ataque;
	    	if(resistencia<=ataque) {
	    		System.out.println("Barrica destruida en resistencia "+resistencia);
	    	}
	    	return impacta;
	    }
		
	    public Obstaculo getObstaculo() {
			return obstaculo;
		}
	    
		//Metodos abstractos.
	    public abstract void setObstaculo(Obstaculo obstaculo);    
		public abstract void setGrafico(JLabel grafico);
		public abstract void playSound();
		public abstract PerfilObstaculo clone();
		public abstract void restarResistencia(int ataque);
}
