package Controladores;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

/*
 * Esta clase es la encargada de la reproduccion de sonidos.
 */
public class BancoRecursos {
	
	//Atributos locales.
    protected Sound flecha;
    protected Sound bola_fuego;
    protected Sound click;
	
    //Constructor.
	public BancoRecursos() {
		TinySound.init();
		//Cancion que se reproduce e forma infinita en el juego.
		Music song = TinySound.loadMusic("/resources/sound/theme_song.ogg");
		flecha = TinySound.loadSound("/resources/sound/laser4.wav");
		bola_fuego = TinySound.loadSound("/resources/sound/bola_fuego.wav");
		click=TinySound.loadSound("/resources/sound/mouseclick.wav");
		//Inicializa el loop
		song.play(true);
		
	};
	
	//Metodos locales.
	//Sonido de la flecha.
	public void playFlecha() {
		flecha.play();
	}
	
	//Sonido de la bola de fuego.
	public void playBolaFuego() {
		bola_fuego.play();
	}
	
	//Sonido para cada click.
	public void playClick() {
		click.play();
	}
	
     
	
	

}
