package Controladores;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

/*
 * Esta clase es la encargada de la reproduccion de sonidos.
 */
public class BancoRecursos {

	// Atributos locales.
	protected boolean efectos_activados = true;
	protected static BancoRecursos banco = null;
	protected Sound flecha;
	protected Sound bola_fuego;
	protected Sound click;
	protected Sound roca;
	protected Sound barricada;
	protected Music song;
	protected Sound explosion;

	// Constructor.
	private BancoRecursos() {
		TinySound.init();
		// Cancion que se reproduce e forma infinita en el juego.
		song = TinySound.loadMusic("/resources/sound/theme_song.ogg");
		flecha = TinySound.loadSound("/resources/sound/laser4.wav");
		bola_fuego = TinySound.loadSound("/resources/sound/bola_fuego.wav");
		click = TinySound.loadSound("/resources/sound/mouseclick.wav");
		roca = TinySound.loadSound("/resources/sound/golpe_roca.wav");
		barricada = TinySound.loadSound("/resources/sound/golpe_roca.wav");
		explosion = TinySound.loadSound("/resources/sound/explosion.wav");
		// Inicializa el loop
		song.play(true);

	};

	public static BancoRecursos newBancoRecursos() {
		if (banco == null) {
			banco = new BancoRecursos();
		}
		return banco;
	}

	// Metodos locales.
	// Sonido de la flecha.
	public void playFlecha() {
		if (efectos_activados) {
			flecha.play();
		}
	}

	public void playExplosion() {
		if (efectos_activados) {
			// explosion.play();
		}
	}

	// Sonido de la bola de fuego.
	public void playBolaFuego() {
		if (efectos_activados) {
			bola_fuego.play();
		}
	}

	// Sonido para click de menu inicial.
	public void playClick() {
		if (efectos_activados) {
			click.play();
		}
	}

	// Sonido para golpe a piedra.
	public void playRoca() {
		if (efectos_activados) {
			roca.play();
		}
	}

	// Sonido para golpe a piedra.
	public void playBarricada() {
		if (efectos_activados) {
			barricada.play();
		}
	}

	public void stopEfectos() {
		efectos_activados = false;
	}

	public void stopMusica() {
		song.stop();
	}

	public void playEfectos() {
		efectos_activados = true;
	}

	public void playMusica() {
		song.play(true);
	}

}
