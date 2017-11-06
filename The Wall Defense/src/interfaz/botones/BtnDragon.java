package interfaz.botones;

import javax.swing.ImageIcon;
import interfaz.Escenario;
import jugador.Dragon;
import jugador.Jugador;
import mapa.Celda;

/*
 * Clase BtnDrgon.
 * Clase encargada del boton para el despliegue de un dragon.
 */

public class BtnDragon extends BtnJugador {
	
	//Atributos locales.
	protected static final long serialVersionUID = 1L;

	//Constructor.
	public BtnDragon(Escenario e) {
		super(e);
		Celda [] c = new Celda[4];
		player=new Dragon(c, 2);
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/dragon.png")));
	}
	
	//Metodos heredados.
	public void create() {
		stage.getMapa().crearJugadorLargo(player);		
		
	}

}
