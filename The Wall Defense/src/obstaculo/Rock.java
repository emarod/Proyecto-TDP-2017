package obstaculo;
import javax.swing.*;
import main.Visitor;
import mapa.Celda;
public class Rock extends Obstaculo implements Runnable{
	private int resistencia;
	private int sprite;
    public Rock(Celda c,int prof,int sprite){
    	profundidad=prof;
    	celda=c;
    	this.sprite=sprite;
    	resistencia=3;
    	grafico=new JLabel();
    	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/roca_"+sprite+".png")));  	
    }
    public int getResistencia(){
    	return resistencia;
    }
    public void restarResistencia(){
    	if(resistencia==1){
    		destruir();
    	}else{
    		resistencia--;
    	}
    }
    public boolean Accept(Visitor V){
    	return V.VisitRock(this);
    }
    public int getSprite(){
    	return sprite;
    }
    public void destruir(){
    }
    public void run(){}

}
