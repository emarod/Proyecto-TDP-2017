package obstaculo;

import javax.swing.JLabel;
import Controladores.BancoRecursos;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

/*
 * Clase abstracta Obstaculo.
 * Generaliza la idea de un obstaculo.
 */

public class Obstaculo extends GameObject {
	
	//Atributos locales.
	protected JLabel imagen;
	protected int vidas;
	protected PerfilObstaculo tipo;
	protected BancoRecursos bancoRecursos;
	
	//Constructor.
    public Obstaculo(Celda[] c,int prof, PerfilObstaculo t){
    	 profundidad=prof;
    	 celda=c;    	 
    	 grafico=new JLabel();
    	 tipo = t;
    	 setGrafico();    	 
    }
	
    //Metodos locales
    public void setGrafico(){
    	tipo.setGrafico(grafico);
    }
    
    public void restarResistencia(int ataque){
    	boolean destruir= (tipo.impact(ataque));
    	if(destruir){
    		destruir();
    	}
    	else{
    		tipo.restarResistencia(ataque); 
    	}
    }
    
	public Obstaculo clone(Celda[] c) {
		//Profundidad 2 predeterminada. Retorna una unidad de mismo tipo.
		PerfilObstaculo tipo = this.tipo.clone();
		Obstaculo clon = new Obstaculo(c, 3, tipo);
		tipo.setObstaculo(clon);
		return clon;
	}
	
	public boolean accept(Visitor V){
    	return V.visitObstaculo(this);
    }
	
	public BancoRecursos getBancoRecursos(){
		return bancoRecursos;
	}
	
	public void setBancoRecursos(BancoRecursos banco){
		bancoRecursos = banco;
	}
	
	public void dañar(int daño){
		tipo.dañar(daño);
	}
}
