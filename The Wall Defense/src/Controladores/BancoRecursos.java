package Controladores;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class BancoRecursos {
	
	protected Player player;
	
	public BancoRecursos() {
		try {
			player = new Player(getClass().getResourceAsStream("/resources/static/disparo/arrow_shot.mp3"));
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	};
	
	public void playShot() {
		try {
			player.play();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
     
	
	

}
