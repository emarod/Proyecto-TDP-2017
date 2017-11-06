package interfaz.botones;

import javax.swing.ImageIcon;
import interfaz.Escenario;
import jugador.Caballero;
import jugador.Jugador;
import mapa.Celda;

/*
 * Clase BtnCaballero.
 * Clase encargada del boton para el despliegue de un caballero.
 */

public class BtnCaballero extends BtnJugador{
	
	//Atributos locales.
	protected static final long serialVersionUID = 1L;
	
	//Constructor.
	public BtnCaballero(Escenario e) {
		super(e);
		Celda [] c = new Celda[4];
		player=new Caballero(c, 2);
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/lannister.png")));
	};
	
	//Metodos heredados.
	public void create() {
		stage.getMapa().crearJugador(player);		
		
	}

}
