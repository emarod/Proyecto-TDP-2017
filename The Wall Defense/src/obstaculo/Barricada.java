package obstaculo;

import javax.swing.*;
import main.Visitor;

/*
 * Clase Rock
 * Clase que determina como esta compuesta y como se comporta una roca.
 */

public class Barricada extends PerfilObstaculo{
	
	//Constructor.
    public Barricada(){
    	resistencia=4;
    	graficos= new Icon[3];
    	graficos[0]=new ImageIcon(this.getClass().getResource("/resources/static/terrenos/barricada/barricada_1.png"));
		graficos[1]=new ImageIcon(this.getClass().getResource("/resources/static/terrenos/barricada/barricada_2.png"));
		graficos[2]=new ImageIcon(this.getClass().getResource("/resources/static/terrenos/barricada/barricada_3.png"));
    }
    
    //Metodos locales.
    public int getResistencia(){
    	return resistencia;
    }
    
    //Metodos heredados.
    
    public boolean accept(Visitor V){
    	return V.visitObstaculo(this.obstaculo);
    }
    
    public void restarResistencia(int ataque){
    	playSound();
    	if(resistencia<=ataque){
    		obstaculo.destruir();
    	}
    	else{
    		resistencia = resistencia - ataque;
    		setGrafico(resistencia-1);
    	}
    }
    
    public void setGrafico(int i) {
		obstaculo.getGrafico().setIcon(graficos[i]);
	}
    
    public void setObstaculo(Obstaculo obstaculo){
		this.obstaculo = obstaculo;
	}
    
    public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/static/terrenos/barricada/barricada_3.png"));
		grafico.setIcon(imagen);		
	}
    
    public PerfilObstaculo clone() {
		return new Barricada();
	}
    
    public void playSound() {
		obstaculo.getBancoRecursos().playBarricada();
	}
}
