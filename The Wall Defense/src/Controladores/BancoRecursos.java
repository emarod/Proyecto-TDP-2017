package Controladores;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

public class BancoRecursos {
	
    protected Sound flecha;
    protected Sound bola_fuego;
    protected Sound click;
	
	public BancoRecursos() {
		
		TinySound.init();
		Music song = TinySound.loadMusic("/resources/sound/theme_song.ogg");
		flecha = TinySound.loadSound("/resources/sound/laser4.wav");
		bola_fuego = TinySound.loadSound("/resources/sound/bola_fuego.wav");
		click=TinySound.loadSound("/resources/sound/mouseclick.wav");
		//start playing the music on loop
		//song.play(true);
		
	};
	
	public void playFlecha() {
		flecha.play();
	}
	
	public void playBolaFuego() {
		bola_fuego.play();
	}
	
	public void playClick() {
		click.play();
	}
	
     
	
	

}
