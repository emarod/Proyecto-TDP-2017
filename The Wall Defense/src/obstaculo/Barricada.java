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
    	resistencia=3;
    	graficos= new Icon[3];
    	graficos[0]=new ImageIcon(this.getClass().getResource("/resources/static/terrenos/barricada/barricada_1.png"));
		graficos[1]=new ImageIcon(this.getClass().getResource("/resources/static/terrenos/barricada/barricada_2.png"));
		graficos[2]=new ImageIcon(this.getClass().getResource("/resources/static/terrenos/barricada/barricada_3.png"));
    }
    
    //Metodos locales.
    public int getResistencia(){
    	return resistencia;
    }
    
    public void destruir(){
	   
	}
    
    //Metodos heredados.
    public void run(){
    	
    }
    
    public boolean accept(Visitor V){
    	return V.visitObstaculo(this.obstaculo);
    }
    
    public void restarResistencia(int ataque){
    	resistencia = resistencia - ataque;
    	setGrafico(resistencia);
    }
    
    public void setGrafico(int i) {
		obstaculo.getGrafico().setIcon(graficos[i]);
	}
    
    public void setObstaculo(Obstaculo obstaculo){
		this.obstaculo = obstaculo;
	}
    
    public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/static/terrenos/barricada/barricada_3.png"));
		graph=0;
		grafico.setIcon(imagen);		
	}
    
    public PerfilObstaculo clone() {
		return new Barricada();
	}
    
    public void dañar(int daño){
    	restarResistencia(daño);
    }
    
    public void playSound() {
		obstaculo.getBancoRecursos().playBarricada();
	}
}
