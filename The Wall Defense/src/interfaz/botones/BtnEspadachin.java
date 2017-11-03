package interfaz.botones;

import javax.swing.ImageIcon;
import interfaz.Escenario;
import jugador.Espadachin;
import jugador.Jugador;
import mapa.Celda;

/*
 * Clase BtnEspadachin.
 * Clase encargada del boton para el despliegue de un espadachin.
 */

public class BtnEspadachin extends BtnJugador {
	
	//Atributos locales.
	protected static final long serialVersionUID = 1L;
	
	//Constructor
	public BtnEspadachin(Escenario e) {
		super(e);
		Celda [] c = new Celda[4];
		player=new Jugador(c, 2, new Espadachin());
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/jonsnow.png")));
	};
	
	//Metodos heredados.
	public void create() {
		stage.getMapa().crearJugador(player);
	}

}
