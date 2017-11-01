package interfaz.botones;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import jugador.Dragon;
import jugador.Jugador;
import mapa.Celda;

public class BtnDragon extends BtnJugador {

	protected static final long serialVersionUID = 1L;

	public BtnDragon(Escenario e) {
		super(e);
		Celda [] c = new Celda[4];
		player=new Jugador(c, 2, new Dragon());
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/dragon.png")));
	}

	public void create() {
		stage.getMapa().crearJugadorLargo(player);		
		
	}

}
