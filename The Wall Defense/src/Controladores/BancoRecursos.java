package src.Controladores;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

public class BancoRecursos {
	
    protected Sound flecha;
    protected Sound bola_fuego;
	
	public BancoRecursos() {
		
		//initialize TinySound
		TinySound.init();
		//load a sound and music
		//note: you can also load with Files, URLs and InputStreams
		//Music song = TinySound.loadMusic("/resources/sound/intro.wav");
		//flecha = TinySound.loadSound("/resources/sound/laser4.wav");
		//bola_fuego = TinySound.loadSound("/resources/sound/bola_fuego.wav");
		//start playing the music on loop
		//song.play(true);
		//play the sound a few times in a loop
	};
	
	public void playFlecha() {
		flecha.play();
	}
	
	public void playBolaFuego() {
		bola_fuego.play();
	}
	
     
	
	

}
